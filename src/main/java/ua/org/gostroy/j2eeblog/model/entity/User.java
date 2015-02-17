package ua.org.gostroy.j2eeblog.model.entity;

import ua.org.gostroy.j2eeblog.model.UserSex;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Panov Sergey on 2/15/2015.
 */
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "select o from User o"),
        @NamedQuery(name = "User.findByLogin", query = "SELECT o FROM User o WHERE o.login = :login"),
        @NamedQuery(name = "User.findByEmail", query = "SELECT o FROM User o WHERE o.email = :email"),
        @NamedQuery(name = "User.count", query = "select count(o.id) from User o")
})
public class User extends BaseEntity {

    private String login;
    private String email;
    private String password;
    private Boolean enabled;
    private String regUrI;
    private String role;
    private UserSex sex;
    private Boolean receiveNewsletter;
    @Basic(fetch= FetchType.LAZY)
    @Lob
    private byte[] avatarImage;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDay;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteDate;

    @ElementCollection(fetch=FetchType.LAZY)
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "author")
    private List<Article> articles;
    @ElementCollection(fetch=FetchType.LAZY)
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "author")
    private List<Comment> comments;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getRegUrI() {
        return regUrI;
    }

    public void setRegUrI(String regUrI) {
        this.regUrI = regUrI;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserSex getSex() {
        return sex;
    }

    public void setSex(UserSex sex) {
        this.sex = sex;
    }

    public Boolean getReceiveNewsletter() {
        return receiveNewsletter;
    }

    public void setReceiveNewsletter(Boolean receiveNewsletter) {
        this.receiveNewsletter = receiveNewsletter;
    }

    public byte[] getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(byte[] avatarImage) {
        this.avatarImage = avatarImage;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
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

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
