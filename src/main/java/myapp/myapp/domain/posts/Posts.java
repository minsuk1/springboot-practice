package myapp.myapp.domain.posts;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import myapp.myapp.domain.BaseTimeEntity;
import myapp.myapp.domain.LikePosts.LikePosts;
import myapp.myapp.domain.user.User;
import myapp.myapp.web.dto.posts.PostsSaveRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "posts")
    private List<LikePosts> likePosts;

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
