package brian.example.boot.jpa.controller;

import brian.example.boot.jpa.service.PostService;
import brian.example.boot.jpa.service.TagService;
import brian.example.boot.jpa.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class PostControllerTest {

    PostController controller;
    @Mock
    PostService postService;
    @Mock
    UserService userService;
    @Mock
    TagService tagService;

    private MockMvc mockMvc;

    @Before
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

//    @Test
//    public void getPost() {
//    }
//
//    @Test
//    public void formPost() {
//    }
//
//    @Test
//    public void insertPost() {
//    }
//
//    @Test
//    public void updatePost() {
//    }
//
//    @Test
//    public void deletePost() {
//    }
}