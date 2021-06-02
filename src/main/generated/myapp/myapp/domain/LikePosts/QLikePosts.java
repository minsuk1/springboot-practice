package myapp.myapp.domain.LikePosts;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLikePosts is a Querydsl query type for LikePosts
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLikePosts extends EntityPathBase<LikePosts> {

    private static final long serialVersionUID = -508348526L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLikePosts likePosts = new QLikePosts("likePosts");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final myapp.myapp.domain.posts.QPosts posts;

    public final myapp.myapp.domain.user.QUser user;

    public QLikePosts(String variable) {
        this(LikePosts.class, forVariable(variable), INITS);
    }

    public QLikePosts(Path<? extends LikePosts> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLikePosts(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLikePosts(PathMetadata metadata, PathInits inits) {
        this(LikePosts.class, metadata, inits);
    }

    public QLikePosts(Class<? extends LikePosts> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.posts = inits.isInitialized("posts") ? new myapp.myapp.domain.posts.QPosts(forProperty("posts"), inits.get("posts")) : null;
        this.user = inits.isInitialized("user") ? new myapp.myapp.domain.user.QUser(forProperty("user")) : null;
    }

}

