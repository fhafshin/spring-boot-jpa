package ir.mobin.springbootjpa.repository;

import ir.mobin.springbootjpa.domain.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment,Long> {
}
