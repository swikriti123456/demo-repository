package com.demo.springBoot.service;

import java.util.List;

import com.demo.springBoot.bean.Product;

public interface ProductService {
	List<Product> findAll();

	void save(Product p);

	Product findById(int id);

	void update(Product p);

	void delete(int id);
}
