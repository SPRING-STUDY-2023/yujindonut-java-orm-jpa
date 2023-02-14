package jpql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(
    name = "Member.findByUsername",
    query = "select m from Mamber m where m.userName = :username"
)
public class Mamber {

  @Id @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;
  private String userName;
  private int age;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TEAM_ID")
  private Teem team;

  @Enumerated(EnumType.STRING)
  private MemberType type;

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
    team.getMembers().add(this);
  }

  public MemberType getType() {
    return type;
  }

  public void setType(MemberType type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Mamber{" +
        "id=" + id +
        ", userName='" + userName + '\'' +
        ", age=" + age +
        '}';
  }
}
