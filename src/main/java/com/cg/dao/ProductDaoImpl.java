package com.cg.dao;

import java.util.ArrayList
;
import java.util.List;
import java.util.stream.Collectors;
import com.cg.entity.Category;
import com.cg.entity.Product;
import com.cg.exception.ProductException;
import com.cg.repo.ProductRepo;

public class ProductDaoImpl implements ProductDao {

	List<Product> obj1 = ProductRepo.lst;
	List<Category> obj2 = ProductRepo.lst1;

	/**
	 * @author : SUDHEER SAI
	 * 
	 * @Method :searchByProductName()
	 * 
	 * @Description :this method checks the product name entered by the user 
	 * if contains in the product list then it display the product name
	 * matching the input data.
	 * 
	 * @Parameters :pname.
	 */  
	
	
	@Override
	public List<Product> searchByProductName(String pname) throws ProductException {
		List<Product> plist = obj1.stream()
				.filter(prod -> prod.getProductName().toLowerCase().contains(pname.toLowerCase()))
				.collect(Collectors.toList());
		if (plist.isEmpty())
			throw new ProductException("Product NOT FOUND");

		return plist;
	}

	/**
	 * @author : SUDHEER SAI
	 * 
	 * Method :searchByProductPrice()
	 * 
	 * Description :this method checks the product price entered by the user 
	 * if contains in the product list then it display the product price
	 * matching the input data.
	 * 
	 * Parameters :price 
	 */  
	@Override 
	public List<Product> searchByProductPrice(double price) throws ProductException {
		
		List<Product> pli = new ArrayList<>();
	
		pli = obj1.stream().filter(p -> p.getProductPrice() == price).collect(Collectors.toList());
		
		if(pli.isEmpty())
			throw new ProductException("item with that price not found");
		
		return pli;
}
}