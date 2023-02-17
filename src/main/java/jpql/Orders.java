package jpql;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_")
public class Orders {

  @Id @GeneratedValue
  private Long id;
  private int orderAmount;

  @Embedded
  private Addresses addresses;

  @ManyToOne
  @JoinColumn(name = "PRODUCT_ID")
  private Products products;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getOrderAmount() {
    return orderAmount;
  }

  public void setOrderAmount(int orderAmount) {
    this.orderAmount = orderAmount;
  }

  public Addresses getAddress() {
    return addresses;
  }

  public void setAddress(Addresses addresses) {
    this.addresses = addresses;
  }

  public Products getProduct() {
    return products;
  }

  public void setProduct(Products products) {
    this.products = products;
  }
}
