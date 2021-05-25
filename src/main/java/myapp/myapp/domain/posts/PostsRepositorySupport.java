package myapp.myapp.domain.posts;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static myapp.myapp.domain.posts.QPosts.posts;

@Repository
public class PostsRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public PostsRepositorySupport(JPAQueryFactory queryFactory) {
        super(Posts.class);
        this.queryFactory = queryFactory;
    }

    public List<Posts> findByName(String name) {
        return queryFactory.selectFrom(posts)
                .where(posts.title.eq(name))
                .fetch();
    }
}
