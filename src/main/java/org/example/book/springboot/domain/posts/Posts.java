package org.example.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.book.springboot.domain.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {
    @Id // 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙
    private Long id;                                    // GenerationType.IDENTITY: auto_increment 옵션

    @Column(length = 500, nullable = false) 
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author; // Column을 사용하지 않아도 클래스의 모든 필드가 칼럼으로 사용

    @Builder // 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
