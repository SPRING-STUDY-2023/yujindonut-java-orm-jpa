package ex1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Team {

  @Id @GeneratedValue
  @Column(name = "TEAM_ID")
  private Long id;
  private String name;

  @OneToMany(mappedBy = "team")
  // 1대다 매핑에서 나의 반대편 사이드에서 어떤걸로 매핑되어있는지 변수명을 적어줌
//  @OneToMany : 일대다
//  @JoinColumn(name = "MEMBER_ID")
  private List<Member> members = new ArrayList<>();

  public List<Member> getMembers() {
    return members;
  }

//  public void addMember(Member member) {
//    member.setTeam(this);
//    members.add(member);
//  }

  public void setMembers(List<Member> members) {
    this.members = members;
  }

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
}
