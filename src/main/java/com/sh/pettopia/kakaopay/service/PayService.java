package com.sh.pettopia.kakaopay.service;

import com.sh.pettopia.choipetsitter.dto.ReservationDto;
import com.sh.pettopia.choipetsitter.entity.Order;
import com.sh.pettopia.choipetsitter.entity.Reservation;
import com.sh.pettopia.choipetsitter.repository.OrderRepository;
import com.sh.pettopia.choipetsitter.repository.ReservationRepository;
import com.sh.pettopia.kakaopay.dto.KakaoApproveResponse;
import com.sh.pettopia.kakaopay.dto.KakaoCancelResponse;
import com.sh.pettopia.kakaopay.dto.KakaoPayReadyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class PayService {
    final ReservationRepository reservationRepository;
//    final PayRepository payRepository;
    final OrderRepository orderRepository;

    static final String cid = "TC0ONETIME";// 테스트 코드
    @Value("${my.admin}")
    private String ADMIN_KEY;

    private KakaoPayReadyResponse kakaoPayReadyResponse;

    public KakaoPayReadyResponse kakaoPayReady(ReservationDto dto) {
        log.info("payservice / kakaoPayReady");
        MultiValueMap<String,Object> payParams = new LinkedMultiValueMap<>();
        payParams.add("cid", cid); //테스트 결제는 가맹점 코드로 'TC0ONETIME'를 사용
        payParams.add("partner_order_id", dto.getPartnerOrderId()); //일단 아무값이나 hard coding.
        payParams.add("partner_user_id", dto.getPetSitterId()); //일단 아무값이나 hard coding.
        payParams.add("item_name", dto.getItem_name());
        payParams.add("quantity", dto.getQuantity());
        payParams.add("total_amount", dto.getTotal_amount());
        payParams.add("tax_free_amount", dto.getTax_free_amount());
        payParams.add("approval_url","http://localhost:8080/pay/success?partner_order_id="+dto.getPartnerOrderId() ); //결제 성공시 넘어갈 url 핸들러로 간다
        payParams.add("cancel_url", "http://localhost:8080/pay/cancel?partner_order_id="+dto.getPartnerOrderId()); //결제 취소시 넘어갈 url
        payParams.add("fail_url", "http://localhost:8080/pay/fail"); //결제 실패시 넘어갈 url

        HttpEntity<Map> requestEntity = new HttpEntity<>(payParams, this.getheaders());
        RestTemplate template = new RestTemplate();
        String url = "https://kapi.kakao.com/v1/payment/ready";

        kakaoPayReadyResponse = template.postForObject(
                url,
                requestEntity,
                KakaoPayReadyResponse.class
        );
        System.out.println("kakaoPayReadyResponse = " + kakaoPayReadyResponse);
        return kakaoPayReadyResponse;
    }

    @Transactional
    public KakaoApproveResponse kakaoPayApprove(String pgToken,String partner_order_id) {
        log.info("PayService /kakaoPayApprove");

        MultiValueMap<String, Object> payParams = new LinkedMultiValueMap<>();
        Reservation reservation=reservationRepository.findByPartnerOrderId(partner_order_id);

        Order order=new Order().reservationToOrder(reservation);
        // 여기서 주문에 대한 값을 partner_order_id 이걸로 가져오고
        // tid값 저장하고, 후에 partner_order_id이 값으로 환불을 진행한다

        payParams.add("cid", cid); //테스트 결제는 가맹점 코드로 'TC0ONETIME'를 사용
        payParams.add("tid", kakaoPayReadyResponse.getTid());
        order.setTid(kakaoPayReadyResponse.getTid());
        payParams.add("partner_order_id", partner_order_id); // 여기는 주문 번호 호고
        payParams.add("partner_user_id",reservation.getPetSitterId()); // 여기는 펫시터의 아이디가 온다
        payParams.add("pg_token", pgToken);

        HttpEntity<Map> requestEntity = new HttpEntity<>(payParams, this.getheaders());
        RestTemplate template = new RestTemplate();
        String url = "https://kapi.kakao.com/v1/payment/approve";

        KakaoApproveResponse approveResponse = template.postForObject(
                url,
                requestEntity,
                KakaoApproveResponse.class
        );

          /*
          데이터베이스 저장 및 비즈니스 로직
          ...
          */
        orderRepository.save(order);

        return approveResponse;
    }

    private HttpHeaders getheaders() {
        HttpHeaders headers = new HttpHeaders();

        String auth = "KakaoAK " + ADMIN_KEY;
        headers.set("Authorization", auth);
        headers.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        return headers;
    }

    public KakaoCancelResponse kakaoCancel() {

        // 카카오페이 요청
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("tid", "환불할 결제 고유 번호");
        parameters.add("cancel_amount", "환불 금액");
        parameters.add("cancel_tax_free_amount", "환불 비과세 금액");
        parameters.add("cancel_vat_amount", "환불 부가세");

        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getheaders());

        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        KakaoCancelResponse cancelResponse = restTemplate.postForObject(
                "https://kapi.kakao.com/v1/payment/cancel",
                requestEntity,
                KakaoCancelResponse.class);

        return cancelResponse;
    }

    public Order findByPartnerOrderId(String partnerOrderId) {
        return orderRepository.findByPartnerOrderId(partnerOrderId);
    }
}