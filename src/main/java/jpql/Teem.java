package jpql;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teem {

  @Id @GeneratedValue
  @Column(name = "TEAM_ID")
  private Long id;
  private String name;

  @OneToMany(mappedBy = "team")
  private List<Mamber> members = new ArrayList<>();


}
