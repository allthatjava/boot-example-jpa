package brian.boot.template.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootTemplateJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootTemplateJpaApplication.class, args);


//		PostRepository repo = context.getBean("postRepository", PostRepository.class);
//
//		List<Post> list = repo.findAll();
//		System.out.println("Lists:====================================="+list);
	}
}
