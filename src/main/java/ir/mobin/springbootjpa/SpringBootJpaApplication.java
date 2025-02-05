package ir.mobin.springbootjpa;

import ir.mobin.springbootjpa.domain.Post;
import ir.mobin.springbootjpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaApplication implements CommandLineRunner {


	private final PostRepository postRepository;
	public SpringBootJpaApplication(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		postRepository.save(new Post("book"));
	}
}
