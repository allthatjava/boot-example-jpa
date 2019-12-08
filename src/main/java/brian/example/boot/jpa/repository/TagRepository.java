package brian.example.boot.jpa.repository;

import brian.example.boot.jpa.domain.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer>{

	public Tag findByName(String name);

	@Override
	void delete(Tag entity);
}