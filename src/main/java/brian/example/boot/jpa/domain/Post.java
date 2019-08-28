package brian.example.boot.jpa.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

@Entity
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;
    @Column(name = "user_id", insertable = false, updatable = false)
    private String userId;		// Just to display the user Id
    private String subject;
    private String content;
    @Column(name="created_datetime")
    private LocalDateTime createdDatetime;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    @JsonIgnore
    private TestUser testUser;

    public Post(){
    	this.createdDatetime = LocalDateTime.now();
    }

    public Post(TestUser testUser, String subject, String content){
        this.testUser = testUser;
        this.subject = subject;
        this.content = content;
        this.createdDatetime = LocalDateTime.now();
    }

    public int getPostId() {
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

    public void setPostId(int postId) {
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

	public TestUser getTestUser() {
		return testUser;
	}

	public void setTestUser(TestUser testUser) {
		this.testUser = testUser;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
