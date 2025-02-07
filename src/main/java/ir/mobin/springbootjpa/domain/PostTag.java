package ir.mobin.springbootjpa.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "post_tag_join")
public class PostTag  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;



   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "post_id")
    private Post post;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "tag_id")
    private Tag tag;

    public Tag getTag() {
        return tag;
    }

    public PostTag() {
    }

    public PostTag(Post post, Tag tag) {
        this.post = post;
        this.tag = tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
