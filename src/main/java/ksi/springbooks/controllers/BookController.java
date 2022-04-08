package ksi.springbooks.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ksi.springbooks.models.Book;
import ksi.springbooks.services.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	
	public BookController() {
	}
	public List<Book> findAll() {
		return service.findAll();
	}
	public List<Book> findAllSql() {
		return service.findAllByTitleNativeSQL();
	}
	
	@RequestMapping("books_list")
	public String viewBooksList(Model model)
	{
		List<Book> lb=service.findAll();
		model.addAttribute("lb", lb);
		return "books_list";
	}
	
	@RequestMapping("books_list_sort")
	public String viewBooksListSQL(Model model)
	{
		List<Book> lsql=service.findAllByTitleNativeSQL();
		model.addAttribute("lsql", lsql);
		return "books_list_sort";
	}
	
	@RequestMapping("/new_book")
	public String showFormNewBook(Model model) {
		Book nb = new Book();
		model.addAttribute("book", nb);
		return "new_book";
	 }
	
	@PostMapping(value="/save_book")
	 public String saveBook(@ModelAttribute("book") Book book) {
	 service.save(book);
	 return "redirect:/books_list";
	 }
	 
	@RequestMapping("/edit_book/{idb}")
	 public ModelAndView showEditFormBook(@PathVariable(name = "idb") Long 
	 idb) {
	  ModelAndView mav = new ModelAndView("edit_book");
	  Optional<Book> eb = service.findById(idb);
	  mav.addObject("book", eb);
	  return mav;
	 }
	
	@RequestMapping("/delete_book/{idb}")
	 public String deleteBook(@PathVariable(name = "idb") Long idb) {
	  service.deleteById(idb);
	  return "redirect:/books_list";
	 }

}
