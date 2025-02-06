package ir.mobin.springbootjpa.repository;

import ir.mobin.springbootjpa.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PostRepositoryUnitTest {
    @Autowired
    private PostRepository postRepository;
    final String POST_NAME_2 = "test2";


    @Test
    public void givenSavedPost_WhenUpdate_ThenReturnUpdatedPost() {

        postRepository.save(new Post("test"));
        Post post = postRepository.findById(2L).get();
        post.setTitle("test2");
        postRepository.save(post);

        assertThat(postRepository.findById(2L).get().getTitle()).isEqualTo(POST_NAME_2);
    }

    @Test
    public void givenSavedPost_whenDelete_ThenReturnDeletedPost() {

        postRepository.save(new Post("test2"));
        postRepository.save(new Post("test3"));
        postRepository.deleteById(9L);
        Boolean present=postRepository.findById(4L).isPresent();
        assertThat(present).isEqualTo(false);
    }

    @Test
    public void givenPostsInDB_WhenFindAllWithSortedByTitle_thenReturnPostsSorted(){
        postRepository.save(new Post("test9"));
        postRepository.save(new Post("test90"));
        postRepository.save(new Post("test900"));

       List<Post> postSoredByTitle= postRepository.findAll(Sort.by(Sort.Direction.ASC,"title")) ;
        assertThat(postSoredByTitle.get(0).getTitle()).isEqualTo("book");

    }@Test
    public void givenPostsInDB_WhenFindAllWithPageRequestQuery_ThenReturnPageOfPost(){


        postRepository.save(new Post("test90"));
        postRepository.save(new Post("test90"));

        postRepository.save(new Post("test90000"));
        postRepository.save(new Post("test900"));
        postRepository.save(new Post("test900"));
        postRepository.save(new Post("test9000000"));

        Page<Post> postPage=postRepository.findAll(PageRequest.of(0,2));

        assertThat(postPage.getContent().get(0).getTitle()).isEqualTo("book");

    }



}
