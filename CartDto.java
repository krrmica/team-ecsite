package jp.co.internous.wasabi.model.domain.dto;


import java.sql.Timestamp;

import jp.co.internous.wasabi.model.domain.MstProduct;
import jp.co.internous.wasabi.model.domain.TblCart;

public class CartDto {
	
	private long id;
	private String imageFullPath;
	private String productName;
	private long price;
	private long productCount;
	private long subtotal;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public CartDto() {}

	public CartDto(TblCart tbl_cart, MstProduct mst_product) {
		this.setId(tbl_cart.getId());
		this.setImageFullPath(mst_product.getImageFullPath());
		this.setProductName(mst_product.getProductName());
		this.setPrice(mst_product.getPrice());
		this.setProductCount(tbl_cart.getProductCount());
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getImageFullPath(){
		return imageFullPath;
	}
	
	public void setImageFullPath(String imageFullPath) {
		this.imageFullPath = imageFullPath;
	}
	
	public String getProductName(){
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public long getPrice(){
		return price;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
	
	public long getProductCount(){
		return productCount;
	}
	
	public void setProductCount(long productCount) {
		this.productCount = productCount;
	}
	
	public long getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(long subtotal) {
		this.subtotal = subtotal;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}
