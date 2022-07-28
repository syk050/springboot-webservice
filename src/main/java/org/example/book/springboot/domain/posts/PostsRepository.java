package org.example.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long>{
    
}

/*
 MyBatis 등에서 Dao라고 불리는 DB Layer 접근자를 JPA에선 Repository라고 부르며
 인터페이스로 생성한다
 JpaRepository<Entity 클래스, Pk타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성
 @Repository를 추가할 필요가 없음
 Entity 클래스와 Entity Repository는 함께 위치해야 함
 */
