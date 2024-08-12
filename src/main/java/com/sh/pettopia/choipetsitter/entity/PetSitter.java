package com.sh.pettopia.choipetsitter.entity;

import com.sh.pettopia.Hojji.pet.entity.Pet;
import com.sh.pettopia.choipetsitter.dto.PetSitterRegisterDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity(name = "petsitter")
@Table(name = "tbl_petsitter")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PetSitter {
    // 펫 시터의 대한 프로필

    @Id
    @Column(name = "id")
    private String petSitterId; // 회원 아이디 = 멤버아이디

    @Column(name = "introduce")
    private String introduce; // 가벼운 소개

    @Column(name = "post_url")
    private String postUrl; // 홍보글 url

    @Column(name = "images_url_list")
    @ElementCollection
    private List<String> imagesUrlList; // 이건 소개하기 위한 이미지

    @Column(name = "profile_img")
    private String profileImg;

    @Column(name = "update_at")
    @LastModifiedDate
    private LocalDateTime updateAt;

    @Embedded
    private PetSitterAddress petSitterAddress;

    @Column(name = "available_dates")
    @ElementCollection
    private Set<String  > availableDates;

    @Column(name = "available_pet_size")
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<AvailablePetSize > availablePetSize;
    // 이용가능한 서비스 ( 빗질, 산책, 약 먹이기, 등등...)

    @Column(name = "available_service")
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<AvailableService > availableService;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    public PetSitter DtoToEntity(PetSitterRegisterDto dto)
    {
        return PetSitter.builder()
                .petSitterId(dto.getMemberId())
                .imagesUrlList(dto.getImageUrlList())
                .availableService(dto.getAvailableServices())
                .availablePetSize(dto.getAvailablePetSizes())
                .introduce(dto.getIntroduce())
                .postUrl(dto.getPostUrl())
                .petSitterAddress(dto.getPetSitterAddress()).build();
    }

    public void changeAvailableDates(Set<String > availableDates )
    {
        this.availableDates=availableDates;
    }

}
