package com.harman.orderapi.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

@NotBlank
    private String cust_adrs;
@NotBlank
    private String cust_name;
@NotBlank
	private String prd;
@NotNull
    private Long qty;


public Order(){
        super();
    }
public Order(Long id, String cust_name, String cust_adrs, String prd, Long qty) {
        super();
        this.id = id;
        this.cust_name = cust_name;
        this.cust_adrs = cust_adrs;
        this.prd = prd;
        this.qty = qty;
    }
public Long getId() {
        return id;
    }
public void setId(Long id) {
        this.id = id;
    }
public String getCust_adrs() {
	return cust_adrs;
}
public void setCust_adrs(String cust_adrs) {
	this.cust_adrs = cust_adrs;
}
public String getCust_name() {
	return cust_name;
}
public void setCust_name(String cust_name) {
	this.cust_name = cust_name;
}
public String getPrd() {
	return prd;
}
public void setPrd(String prd) {
	this.prd = prd;
}
public Long getQty() {
	return qty;
}
public void setQty(Long qty) {
	this.qty = qty;
}

}