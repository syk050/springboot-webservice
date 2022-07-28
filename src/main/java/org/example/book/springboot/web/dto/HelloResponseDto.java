package org.example.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드의 get 메소드를 생성해 준다
@RequiredArgsConstructor // final이 없는 필드는 생성자에 포함되지 않음
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
