package ksi.springbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksi.springbooks.models.Category;
import ksi.springbooks.repositories.CategoryRepository;

@Service

public class CategoryService {
	
	@Autowired
	
	private CategoryRepository repository;
	
	public CategoryService() {
		super();
	}

	public <S extends Category> S save(S entity) {
		return repository.save(entity);
	}

	public List<Category> findAll() {
		return repository.findByOrderByDescriptionAsc();
	}

	public Optional<Category> findByIdc(Long idc) {
		return repository.findById(idc);
	}

	public void deleteByIdc(Long idc) {
		repository.deleteById(idc);
	}
	
}