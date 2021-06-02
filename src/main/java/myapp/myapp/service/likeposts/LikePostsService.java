package myapp.myapp.service.likeposts;

import lombok.RequiredArgsConstructor;
import myapp.myapp.domain.LikePosts.LikePosts;
import myapp.myapp.domain.LikePosts.LikePostsRepository;
import myapp.myapp.domain.posts.Posts;
import myapp.myapp.domain.posts.PostsRepository;
import myapp.myapp.domain.user.User;
import myapp.myapp.domain.user.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikePostsService {

    private final LikePostsRepository likePostsRepository;
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;

    public boolean addLike(String name, Long postId){
        User user = userRepository.findByEmail(name)
                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));;

        Posts posts = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음"));

        if(firstLike(user, posts)){
            likePostsRepository.save(new LikePosts(user, posts));
            return true;
        }
        return false;
    }

    private boolean firstLike(User user, Posts posts){
        return likePostsRepository.findByUserAndPosts(user,posts).isEmpty();
    }
}
