package ir.mobin.springbootjpa.repository;

import ir.mobin.springbootjpa.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
