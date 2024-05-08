package in.ashokit.controller;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.entity.Product;
import in.ashokit.repository.ProductRepository;
//import in.ashokit.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository repo;
	
	//@Autowired
	//private ProductService service;
	
	@GetMapping("/")
	public String viewProduct(Model model)
	{
		model.addAttribute("product", new Product());
		//model.addAttribute("type",service.getType());
		return "index";
	}
	@PostMapping("/saveProduct")
	public String saveProduct(@Validated @ModelAttribute("product") Product p,BindingResult result,Model model) 
	{
		if(result.hasErrors())
		{
			return "index";
		}
		p=repo.save(p);
		if(p.getPid()!=null) {
			model.addAttribute("msg","Product Saved...");
		}
		return "index";
	}
	
	@GetMapping("/products")
	public String viewAllProduct(Model model)
	{
//		List<Product> list=repo.findAll();
//		model.addAttribute("products", list);
		
		model.addAttribute("products", repo.findAll());
		return "viewAll";
	}
	
	@GetMapping("/delete")
	public String deleteBypid(@RequestParam("pid") Integer pid,Model model)
	{
			repo.deleteById(pid);
		
			model.addAttribute("msg","Product Deleted");
			model.addAttribute("products",repo.findAll());
		
		return "viewAll";
	}
	
	@GetMapping("/edit")
	public String editProduct(@RequestParam("pid") Integer pid,Model model)
	{
//		Optional<Product> findById=repo.findById(pid);
//		Product p=findById.get();
//		model.addAttribute("product", p);
		
		model.addAttribute("product", repo.findById(pid).get());
		return "index";
	}
	
	
}