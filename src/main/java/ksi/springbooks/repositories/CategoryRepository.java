package ksi.springbooks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ksi.springbooks.models.Category;
@Repository

public interface CategoryRepository extends JpaRepository<Category, Long> {
	List<Category> findByOrderByIdcAsc();
	List<Category> findByOrderByIdcDesc();
	List<Category> findByOrderByDescriptionAsc();
	List<Category> findByOrderByDescriptionDesc();
}
