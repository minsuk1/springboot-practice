package myapp.myapp.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Entity Class, PK타입>
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
