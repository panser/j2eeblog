package ua.org.gostroy.j2eeblog.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Panov Sergey on 2/15/2015.
 */
@Entity
@Table(name = "comments")
@NamedQueries({
        @NamedQuery(name = "Comment.findAll", query = "select o from Comment o"),
        @NamedQuery(name = "Comment.findByAuthor", query = "SELECT o FROM Comment o WHERE o.author = :author"),
        @NamedQuery(name = "Comment.findByArticle", query = "SELECT o FROM Comment o WHERE o.article = :article"),
        @NamedQuery(name = "Comment.count", query = "select count(o.id) from Comment o")
})
public class Comment extends BaseEntity {

    private String text;
    private Float sortId;
    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User author;
    private String name;
    private String email;
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private Article article;
    private Boolean visible;
    private Comment parent;
    private Integer depth;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteDate;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Float getSortId() {
        return sortId;
    }

    public void setSortId(Float sortId) {
        this.sortId = sortId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }
}
