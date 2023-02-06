package ex1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity(name = "USER")
@SequenceGenerator(
    name = "MEMBER_SEQ_GENERATOR",
    sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
    initialValue = 1, allocationSize = 1)
public class Member {
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "MEMBER_ID")
  private Long id;
  @Column(name = "USERNAME")
  private String username;

//  @Column(name="TEAM_ID")
//  private Long teamId;

  // Member입장에서는 Many Team 입장에서는 One
  @ManyToOne
  // Join해야하는 컬럼이 뭐니
  @JoinColumn(name = "TEAM_ID")
  private Team team;

  @OneToOne
  @JoinColumn(name="LOCKER_ID")
  private Locker locker;
  private Integer age;

//  @ManyToMany
//  @JoinTable(name = "MEMBER_PRODUCT")
//  private List<Product> productList = new ArrayList<>();

  @OneToMany(mappedBy = "member")
  private List<MemberProduct> memberProducts = new ArrayList<>();

//  public Long getTeamId() {
//    return teamId;
//  }
//
//  public void setTeamId(Long teamId) {
//    this.teamId = teamId;
//  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public void changeTeam(Team team) {
    this.team = team;
    team.getMembers().add(this);
    //연관관계 편의 메소드
  }

  @Enumerated(EnumType.STRING)
//  @Enumerated(EnumType.ORDINAL)
//  ORDINAL로 하면 엄청나게 어려운 버그가 생김 (enum이 앞에 추가 될 경우 다른 값인데 0, 0 이 들어가는 경우)
  private RoleType roleType;
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModifiedDate;
  @Lob
  private String description;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public RoleType getRoleType() {
    return roleType;
  }

  public void setRoleType(RoleType roleType) {
    this.roleType = roleType;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Date getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(Date lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}