package ex1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "ALBUM1")
@DiscriminatorValue("Album")
public class Album extends Item{

  private String artist;

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }
}
