package brian.boot.template.jpa.repository;

import brian.boot.template.jpa.BootTemplateJpaApplication;
import brian.boot.template.jpa.domain.hibernate.Post;
import brian.boot.template.jpa.repository.hibernate.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { BootTemplateJpaApplication.class})
@DataJpaTest
@ActiveProfiles("test")
public class PostRepositoryTest {

    @Autowired
    PostRepository repo;

    @Before
    public void setup(){

        repo.deleteAll();

        Post p1 = new Post("tester1", "subject1", "content1");
        Post p2 = new Post("tester1", "subject2", "content2");
        Post p3 = new Post("tester1", "subject3", "content3");
        Post p4 = new Post("tester1", "subject4", "content4");
        Post p5 = new Post("tester1", "subject5", "content5");
        Post p6 = new Post("tester1", "subject6", "content6");

        repo.save(p1);
        repo.save(p2);
        repo.save(p3);
        repo.save(p4);
        repo.save(p5);
        repo.save(p6);
    }

    @Test
    public void testFindAll_withNoParam_returnsList(){
        List<Post> list = repo.findAll();

        System.out.println("Test Ran======================================================");

        assertThat(list).hasSize(6);
    }

    @Test
    public void testCRUD_shouldBeAdded(){
        // Original Size
        List<Post> list = repo.findAll();
        int originalSize = list.size();

        // Create
        Post p7 = new Post("tester7", "subject7", "content7");
        repo.save(p7);
        Post createdPost = repo.getOne(p7.getPostId());

        List<Post> addedList = repo.findAll();
        assertThat(addedList.size()).isEqualTo(originalSize+1);

        // Read
        Post readPost = repo.getOne(createdPost.getPostId());

        assertThat(readPost.getSubject()).isEqualTo(p7.getSubject());

        // Update
        Post postToUpdate = repo.getOne(p7.getPostId());
        postToUpdate.setSubject( postToUpdate.getSubject()+"-1");

        Post updatedPost = repo.save(postToUpdate);

        assertThat(updatedPost.getSubject()).isEqualTo("subject7-1");


        // Delete
        repo.delete(p7.getPostId());

        list = repo.findAll();
        assertThat(list).hasSize(6);
    }

}
