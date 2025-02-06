package ir.mobin.springbootjpa.repository;

import ir.mobin.springbootjpa.domain.Post;
import ir.mobin.springbootjpa.domain.PostDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneToOneAnnotaionFKBasedIntegrationTest {

@Autowired
private PostDetailsRepository postDetailsRepository;
@Test
    public void whenInsert_ThenCreateOneToOneRelationShip(){


        Post post=new Post("book");

        PostDetails postDetails=new PostDetails(null,"admin");

        postDetails.setPost(post);
        postDetailsRepository.save(postDetails);
    }
}
