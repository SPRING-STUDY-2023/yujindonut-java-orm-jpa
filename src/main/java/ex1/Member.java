//package ex1;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;
//@Entity
//@SequenceGenerator(
//    name = "MEMBER_SEQ_GENERATOR",
//    sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
//    initialValue = 1, allocationSize = 1)
//public class Member {
//  @Id @GeneratedValue(strategy = GenerationType.AUTO)
//  private Long id;
//  @Column(name = "name")
//  private String username;
//  private Integer age;
//  @Enumerated(EnumType.STRING)
////  @Enumerated(EnumType.ORDINAL)
////  ORDINAL로 하면 엄청나게 어려운 버그가 생김 (enum이 앞에 추가 될 경우 다른 값인데 0, 0 이 들어가는 경우)
//  private RoleType roleType;
//  @Temporal(TemporalType.TIMESTAMP)
//  private Date createdDate;
//  @Temporal(TemporalType.TIMESTAMP)
//  private Date lastModifiedDate;
//  @Lob
//  private String description;
//
//  public Long getId() {
//    return id;
//  }
//
//  public void setId(Long id) {
//    this.id = id;
//  }
//
//  public String getUsername() {
//    return username;
//  }
//
//  public void setUsername(String username) {
//    this.username = username;
//  }
//
//  public Integer getAge() {
//    return age;
//  }
//
//  public void setAge(Integer age) {
//    this.age = age;
//  }
//
//  public RoleType getRoleType() {
//    return roleType;
//  }
//
//  public void setRoleType(RoleType roleType) {
//    this.roleType = roleType;
//  }
//
//  public Date getCreatedDate() {
//    return createdDate;
//  }
//
//  public void setCreatedDate(Date createdDate) {
//    this.createdDate = createdDate;
//  }
//
//  public Date getLastModifiedDate() {
//    return lastModifiedDate;
//  }
//
//  public void setLastModifiedDate(Date lastModifiedDate) {
//    this.lastModifiedDate = lastModifiedDate;
//  }
//
//  public String getDescription() {
//    return description;
//  }
//
//  public void setDescription(String description) {
//    this.description = description;
//  }
//}