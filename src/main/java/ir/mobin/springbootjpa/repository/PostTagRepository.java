package ir.mobin.springbootjpa.repository;

import ir.mobin.springbootjpa.domain.PostTag;
import ir.mobin.springbootjpa.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostTagRepository extends JpaRepository<PostTag,Long> {
}
