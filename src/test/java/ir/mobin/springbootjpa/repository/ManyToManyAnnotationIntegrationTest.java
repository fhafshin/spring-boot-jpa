package ir.mobin.springbootjpa.repository;

import ir.mobin.springbootjpa.domain.Post;
import ir.mobin.springbootjpa.domain.PostTag;
import ir.mobin.springbootjpa.domain.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ManyToManyAnnotationIntegrationTest {

    @Autowired
    private PostRepository postRepository;
    @Autowired
private TagRepository tagRepository;

    @Autowired
    private PostTagRepository postTagRepository;
//    @Test
//    public void givenPstAndTags_WhenInserPost_thenCreateManyToManyRelationShip(){
//        var post=new Post("Many to Many");
//
//        var tag1=new Tag("Tag1");
//
//        var tag2=new Tag("Tag2");
//
//        List<Tag> tags=new ArrayList<>();
//
//        tags.add(tag1);
//        tags.add(tag2);
//        post.setTags(tags);
//
//        postRepository.save(post);
//
//        postRepository.delete(post);
//    }

    @Test
    public void givenPstAndTags_WhenInserPost_thenCreateManyToManyRelationShip2(){
       var post=new Post("Many to Many");
        postRepository.save(post);

        var tag=new Tag("Tag1");
        tagRepository.save(tag);

       PostTag postTag=new PostTag(post,tag);
        postTagRepository.save(postTag);
    }
}
