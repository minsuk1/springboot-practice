package myapp.myapp.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -304615306L;

    public static final QUser user = new QUser("user");

    public final myapp.myapp.domain.QBaseTimeEntity _super = new myapp.myapp.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<myapp.myapp.domain.LikePosts.LikePosts, myapp.myapp.domain.LikePosts.QLikePosts> likePosts = this.<myapp.myapp.domain.LikePosts.LikePosts, myapp.myapp.domain.LikePosts.QLikePosts>createList("likePosts", myapp.myapp.domain.LikePosts.LikePosts.class, myapp.myapp.domain.LikePosts.QLikePosts.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public final StringPath picture = createString("picture");

    public final ListPath<myapp.myapp.domain.posts.Posts, myapp.myapp.domain.posts.QPosts> posts = this.<myapp.myapp.domain.posts.Posts, myapp.myapp.domain.posts.QPosts>createList("posts", myapp.myapp.domain.posts.Posts.class, myapp.myapp.domain.posts.QPosts.class, PathInits.DIRECT2);

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

