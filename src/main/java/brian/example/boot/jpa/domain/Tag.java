package brian.example.boot.jpa.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="TAG")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tag_id")
    private Integer tagId;
    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy="tags", fetch = FetchType.EAGER)
    private Set<Post> posts = new HashSet<>();

    public Tag() {
    }

    public Tag(String tag) {
        this.name = tag;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer id) {
        this.tagId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String tag) {
        this.name = tag;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
