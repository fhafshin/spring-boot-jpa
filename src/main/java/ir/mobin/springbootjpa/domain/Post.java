package ir.mobin.springbootjpa.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String title;


    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private PostDetails postDetails;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<PostComment> postComments = new HashSet<>();


//    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "post_id"),
//            inverseJoinColumns = @JoinColumn(name = "tag_id"))
//    List<Tag> tags = new ArrayList<>();


    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY)
    List<PostTag> postTags=new ArrayList<>();

    public List<PostTag> getPostTags() {
        return postTags;
    }

    public void setPostTags(List<PostTag> postTags) {
        this.postTags = postTags;
    }
//    public List<Tag> getTags() {
//        return tags;
//    }
//
//    public void setTags(List<Tag> tags) {
//        this.tags = tags;
//    }

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
