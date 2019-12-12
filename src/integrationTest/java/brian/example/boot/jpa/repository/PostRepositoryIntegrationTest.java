package brian.example.boot.jpa.repository;

//@RunWith(SpringJUnit4ClassRunner.class)
//@DataJpaTest
public class PostRepositoryIntegrationTest {

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Autowired
//    PostRepository repo;
//
//    @Before
//    public void setup(){
//
//        repo.deleteAll();
//
//        Post p1 = new Post(new User("tester1"), "subject1", "content1");
//        Post p2 = new Post(new User("tester2"), "subject2", "content2");
//        Post p3 = new Post(new User("tester1"), "subject3", "content3");
//        Post p4 = new Post(new User("tester2"), "subject4", "content4");
//        Post p5 = new Post(new User("tester3"), "subject5", "content5");
//        Post p6 = new Post(new User("tester1"), "subject6", "content6");
//
//        repo.save(p1);
//        repo.save(p2);
//        repo.save(p3);
//        repo.save(p4);
//        repo.save(p5);
//        repo.save(p6);
//    }
//
//    @Test
//    public void testFindAll_withNoParam_returnsList(){
//
//        System.out.println("Test Ran======================================================");
//
//        // Given
//        Iterable<Post> list = repo.findAll();
//        int count = (int) StreamSupport.stream( list.spliterator(), false).count();
//
//        // Then
//        assertThat(count).isSameAs(6);
//    }
//
//    @Test
//    public void testCRUD_shouldBeSuccessOnCRUD(){
//        // Original Size
//        Iterable<Post> list = repo.findAll();
//        int originalSize = (int)StreamSupport.stream(list.spliterator(), false).count();
//
//        // Create
//        Post p7 = new Post(new User("tester7"), "subject7", "content7");
//        repo.save(p7);
//        Post createdPost = repo.findByPostId(p7.getPostId());
//
//        Iterable<Post> addedList = repo.findAll();
//        int postSize = (int)StreamSupport.stream(addedList.spliterator(), false).count();
//        assertThat(postSize).isEqualTo(originalSize+1);
//
//        // Read
//        Post readPost = repo.findByPostId(createdPost.getPostId());
//
//        assertThat(readPost.getSubject()).isEqualTo(p7.getSubject());
//
//        // Update
//        Post postToUpdate = repo.findByPostId(p7.getPostId());
//        postToUpdate.setSubject( postToUpdate.getSubject()+"-1");
//
//        Post updatedPost = repo.save(postToUpdate);
//
//        assertThat(updatedPost.getSubject()).isEqualTo("subject7-1");
//
//
//        // Delete
//        repo.delete(p7);
//
//        list = repo.findAll();
//        assertThat(list).hasSize(6);
//    }

}
