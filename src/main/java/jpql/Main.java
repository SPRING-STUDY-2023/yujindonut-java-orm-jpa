package jpql;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    // 애플리케이션 로딩 시점에 딱 한번 생성되어 애플리케이션 전체에서 공유됨
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mapping");

    // Transaction 단위를 실행할때마다 EntityManager를 만들어줌 - 데이터베이스 커넥션 하나를 받아온것
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Teem teamA = new Teem();
      teamA.setName("TeamA");
      em.persist(teamA);

      Teem teamB = new Teem();
      teamB.setName("TeamB");
      em.persist(teamB);

      Mamber member1 = new Mamber();
      member1.setUserName("member1");
      member1.setAge(10);
      member1.setType(MemberType.ADMIN);
      member1.setTeam(teamA);
      em.persist(member1);

      Mamber member2 = new Mamber();
      member2.setUserName("member2");
      member2.setAge(10);
      member2.setType(MemberType.ADMIN);
      member2.setTeam(teamA);
      em.persist(member2);

      Mamber member3 = new Mamber();
      member3.setUserName("member3");
      member3.setAge(10);
      member3.setType(MemberType.ADMIN);
      member3.setTeam(teamB);
      em.persist(member3);

      em.flush();
      em.clear();

//      Mamber result = em.createQuery("select m from Mamber m where m.userName=:username", Mamber.class).setParameter("username", "member").getSingleResult();

//      묵시적 JOIN
//      List<Teem> result = em.createQuery("select m.team from Mamber m", Teem.class).getResultList();
//      명시적 JOIN
//      List<Teem> result = em.createQuery("select t from Mamber m join m.team  t", Teem.class).getResultList();
//      임베디드 타입 프로젝션
//      em.createQuery("select o.addresses from Orders o", Addresses.class).getResultList();
//      스칼라 타입 프로젝션
//      em.createQuery("select new jpql.MemberDTO( m.userName, m.age) from Mamber m", MemberDTO.class).getResultList();

//      페이징
//      List<Mamber> result = em.createQuery("select m from Mamber m order by m.age desc", Mamber.class)
//          .setFirstResult(0)
//              .setMaxResults(0)
//                  .getResultList();
//      System.out.println("result size = " + result.size());
//      for (Mamber m : result) {
//        System.out.println("mamber = " + member);
//      }

//      JOIN
//      String query = "select m from Member m inner join m.team t";

//      서브쿼리
//      String query = "select (select avg(m.age) from Mamber m) as avgAge from Mamber m join Teem t on m.userName = t.name";
//      List<Mamber> result = em.createQuery(query, Mamber.class).getResultList();

//      JPQL 타입 표현
//      String query = "select m.userName, 'HELLO', True From Mamber m " +
////          "where m.type = jpql.MemberType.ADMIN";
////          + "where m.type = ADMIN"; //이렇게 직접 사용이 안됨
//                    "where m.type = :userType";
//
//          List<Mamber> result = em.createQuery(query, Mamber.class)
//              .setParameter("userType", MemberType.ADMIN)
//              .getResultList();

//          상속관계에서 엔티티타입 사용가능
//      Book book = new Book();
//      book.setName("JPA");
//      book.setAuthor("김영한");
//
//      em.persist(book);
//      em.createQuery("select i from Item i where type(i) = Book", Item.class);
      // Discriminator Value값이 Book인것을 가져옴

//      조건식
//      String query = "select case "
//          + "when m.age <= 10 then '학생요금' "
//          + "when m.age >= 60 then '경로요금' "
//          + "else '일반요금' "
//          + "end " + "from Mamber m";
//      String query = "select coalesce(m.userName, '이름없는 회원') as username "
//          + "from Mamber m ";
//      List<String> result = em.createQuery(query, String.class).getResultList();

//      경로표현식
//      String query = "select t.members.size From Team t";
//      Integer result = em.createQuery(query, Integer.class)
//              .getSingleResult();
//      System.out.println("result = " + result);
//      //묵시적 join - 잘 사용하지 않음
//      String query1 = "select t.members From Team t";
//      List<Collection>  result1 = em.createQuery(query1, Collection.class)
//          .getResultList();
//      System.out.println("result = " + result);

      //명시적 조인
//      String query2 = "select m.age From Team t join t.members m";
//      List<Collection>  result2 = em.createQuery(query2, Collection.class)
//          .getResultList();

//      FETCH 조인
//      프록시로 Team 가져옴
//      회원 100명을 select N + 1 (첫번째 날린 쿼리 (회원을 가져오기위해) + N (100번 돈다))
//      String query1 = "select m.team From Mamber m";
//      String query1 = "select m From Mamber m join fetch m.team";
//      List<Mamber> result = em.createQuery(query1, Mamber.class).getResultList();
//
//      for(Mamber m : result) {
//        System.out.println("mamber = " + m.getUserName() + ", " + m.getAge());
//      }
//      String query1 = "select t From Teem t";
//      List<Teem> result = em.createQuery(query1, Teem.class)
//          .setFirstResult(0)
//          .setMaxResults(2)
//          .getResultList();
//
//      for(Teem teem : result) {
//        System.out.println("Teem = " + teem.getName() + "| members= " + teem.getMembers().size());
//        for(Mamber mamber: teem.getMembers()){
//          System.out.println("-> member = " + mamber);
//        }
//      }

//      엔티티 직접 사용
//      String query = "select m From Mamber m where m =: member";
//      Mamber findMember = em.createQuery(query, Mamber.class)
//              .setParameter("member", member1)
//                  .getSingleResult();
//      System.out.println("findMember = " + findMember);

//      Named 쿼리
//      List<Mamber> resultList = em.createNamedQuery("Member.findByUsername")
//              .setParameter("username", "member1")
//                  .getResultList();
//
//      for(Mamber m : resultList) {
//        System.out.println("member : " + m);
//      }
//    벌크 연산
      //FLUSH가 자동 호출 ( 영속성 컨텍스트에 있는 것을 DB에 넣는 것 - DB에 있는 것을 영속성 컨텍스트에 넣는 것은 아님)
      int i = em.createQuery("update Mamber m set m.age = 20")
          .executeUpdate();
      System.out.println("result Count " + i);

      em.clear(); // 영속성 컨텍스트에 있는 값들은 DB 반영 전의 값, 영속성 컨텍스트를 정리해야함

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}