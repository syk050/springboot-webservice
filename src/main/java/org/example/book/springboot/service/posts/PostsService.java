package org.example.book.springboot.service.posts;

import lombok.RequiredArgsConstructor;
import org.example.book.springboot.domain.posts.Posts;
import org.example.book.springboot.domain.posts.PostsRepository;
import org.example.book.springboot.web.dto.PostsResponseDto;
import org.example.book.springboot.web.dto.PostsSaveRequestDto;
import org.example.book.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        // JPA의 영속성 컨텍스트 때문에 쿼리를 날리는 부분이 없음
        // 영속성 컨텍스트: 엔티티를 영구 저장하는 환경
        // Spring Data Jpa를 쓴다면 트랜잭션 안에서 DB의 데이터를 가져오면
        // 해당 데이터는 영속성 컨텍스트가 유지된 상태
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        // 데이터의 값을 변경하면
        // 트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영
        // Entity 객체의 값만 변경하면 별도로 Update 쿼리를 날릴 필요가 없음
        // => 더티 체킹이라 한다
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
