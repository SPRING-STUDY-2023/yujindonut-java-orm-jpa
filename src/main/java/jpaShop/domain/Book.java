package jpaShop.domain;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("B")
public class Book extends Item {

  private String author;
  private String isbn;
}
