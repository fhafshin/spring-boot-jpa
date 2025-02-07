package ir.mobin.springbootjpa.repository;

import ir.mobin.springbootjpa.domain.CommentType;
import ir.mobin.springbootjpa.domain.Post;
import ir.mobin.springbootjpa.domain.PostComment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class LoadingStrategyUnitTest {

    @Autowired
    private PostRepository postRepository;

    @Transactional
    @Test
    public void whenPostLoadingLazy_thenLoadPostComment() {
        var post = new Post("lazy....");

        Set<PostComment> postComments = new HashSet<>();


        PostComment postComment1 = new PostComment("lazy....1", CommentType.GOOD, new Date());
        postComment1.setPost(post);
        PostComment postComment2 = new PostComment("lazy....1", CommentType.GOOD, new Date());
        postComment2.setPost(post);

        PostComment postComment3 = new PostComment("lazy....1", CommentType.GOOD, new Date());
        postComment3.setPost(post);

        postComments.add(postComment1);
        postComments.add(postComment2);
        postComments.add(postComment3);
        post.setPostComments(postComments);

        postRepository.save(post);

        List<Post> posts = postRepository.findAll();
        var postLazy = posts.get(0);
        postLazy.getPostComments();

    }
}
