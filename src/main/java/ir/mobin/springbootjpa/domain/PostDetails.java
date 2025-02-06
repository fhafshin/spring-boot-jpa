package ir.mobin.springbootjpa.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PostDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

@Column(nullable = true)
    private Date createOn;

    private String createdBy;


@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "post_id" ,referencedColumnName = "id")
private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public PostDetails() {
    }

    public PostDetails(Date createOn, String createdBy) {
        this.createOn = createOn;
        this.createdBy = createdBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
