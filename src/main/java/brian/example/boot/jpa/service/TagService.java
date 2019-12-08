package brian.example.boot.jpa.service;

import brian.example.boot.jpa.domain.Tag;
import brian.example.boot.jpa.repository.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService {

	private TagRepository repo;

	public TagService(TagRepository repo) {
		this.repo = repo;
	}

	public Tag getTagByName(String name){
		return repo.findByName(name);
	}

	public Tag save(Tag tag){
		return repo.save(tag);
	}

	public void delete(Tag tag){
		repo.delete(tag);
	}

}
