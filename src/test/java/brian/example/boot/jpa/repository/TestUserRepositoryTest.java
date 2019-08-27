package brian.example.boot.jpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import brian.example.boot.jpa.domain.Post;
import brian.example.boot.jpa.domain.TestUser;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class TestUserRepositoryTest {

    @Autowired
    TestUserRepository repo;
    @Autowired
    PostRepository postRepo;
    
    @Before
    public void init() {
    	System.out.println("------------- Init ------------------------------ START");
    	TestUser t1 = new TestUser();
    	t1.setAge(11); t1.setName("Brian Heo"); t1.setPw("1234"); t1.setTitle("Sir"); t1.setUserId("tester1");
    	TestUser t2 = new TestUser();
    	t2.setAge(22); t2.setName("Phil Lee"); t2.setPw("1234"); t2.setTitle("Mr."); t2.setUserId("tester2");
    	TestUser t3 = new TestUser();
    	t3.setAge(33); t3.setName("Gerrard Lee"); t3.setPw("1234"); t3.setUserId("tester3");
    	
    	repo.save(t1);
    	repo.save(t2);
    	repo.save(t3);
    	
    	Post p1 = new Post("tester1", "Test Subject 1", "Contents of Test 1");
    	Post p2 = new Post("tester2", "Test Subject 2", "Contents of Test 2");
    	Post p3 = new Post("tester1", "Test Subject 3", "Contents of Test 3");
    	
    	postRepo.save(p1);
    	postRepo.save(p2);
    	postRepo.save(p3);
    	System.out.println("------------- Init ------------------------------ END");
    }
    
    @Test
    public void testSave_withValidTestUser_shouldReturnTrue() {
    	System.out.println("------------- Save ------------------------------ START");
    	TestUser t = new TestUser();
    	t.setAge(44); t.setName("Jun Lee"); t.setPw("1234"); t.setUserId("tester4");
    	
    	TestUser addedUser = repo.save(t);
    	
    	assertThat(addedUser).isEqualTo(t);
    	assertThat(repo.findAll()).hasSize(4);
    	System.out.println("------------- Save ------------------------------ END");
    }
    
    @Test
    public void testFindAll_withNoParam_returnsList(){
    	System.out.println("------------- FindAll ------------------------------ START");
        List<TestUser> list = repo.findAll();

        assertThat(list).hasSize(3);
        System.out.println("------------- FindAll ------------------------------ END");
    }
    
 
    @Test
    public void testFindByUserId_withTester1_returnsTestUser(){
    	System.out.println("------------- Find by User Id ------------------------------ START");
        TestUser tester1 = repo.findByUserId("tester1");
        
        List<Post> posts = tester1.getPosts();

        assertThat(posts).hasSize(2);
        System.out.println("------------- Find by User Id ------------------------------ END");
    }
 
}
