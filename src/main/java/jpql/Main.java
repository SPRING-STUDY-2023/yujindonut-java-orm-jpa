package jpql;

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

      Mamber member = new Mamber();
      member.setUserName("member1");
      member.setAge(10);
      em.persist(member);

      Mamber result = em.createQuery("select m from Mamber m where m.userName=:username", Mamber.class)
              .setParameter("username", "member")
                  .getSingleResult();

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}