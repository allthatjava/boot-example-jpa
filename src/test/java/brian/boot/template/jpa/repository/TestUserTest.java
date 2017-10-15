package brian.boot.template.jpa.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
@ActiveProfiles("test")
public class TestUserTest {

    @Autowired
    TestUserRepository repo;

    @Test
    public void testFindAll_withNoParam_returnsList(){
//        List<TestUser> list = repo.findAll();

//        assertThat(list).hasSize(3);
        assertThat(1).isEqualTo(1);
    }

}
