package myapp.myapp.web;

import lombok.RequiredArgsConstructor;
import myapp.myapp.config.auth.LoginUser;
import myapp.myapp.config.auth.dto.SessionUser;
import myapp.myapp.service.LikePostsService;
import myapp.myapp.web.dto.posts.PostsResponseDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikeApiController {

    private final LikePostsService likePostsService;

    @PostMapping("/like/{postId}")
    public boolean addLike(@LoginUser SessionUser user, @PathVariable Long postId){
        return likePostsService.addLike(user.getEmail(), postId);
    }

}
