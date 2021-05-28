package myapp.myapp.web.dto.posts;

import lombok.Getter;
import myapp.myapp.domain.posts.Posts;

/*
DTO 사용이유
Entity 클래스는 db와 맞닿은 핵심클래스이고, 이로 인해 스키마 변경된다.
화면 변경을 위한 것은 자주 바뀌니까 Req,Res용 Dto는 viw를 위한 클래스.

SOLID - SRP원칙
 */

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}