package myapp.myapp.service.posts.dto;

import lombok.Getter;
import myapp.myapp.domain.posts.Posts;
import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getUser().getName();
        this.modifiedDate = entity.getModifiedDate();
    }
}