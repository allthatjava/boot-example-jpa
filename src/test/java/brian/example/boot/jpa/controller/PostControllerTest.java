package brian.example.boot.jpa.controller;

import brian.example.boot.jpa.domain.Post;
import brian.example.boot.jpa.domain.User;
import brian.example.boot.jpa.service.PostService;
import brian.example.boot.jpa.service.TagService;
import brian.example.boot.jpa.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class PostControllerTest {

    PostController controller;

    @Mock
    PostService postService;
    @Mock
    UserService userService;
    @Mock
    TagService tagService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {
        controller = new PostController(postService, userService, tagService);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAllPosts() throws Exception {

        mockMvc.perform( get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("posts"))
                .andExpect(view().name("post/index"));
    }

    @Test
    public void getPost() throws Exception {
        // Given
        Post post = new Post();
        post.setPostId(1);

        // When
        when(postService.getPost(1)).thenReturn(post);

        mockMvc.perform(get("/post/1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("post"))
                .andExpect(view().name("post/post"));
    }

    @Test
    public void formPost() throws Exception {
        mockMvc.perform(get("/post"))
                .andExpect(view().name("post/form"));
    }

    @Test
    public void insertPost() throws Exception {

        User user = new User();
        user.setUserId("tester1");

        when(userService.getUser(any())).thenReturn(user);

        mockMvc.perform(
                post("/post")
                .param("subject", "test subject")
                .param("content", "test content")
                .param("userId", "tester1")
                .param("tag", "tag1")
                .param("tag", "tag2")
                .param("tag", "tag3")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        ).andExpect(status().is3xxRedirection())
        .andReturn();
    }

//    @Test
//    public void updatePost() {
//    }
//
//    @Test
//    public void deletePost() {
//    }
}