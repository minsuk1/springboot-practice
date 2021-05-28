package myapp.myapp.web;

import lombok.RequiredArgsConstructor;
import myapp.myapp.config.auth.LoginUser;
import myapp.myapp.config.auth.dto.SessionUser;
import myapp.myapp.service.PostsService;
import myapp.myapp.web.dto.posts.PostsResponseDto;
import myapp.myapp.web.dto.posts.PostsSaveRequestDto;
import myapp.myapp.web.dto.posts.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @PostMapping("/api/v1/posts")
    public Long save(@LoginUser SessionUser user, @RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(user.getEmail(), requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}