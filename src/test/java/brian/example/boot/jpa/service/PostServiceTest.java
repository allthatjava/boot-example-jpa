package brian.example.boot.jpa.service;

import brian.example.boot.jpa.domain.Post;
import brian.example.boot.jpa.domain.User;
import brian.example.boot.jpa.repository.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

    private PostService postService;
    @Mock
    private PostRepository postRepository;

// If you don't want to use @RunWith(MockitoJUnitRunner.class), you can use the following code instead
//    @Rule
//    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setup(){
        this.postService = new PostService(postRepository);
    }

    @Test
    public void getPost() {
        // Given
        User user = new User( "tester1");
        Post expected = new Post( user, "subject1", "content1");
        expected.setPostId(1);

        // When
        when(postRepository.findByPostId(1)).thenReturn(expected);

        // Test
        Post post = postService.getPost(1);

        // Then
        assertEquals(post.getPostId(), expected.getPostId());
    }

    @Test
    public void getAllPosts() {
    }

    @Test
    public void save() {
    }

    @Test
    public void deletePost() {
    }
}