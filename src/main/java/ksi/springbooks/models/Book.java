package ksi.springbooks.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "Book.findAllByTitleNativeSQL", 
query = "SELECT DISTINCT * FROM books.book INNER JOIN books.category ON books.book.category_idc=books.category.idc ORDER BY idc DESC, title ASC",
resultClass = Book.class)

public class Book {
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idb;
	private String title;
	public Book() {
	super();
	}
	
	@ManyToOne
	private Publisher publisher;
	public Publisher getPublisher() {
		return publisher;
	}
	
	@ManyToOne
	private Category category;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public Long getIdb() {
		return idb;
	}
	public void setIdb(Long idb) {
		this.idb = idb;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
