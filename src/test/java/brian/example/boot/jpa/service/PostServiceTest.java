package brian.example.boot.jpa.service;

import brian.example.boot.jpa.domain.Post;
import brian.example.boot.jpa.domain.User;
import brian.example.boot.jpa.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    private PostService postService;
    @Mock
    private PostRepository postRepository;

// If you don't want to use @RunWith(MockitoJUnitRunner.class), you can use the following code instead
//    @Rule
//    public MockitoRule rule = MockitoJUnit.rule();

    @BeforeEach
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
        // Given
        Post p1 = new Post();
        Post p2 = new Post();
        List<Post> postList = Arrays.asList( p1, p2);

        // When
        when(postRepository.findAll()).thenReturn(postList);

        // Test
        List<Post> posts = postService.getAllPosts();

        // Then
        assertEquals(postList.size(), posts.size());
    }

    @Test
    public void save() {
        // Given
        Post post1 = new Post(1);
        // When
        when(postRepository.save(post1)).thenReturn(post1);
        // Test
        Post savedPost1 = postService.save(post1);
        // Then
        assertEquals(post1,savedPost1);
    }

    @Test
    public void deletePost() {
        // When
        postService.deletePost(1);

        verify(postRepository, times(1)).delete(any());
    }

}