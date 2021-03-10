package com.demo.springBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springBoot.bean.Product;
import com.demo.springBoot.repo.ProductDaoJpa;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDaoJpa productDaoJpa;
	
	@Override
	public List<Product> findAll() {
		
		return productDaoJpa.findAll();
	}

	@Override
	public void save(Product p) {
		productDaoJpa.save(p);
	}

	@Override
	public Product findById(int id) {
		
		return productDaoJpa.findById(id).get();
	}

	@Override
	public void update(Product p) {
		productDaoJpa.save(p);
	}

	@Override
	public void delete(int id) {
		productDaoJpa.deleteById(id);
	}

}
