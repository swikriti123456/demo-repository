package com.demo.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.springBoot.bean.Product;
import com.demo.springBoot.service.ProductService;

@Controller
public class ProductController
{
	@Autowired
	ProductService productService;
	
	@RequestMapping("/products")
	public String forListProduct(ModelMap map) {
		map.addAttribute("plist", productService.findAll());
		return "product";
	}
	@RequestMapping(value="/admin/addProduct" ,method=RequestMethod.GET)
	public String forAddProduct(ModelMap map) {
		map.addAttribute("command", new Product());
		return "addProduct";
	}
	@RequestMapping(value="/admin/addProduct" ,method=RequestMethod.POST)
	public String forSaveProduct(@ModelAttribute("command") Product p) {
		productService.save(p);
		return "redirect:/products";
	}
	@RequestMapping(value="/admin/editProduct/{id}" ,method=RequestMethod.GET)
	public String forEditProduct(ModelMap map,@PathVariable int id) {
		map.addAttribute("command", productService.findById(id));
		return "editProduct";
	}
	@RequestMapping(value="/admin/editProduct/{id}" ,method=RequestMethod.POST)
	public String forUpdateProduct(@ModelAttribute("command") Product p) {
		productService.update(p);
		return "redirect:/products";
	}
	
	@GetMapping("/admin/deleteProduct/{id}")
	public String forDeleteProduct(@PathVariable int id) {
		productService.delete(id);
		return "redirect:/products";
	}
}
