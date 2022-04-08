package ksi.springbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksi.springbooks.models.Publisher;
import ksi.springbooks.repositories.PublisherRepository;

@Service

public class PublisherService {
	
	@Autowired
	
	private PublisherRepository repository;
	
	public PublisherService() {
		super();
	}

	public <S extends Publisher> S save(S entity) {
		return repository.save(entity);
	}

	public List<Publisher> findAll() {
		return repository.findByOrderByNameAsc();
	}

	public Optional<Publisher> findByIdp(Long idp) {
		return repository.findById(idp);
	}

	public void deleteByIdp(Long idp) {
		repository.deleteById(idp);
	}
	
}