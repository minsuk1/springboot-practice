package myapp.myapp.domain.posts;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import myapp.myapp.domain.BaseTimeEntity;
import myapp.myapp.domain.user.User;
import javax.persistence.*;
import java.util.List;
// @NoArgsConstructor
// public Posts() {} 같은 효과

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity // 기본으로 camel_case
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Posts(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public static Posts create(String title, String content, User user) {
        return new Posts(title, content, user);
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
