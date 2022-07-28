package org.example.book.springboot.web.dto;

import lombok.Getter;
import org.example.book.springboot.domain.posts.Posts;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        /*
         Entity의 필드 중 일부만 사용하므로
         생성자로 Entity를 받아 필드에 값을 넣음
         모든 필드를 가진 생성자가 필요하지 않아 Entity를 받아 처리
         */
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
