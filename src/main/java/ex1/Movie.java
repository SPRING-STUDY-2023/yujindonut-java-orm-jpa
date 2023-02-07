package ex1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("Movie")
public class Movie extends Item{

  private String director;
  private String actor;

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getActor() {
    return actor;
  }

  public void setActor(String actor) {
    this.actor = actor;
  }
}
