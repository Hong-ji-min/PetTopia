package com.sh.pettopia.Hojji.community.posts.dto;

import com.sh.pettopia.Hojji.community.posts.entity.Category;
import com.sh.pettopia.Hojji.community.posts.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostListResponseDto {
    // 카테고리
    private Category category;

    // 제목
    private String title;

    // 작성자
    private String writer;

    // 작성일
    private LocalDate createdAt;

    // 조회수
    private Integer views;

    public static PostListResponseDto fromPost(Post post) {
        return new PostListResponseDto(
                post.getCategory(),
                post.getTitle(),
                post.getMember().getNickName(),
                post.getCreatedAt(),
                post.getViewCount()
        );
    }
}