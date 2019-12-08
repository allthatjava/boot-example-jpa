package brian.example.boot.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;
    @Column(name = "user_id", insertable = false, updatable = false)
    private String userId;		// Just to display the user Id
    private String subject;
    private String content;
    @Column(name="created_datetime")
    private LocalDateTime createdDatetime;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToMany
    @JoinTable(name="POST_TAG", joinColumns = @JoinColumn(name="post_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id"))
    @JsonIgnore
    private Set<Tag> tags = new HashSet<>();

    public Post(){
    	this.createdDatetime = LocalDateTime.now();
    }

    public Post(User testUser, String subject, String content){
        this.user = testUser;
        this.subject = subject;
        this.content = content;
        this.createdDatetime = LocalDateTime.now();
    }

    public Post(int postId) {
        this.postId = postId;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Integer getPostId() {
        return postId;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User testUser) {
		this.user = testUser;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
