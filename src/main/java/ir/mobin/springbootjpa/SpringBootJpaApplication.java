package ir.mobin.springbootjpa;

import ir.mobin.springbootjpa.domain.CommentType;
import ir.mobin.springbootjpa.domain.Post;
import ir.mobin.springbootjpa.domain.PostComment;
import ir.mobin.springbootjpa.repository.PostCommentRepository;
import ir.mobin.springbootjpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class SpringBootJpaApplication implements CommandLineRunner {


	private final PostRepository postRepository;
	private final PostCommentRepository postCommentRepository;
	public SpringBootJpaApplication(PostRepository postRepository, PostCommentRepository postCommentRepository) {
		this.postRepository = postRepository;
		this.postCommentRepository = postCommentRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		postRepository.save(new Post("book"));
		postRepository.save(new Post("book"));
		postRepository.save(new Post("book"));

		PostComment postComment=new PostComment();
		postComment.setReview("hello");
		postComment.setComment_date(new Date());
postComment.setComment_type(CommentType.GOOD);
		postCommentRepository.save(postComment);
	}
}
