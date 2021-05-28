package myapp.myapp.web.dto.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import myapp.myapp.domain.posts.Posts;
import myapp.myapp.domain.user.User;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsSaveRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
//    public Posts toEntity() {
//        return Posts.builder()
//                .title(title)
//                .content(content)
//                .build();
//    }

}