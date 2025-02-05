package ir.mobin.springbootjpa.domain;


import jakarta.persistence.*;

import java.util.Date;


@Entity
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column(name = "review", length = 50, nullable = false)
    private String review;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public Date getComment_date() {
        return comment_date;
    }

    public CommentType getComment_type() {
        return comment_type;
    }

    public void setComment_type(CommentType comment_type) {
        this.comment_type = comment_type;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    @Transient
    private Integer code ;


    @Enumerated(EnumType.ORDINAL)
private CommentType comment_type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date comment_date;
}
