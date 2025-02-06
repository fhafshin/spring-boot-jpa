package ir.mobin.springbootjpa.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String title;


    @OneToOne(mappedBy = "post",cascade = CascadeType.ALL)
   private PostDetails postDetails;



    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private Set<PostComment> postComments=new HashSet<>();


    public Set<PostComment> getPostComments() {
        return postComments;
    }

    public void setPostComments(Set<PostComment> postComments) {
        this.postComments = postComments;
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }

    public Post(String title) {
        this.title = title;
    }

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addComment(PostComment postComment) {

        postComments.add(postComment);
        postComment.setPost(this);
    }
}
