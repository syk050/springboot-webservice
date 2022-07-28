package org.example.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 부모 클래스(엔티티)에 필드를 선언하고 단순히 속성만 받아서 사용
// 엔티티를 DB에 적용하기 전, 이후에 커스텀 콜백을 요청
// BaseTimeEntity 클래스에 Auditing 기능을 포함
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    /*
     모든 Entity의 상위 클래스가 되어
     Entity들의 CreateDate, modifiedDate를 자동으로 관리하는 역할
     */

    @CreatedDate // Entity가 생성되어 저장될 때 시간이 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity의 값을 변경할 때 시간이 자동 저장
    private LocalDateTime modifiedDate;
}

// Application 클래스에 JPA Auditing 어노테이션 활성화를 위해
// @EnableJpaAuditing 추가