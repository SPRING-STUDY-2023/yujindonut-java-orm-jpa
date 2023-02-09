package jpaShop.domain;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("M")
public class Movie extends Item {

  private String director;
  private String actor;
}
