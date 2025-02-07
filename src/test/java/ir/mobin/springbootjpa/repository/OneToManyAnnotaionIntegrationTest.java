package ir.mobin.springbootjpa.repository;

import ir.mobin.springbootjpa.domain.CommentType;
import ir.mobin.springbootjpa.domain.Post;
import ir.mobin.springbootjpa.domain.PostComment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class OneToManyAnnotaionIntegrationTest {
    @Autowired
    private PostRepository postRepository;
@Test
    public void givenManyPostComment_whenInsertPost_thenCreateOneToMany(){
        Post post = new Post("new post");


        Set<PostComment> postComments = new HashSet<>();
   PostComment postComment1= new PostComment("title 1", CommentType.GOOD,new Date());
   postComment1.setPost(post);
        postComments.add(postComment1);
    PostComment postComment2= new PostComment("title 2", CommentType.GOOD,new Date());
    postComment2.setPost(post);
    postComments.add(postComment2);

      //  post.setPostComments(postComments);

        postRepository.save(post);
    }

    @Test
    public void  given1PostComment_whenInsertPost_thenCreateOneToManyRalationship(){

    Post post = new Post("new post");

    PostComment postComment=new PostComment("title3",CommentType.GOOD,new Date());


    postComment.setPost(post);

    //post.addComment(postComment);

    postRepository.save(post);
    }
}
