package ir.mobin.springbootjpa.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;


//    @ManyToMany(mappedBy = "tags")
//    private List<Post> posts=new ArrayList<>();


    public List<PostTag> getPostTags() {
        return postTags;
    }

    public void setPostTags( List<PostTag> postTags) {
        this.postTags = postTags;
    }

    @OneToMany(mappedBy = "tag",fetch = FetchType.LAZY)
    private List<PostTag> postTags = new ArrayList<>();

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
