package myapp.myapp.service;

import lombok.RequiredArgsConstructor;
import myapp.myapp.domain.posts.Posts;
import myapp.myapp.domain.posts.PostsRepository;
import myapp.myapp.domain.user.User;
import myapp.myapp.domain.user.UserRepository;
import myapp.myapp.web.dto.posts.PostsListResponseDto;
import myapp.myapp.web.dto.posts.PostsResponseDto;
import myapp.myapp.web.dto.posts.PostsSaveRequestDto;
import myapp.myapp.web.dto.posts.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

   private final PostsRepository postsRepository;
   private final UserRepository userRepository;

   @Transactional(readOnly = true)
   public List<PostsListResponseDto> findAllDesc() {
      return postsRepository.findAllDesc().stream()
              .map(PostsListResponseDto::new) //map(posts -> new PostsListResponseDto(posts)
              .collect(Collectors.toList());
   }

   @Transactional
   public Long save(String name, PostsSaveRequestDto requestDto){
      User user = userRepository.findByEmail(name)
              .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));;
      Posts post = Posts.create(requestDto.getTitle(),
              requestDto.getContent(), user);

      return postsRepository.save(post).getId();
   }

   @Transactional
   public Long update(Long id, PostsUpdateRequestDto requestDto){
      Posts posts =postsRepository.findById(id)
              .orElseThrow(() -> new IllegalArgumentException("게시글 없음"));

      posts.update(requestDto.getTitle(), requestDto.getContent());

      return id;
   }


   public PostsResponseDto findById(Long id){
      Posts entity = postsRepository.findById(id)
              .orElseThrow(() -> new IllegalArgumentException("해당 사용자 없음"+id));
      return new PostsResponseDto(entity);
   }

   @Transactional
   public void delete (Long id) {
      Posts posts = postsRepository.findById(id)
              .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

      postsRepository.delete(posts);
   }
}
