package jp.co.internous.wasabi.model.form;

import java.io.Serializable;

public class CartForm implements Serializable{
	
	private static final long serialVersionUID = -1266694044402239099L;
	
	private int userId;
	private long productId;
	private long productCount;
	
	public int getUserId() {
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
}
