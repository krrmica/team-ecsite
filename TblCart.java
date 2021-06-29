package jp.co.internous.wasabi.model.domain;

import java.sql.Timestamp;

import jp.co.internous.wasabi.model.form.CartForm;

public class TblCart {
	
	private long id;
	
	private int userId;
	
	private long productId;
	
	private long productCount;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;
	
	public TblCart() {}

	public TblCart(CartForm f) {
		userId = f.getUserId();
		productId = f.getProductId();
		productCount = f.getProductCount();
	}
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public long getProductId() {
		return productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public long getProductCount() {
		return productCount;
	}
	
	public void setProductCount(long productCount) {
		this.productCount = productCount;
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
