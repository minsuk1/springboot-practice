package myapp.myapp.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Entitu Class, PK타입>
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
