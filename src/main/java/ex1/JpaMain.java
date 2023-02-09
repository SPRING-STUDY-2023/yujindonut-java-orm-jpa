//package ex1;
//
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.OneToMany;
//import javax.persistence.Persistence;
//import org.hibernate.Hibernate;
//
//public class JpaMain {
//
//  public static void main(String[] args) {
//    // 애플리케이션 로딩 시점에 딱 한번 생성되어 애플리케이션 전체에서 공유됨
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//
//    // Transaction 단위를 실행할때마다 EntityManager를 만들어줌 - 데이터베이스 커넥션 하나를 받아온것
//    EntityManager em = emf.createEntityManager();
//    EntityTransaction tx = em.getTransaction();
//    tx.begin();
//
//    try {
////
////      Team team = new Team();
////      team.setName("TEAM A");
////      em.persist(team);
////
////      Member member = new Member();
////      member.setUsername("member1");
////      member.setTeamId(team.getId());
////      member.changeTeam(team);
////      em.persist(member);
//
////      em.flush(); // 싱크 맞추고
////      em.clear(); // 영속성 컨텐츠 싹 비우기
//
////      team.getMembers().add(member);
//      // 만약에 em.flush(), em.clear()를 하지 않았을 경우
//      // 1차 캐시에 멤버의 team select 하는 쿼리가 나가지 않은 상태
//      // 이 부분은 객체지향적으로 생각할때 양쪽에 다 넣어주는 것이 맞다. - Test케이스에서도 적용이 되어야하기에
//
////      Team findTeam = em.find(Team.class, team.getId());
////      List<Member> members = findTeam.getMembers();
//      // Member에 members라는 변수를 사용할때 team 정보를 가져오는 쿼리를 날린다.
//
//      // 연관관계가 없음
////      Team findTeam = em.find(Team.class, team.getId());
////      Team findTeam = findMember.getTeam();
//
//      // 수정도 가능함
////      Team newTeam = em.find(Team.class, 100L);
////      findMember.setTeam(newTeam);
//
////      Movie movie = new Movie();
////      movie.setId(1L);
////      movie.setName("바람과 함께 사라지다");
////      movie.setPrice(1111);
////      movie.setActor("HHH");
////      movie.setDirector("hhh");
//
////      em.persist(movie);
////
////      em.flush();
////      em.clear();
//
////      Movie findMovie = em.find(Movie.class, movie.getId());
//      // Item 과 inner join
////      System.out.println("find Movie " + findMovie);
//
//
////      프록시
////      Member member1 = new Member();
////      member1.setUsername("HI");
////      em.persist(member1);
////
////      em.flush();
////      em.clear();
////
////      Member refMember = em.getReference(Member.class, member1.getId());
////      System.out.println("refMember = " + refMember.getClass()); // Proxy
////      em.flush();
////      em.detach(refMember);
////      System.out.println("refMember = " + refMember.getUsername()); // LanyInitializationException오류
//
//      // 초기화 여부
////      System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
//
//      // 프록시 클래스 확인 방법
////      System.out.println(refMember.getClass());
//
//      // 프록시 강제 초기화
////      Hibernate.initialize(refMember);
//      // JPA - member.getName (select쿼리문 나감)
//
//
////      즉시 로딩과 지연로딩
////      Team team1 = new Team();
////      team1.setName("team1");
////      em.persist(team1);
////
////      Team team2 = new Team();
////      team2.setName("team2");
////      em.persist(team2);
////
////      Member member1 = new Member();
////      member1.setUsername("member1");
////      member1.setTeam(team1);
////      em.persist(member1);
////
////      Member member2 = new Member();
////      member2.setUsername("member2");
////      member2.setTeam(team2);
////      em.persist(member2);
////
////      em.flush();
////      em.clear();
////
////      Member m = em.find(Member.class, member1.getId());
////      System.out.println(m.getTeam().getClass());
////
////      System.out.println("-----");
////      // 팀을 터치하는 순간에 select 쿼리가 실행됨
////      m.getTeam().getName();
////      System.out.println("-----");
////
////      List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
//
//      //영속성 전이와 고아 객체
////      Child child1 = new Child();
////      Child child2 = new Child();
////
////      Parent parent = new Parent();
////      parent.addChild(child1);
////      parent.addChild(child2);
////
////      em.persist(parent); // @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL) 그 하위도 persist한다.
////      em.persist(child1);
////      em.persist(child2);
//
////      Parent findParent = em.find(Parent.class, parent.getId());
////      findParent.getChildList().remove(0);
////
////      값 타입
////      Member member1 = new Member();
////      member1.setUsername("member1");
////      member1.setHomeAddress(new Address("city", "streeet", "zipcode"));
////      member1.getFavoriteFoods().add("chicken");
////      member1.getFavoriteFoods().add("pizza");
//
////      member1.getAddress().add(new Address("city1", "streeet1", "zipcode1"));
////      member1.getAddress().add(new Address("city2", "streeet2", "zipcode2"));
////      em.persist(member1);
//
////      Member findMember = em.find(Member.class, member1.getId());
//
////      findMember.getHomeAddress().setCity("hhh"); // 오류 추적 어려움
////      findMember.setHomeAddress(new Address("newCity", "newStreet", "newZipcode"));
//
//      //Collection 타입 수정
////      findMember.getFavoriteFoods().remove("chicken");
////      findMember.getFavoriteFoods().add("스파게티");
//
//      // 값 타입 컬렉션의 대안
////      findMember.getAddressEntityList().remove(new AddressEntity("city2", "streeet2", "zipcode2"));
////      findMember.getAddressEntityList().add(new AddressEntity("city3", "streeet3", "zipcode3"));
//      // equals & hashcode로 같은 값 판별함
//
////      List<Address> addressList = findMember.getAddress();
////      for(Address address: addressList) { // Collection들은 지연로딩이여서 이때 select함
////        System.out.println("address : " + address.getZipcode());
////      }
//
////
////      Member member2 = new Member();
////      member2.setUsername("member2");
////      member2.setHomeAddress(new Address("city", "streeet", "zipcode"));
////      em.persist(member2);
//
////      member1.getHomeAddress().setCity("newCity"); //sideEffect
//
//      List<Member> result = em.createQuery("select m from Member m where m.name like '%hi%'", Member.class).getResultList();
//
//
//      tx.commit();
//    } catch (Exception e) {
//      tx.rollback();
//    } finally {
//      em.close();
//    }
//
//    emf.close();
//  }
//
//  private static void printMember(Member member) {
//    System.out.println("member = " + member.getUsername());
//  }
//
//  private static void printTeamAndMember(Member member) {
//    String username = member.getUsername();
//    System.out.println("username = " + username);
//
//    Team team = member.getTeam();
//    System.out.println("team = " + team.getName());
//  }
//}
