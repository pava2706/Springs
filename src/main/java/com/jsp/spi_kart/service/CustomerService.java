package com.jsp.spi_kart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.spi_kart.dao.CustomerDao;
import com.jsp.spi_kart.dto.CartDto;
import com.jsp.spi_kart.dto.CustomerDto;
import com.jsp.spi_kart.dto.ItemsDto;
import com.jsp.spi_kart.dto.ProductDto;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;

	@Autowired
	ProductService productService;

	@Autowired
	CartService cartService;

	@Autowired
	ItemsService itemsService;

	public void createCustomer(CustomerDto customerDto) {
		customerDao.createCustomer(customerDto);
	}

	public CustomerDto fetchCustomerById(int customerid) {
		CustomerDto cd = customerDao.fetchCustomerById(customerid);
		return cd;
	}

	public void deleteCustomerById(int customerid) {
		customerDao.deleteCustomerById(customerid);
	}

	public void updateCustomer(CustomerDto customerDto) {
		customerDao.updateCustomer(customerDto);
	}

	public String addProductToCart(int productid, int Quantity, int customerid) {
		ProductDto pd = productService.fetchProductsById(productid);// to get product
		CustomerDto cd = customerDao.fetchCustomerById(customerid);// to get customer
//to get product details of particular product id
		String pname = pd.getName();
		double price = pd.getPrice();
		int pstock = pd.getStock();
		
		if (pstock >= Quantity) {
			
			CartDto cartdto = cd.getCart();// to get cart details of particular customer

			if (cartdto == null) {// if cart is null create one cart object for customer
				cartdto = new CartDto();
			}

			List<ItemsDto> items = cartdto.getItems();// for getting items present in particular cart

			if (items == null) {// if item is null create one item object for cart
				items = new ArrayList<ItemsDto>();
			}

			if (items.isEmpty()) {// if items is empty add product to it
				ItemsDto item = new ItemsDto();
				item.setName(pname);
				item.setPrice(Quantity * price);
				item.setQuantity(Quantity);
				itemsService.saveItem(item);
				item.setCartDto(cartdto);
				pd.setStock(pd.getStock() - Quantity);
				items.add(item);
			} else {// if we try to add product is already present in items then update it
				boolean flag = false;
				for (ItemsDto itm : items) {
					if (itm.getName().equals(pname)) {
						itm.setQuantity(itm.getQuantity() + Quantity);
						itm.setPrice(itm.getPrice() + (Quantity * price));
						pd.setStock(pd.getStock() - Quantity);

						itemsService.saveItem(itm);

						flag = false;
						break;
					} else {
						flag = true;
					}
				}

				if (flag) {// if we try to add product is not present in items then add product to item
							// list
					ItemsDto item = new ItemsDto();
					item.setName(pname);
					item.setPrice(Quantity * price);
					item.setQuantity(Quantity);
					item.setCartDto(cartdto);
					itemsService.saveItem(item);
					pd.setStock(pd.getStock() - Quantity);

					items.add(item);
				}
			}

			cartdto.setItems(items);// add items to cart
			cartdto.setCustomerDto(cd); // you should check
			cartService.saveCart(cartdto);// to save cart

			cd.setCart(cartdto);// add cart to customer
			customerDao.updateCustomer(cd);// to update customer
			return "product added to cart";
		}

		else {
			return "stock is closed";
		}
	}
}
