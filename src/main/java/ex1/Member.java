package ex1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity(name = "USER")
@SequenceGenerator(
    name = "MEMBER_SEQ_GENERATOR",
    sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
    initialValue = 1, allocationSize = 1)
public class Member extends BaseEntity {
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "MEMBER_ID")
  private Long id;
  @Column(name = "USERNAME")
  private String username;

//  @Column(name="TEAM_ID")
//  private Long teamId;

  // Member입장에서는 Many Team 입장에서는 One
  @ManyToOne(fetch = FetchType.LAZY)

  // Join해야하는 컬럼이 뭐니
  @JoinColumn(name = "TEAM_ID")
  private Team team;

  @OneToOne
  @JoinColumn(name="LOCKER_ID")
  private Locker locker;
  private Integer age;

  public Set<String> getFavoriteFoods() {
    return favoriteFoods;
  }

  public void setFavoriteFoods(Set<String> favoriteFoods) {
    this.favoriteFoods = favoriteFoods;
  }

  public List<Address> getAddress() {
    return address;
  }

  public void setAddress(List<Address> address) {
    this.address = address;
  }

  @ElementCollection
  @CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name="MEMBER_ID"))
  @Column(name = "FOOD_NAME") // 값이 단하나일때만 가능
  private Set<String> favoriteFoods = new HashSet<>();

  @ElementCollection
  @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name="MEMBER_ID"))
  private List<Address> address = new ArrayList<>();

  public Period getWorkPeriod() {
    return workPeriod;
  }

  public void setWorkPeriod(Period workPeriod) {
    this.workPeriod = workPeriod;
  }

  public Address getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(Address homeAddress) {
    this.homeAddress = homeAddress;
  }

  public Address getWorkAddress() {
    return workAddress;
  }

  public void setWorkAddress(Address workAddress) {
    this.workAddress = workAddress;
  }
//  @ManyToMany
//  @JoinTable(name = "MEMBER_PRODUCT")
//  private List<Product> productList = new ArrayList<>();

  @OneToMany(mappedBy = "member")
  private List<MemberProduct> memberProducts = new ArrayList<>();

  @Embedded
  private Period workPeriod;

  @Embedded
  private Address homeAddress;

  @Embedded
  // 속성 재정의
  @AttributeOverrides({
      @AttributeOverride(name="city", column = @Column(name="WORK_CITY")),
      @AttributeOverride(name="street", column = @Column(name="WORK_STREET")),
      @AttributeOverride(name="zipcode", column = @Column(name="WORK_ZIPCODE"))
  })
  private Address workAddress;

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}