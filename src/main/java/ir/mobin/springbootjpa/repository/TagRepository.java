package ir.mobin.springbootjpa.repository;

import ir.mobin.springbootjpa.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
