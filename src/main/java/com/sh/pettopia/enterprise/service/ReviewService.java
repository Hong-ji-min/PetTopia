package com.sh.pettopia.enterprise.service;

import com.sh.pettopia.enterprise.dto.ReviewResponseDto;
import com.sh.pettopia.enterprise.entity.Review;
import com.sh.pettopia.enterprise.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    // 리뷰 보여주기에 필요한 컬럼을 Dto에 담아 가져오기
    public List<ReviewResponseDto> findByEntId(Long entId) {
        return reviewRepository.findByEntId(entId).stream() // List를 Stream으로 변환
                .map(ReviewResponseDto::fromReview) // 각 Review를 ReviewResponseDto로 변환
                .collect(Collectors.toList()); // Stream을 List로 다시 변환하여 반환
    }



//    public double calculateAverageRating(Long entId) {
//        List<Review> reviews = reviewRepository.findByEntId(entId);
//        return reviews.stream()
//                .mapToInt(Review::getRating)
//                .average()
//                .orElse(0.0); // 리뷰가 없는 경우 0.0 반환
//    }
}