package myapp.myapp.service;

import lombok.RequiredArgsConstructor;
import myapp.myapp.domain.posts.Posts;
import myapp.myapp.domain.posts.PostsRepository;
import myapp.myapp.web.dto.PostsListResponseDto;
import myapp.myapp.web.dto.PostsResponseDto;
import myapp.myapp.web.dto.PostsSaveRequestDto;
import myapp.myapp.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Entity;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

   private final PostsRepository postsRepository;

   //
   @Transactional(readOnly = true)
   public List<PostsListResponseDto> findAllDesc() {
      return postsRepository.findAllDesc().stream()
              .map(PostsListResponseDto::new) //map(posts -> new PostsListResponseDto(posts)
              .collect(Collectors.toList());
   }

   @Transactional
   public Long save(PostsSaveRequestDto requestDto){
      return postsRepository.save(requestDto.toEntity()).
              getId();
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
