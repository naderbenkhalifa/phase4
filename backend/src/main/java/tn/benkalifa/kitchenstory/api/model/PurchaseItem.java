package tn.benkalifa.kitchenstory.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class PurchaseItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int quantity;
	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}	

}
