package springboot_test.ch01.src.main.java.sample11.dao;

import sample11.model.Product;

public interface ProductDao {
	Product getProduct(String name);
}