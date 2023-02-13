package jpql;

import ex1.Member;
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
      Teem team = new Teem();
      team.setName("TeamA");
      em.persist(team);

      Mamber member = new Mamber();
      member.setUserName("member1");
      member.setAge(10);
      member.setTeam(team);
      em.persist(member);



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
      String query = "select m from Member m inner join m.team t";


      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}