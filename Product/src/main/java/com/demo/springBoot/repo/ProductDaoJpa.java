package com.demo.springBoot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springBoot.bean.Product;
@Repository
public interface ProductDaoJpa extends JpaRepository<Product ,Integer>
{

}
