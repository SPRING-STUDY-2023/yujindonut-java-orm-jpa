package jpaShop.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Delivery extends Base {

  @Id @GeneratedValue
  private long id;

  @Embedded
  private Address address;

  @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY)
  private Order order;
}
