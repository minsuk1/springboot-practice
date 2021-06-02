package myapp.myapp.domain.LikePosts;

import myapp.myapp.domain.posts.Posts;
import myapp.myapp.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikePostsRepository extends JpaRepository<LikePosts, Long> {
    Optional<LikePosts> findByUserAndPosts(User user, Posts posts);
}
