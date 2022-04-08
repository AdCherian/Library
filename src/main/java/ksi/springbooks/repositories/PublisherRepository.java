package ksi.springbooks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ksi.springbooks.models.Publisher;
@Repository

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
	List<Publisher> findByOrderByIdpAsc();
	List<Publisher> findByOrderByIdpDesc();
	List<Publisher> findByOrderByNameAsc();
}
