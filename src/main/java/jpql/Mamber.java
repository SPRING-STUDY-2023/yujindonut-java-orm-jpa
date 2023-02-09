package jpql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mamber {

  @Id @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;
  private String userName;
  private int age;

  @ManyToOne
  @JoinColumn(name = "TEAM_ID")
  private Teem team;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Teem getTeam() {
    return team;
  }

  public void setTeam(Teem team) {
    this.team = team;
  }
}