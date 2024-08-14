package com.sh.pettopia.enterprise.dto;

import com.sh.pettopia.enterprise.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDto {
//    private Long nickName; // tbl_member에서 가져올 것
    private Long memberId;
    private double rating; // 별점
    private String reviewContent; // 작성한 내용
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    // DQL : Entity -> Dto 반환
    public static ReviewResponseDto fromReview(Review review) {
        return new ReviewResponseDto(
                review.getMemberId(),
                review.getRating(),
                review.getReviewContent(),
                review.getCreatedAt(),
                review.getUpdatedAt()
        );
    }
}