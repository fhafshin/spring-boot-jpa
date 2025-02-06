package ir.mobin.springbootjpa.repository;

import ir.mobin.springbootjpa.domain.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDetailsRepository extends JpaRepository<PostDetails,Long> {
}
