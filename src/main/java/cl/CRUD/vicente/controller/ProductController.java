package cl.CRUD.vicente.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.CRUD.vicente.entities.Product;
import cl.CRUD.vicente.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String home(Model model, @Param("keyWord")String keyWord) {
		if(keyWord==null) {
		List<Product> products= productService.findAll();
		model.addAttribute("products", products);
		}else {
			List<Product> products= productService.filterAll(keyWord);
			model.addAttribute("products", products);
		}
		
		return "index";
		
	}
	@RequestMapping("/newproduct")
	public String productForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "newProduct";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		return "redirect:/";
	}
	@RequestMapping(value="/edit/{id}")
	public ModelAndView editProduct(@PathVariable(name="id") Long id) {
		ModelAndView model = new ModelAndView("editProduct");
		Product product = productService.getProduct(id);
		model.addObject("product", product);
		return model;
	}
	@RequestMapping(value="/delete/{id}")
	public String deleteProduct(@PathVariable("id")Long id) {
		productService.deleteProduct(id);
		return "redirect:/";
		
	}

}
