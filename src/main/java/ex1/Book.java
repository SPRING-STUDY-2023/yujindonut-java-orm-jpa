package ex1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "BOOK1")
@DiscriminatorValue("Book")
public class Book extends Item{

  private String author;
  private String ISBN;

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getISBN() {
    return ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }
}
