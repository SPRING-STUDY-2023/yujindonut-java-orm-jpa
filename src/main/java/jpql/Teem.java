package jpql;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.BatchSize;

@Entity
public class Teem {

  @Id @GeneratedValue
  @Column(name = "TEAM_ID")
  private Long id;
  private String name;

  @BatchSize(size = 100)
  @OneToMany(mappedBy = "team")
  private List<Mamber> members = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Mamber> getMembers() {
    return members;
  }

  public void setMembers(List<Mamber> members) {
    this.members = members;
  }
}
