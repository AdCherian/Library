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

import ksi.springbooks.models.Category;
import ksi.springbooks.services.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService service;
	public CategoryController() {
	}
	public List<Category> findAll() {
		return service.findAll();
	}
	@RequestMapping("category_list")
	public String viewCategoryList(Model model)
	{
		List<Category> lc=service.findAll();
		model.addAttribute("lc", lc);
		return "category_list";
	}
	@RequestMapping("/new_category")
	public String showFormNewCategory(Model model) {
		Category cb = new Category();
		model.addAttribute("category", cb);
		return "new_category";
	 }
	 @PostMapping(value="/save_category")
	 public String saveCategory(@ModelAttribute("category") Category category) {
	 service.save(category);
	 return "redirect:/category_list";
	 }
	 @RequestMapping("/edit_category/{idc}")
	 public ModelAndView showEditFormCategory(@PathVariable(name = "idc") Long 
	 idc) {
	  ModelAndView mav = new ModelAndView("edit_category");
	  Optional<Category> ec = service.findByIdc(idc);
	  mav.addObject("category", ec);
	  return mav;
	 }
	 @RequestMapping("/delete_category/{idc}")
	 public String deleteCategory(@PathVariable(name = "idc") Long idc) {
	  service.deleteByIdc(idc);
	  return "redirect:/category_list";
	 }

}
