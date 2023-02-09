package ex1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

  public AddressEntity(String city, String street, String zipcode) {
    this.address = new Address(city, street, zipcode);
  }

  @Id
  @GeneratedValue
  private Long id;

  Address address;

  public AddressEntity() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
