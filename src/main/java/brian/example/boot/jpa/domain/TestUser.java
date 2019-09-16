package brian.example.boot.jpa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_USER")
public class TestUser {

    @Id
    @Column(name="user_id")
    private String userId;
    private String pw;
    private String name;
    private String title;
    private int age;
    
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "testUser")
    private Set<Post> posts = new HashSet<>();

    public TestUser(){
    }
    
    public TestUser(String userId) {
    	this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getAge() {
        return age;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAge(int age) {
        this.age = age;
    }

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public String getPw() {
		return pw;
	}
}
