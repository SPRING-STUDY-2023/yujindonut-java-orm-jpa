package ex1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

  public static void main(String[] args) {
    // 애플리케이션 로딩 시점에 딱 한번 생성되어 애플리케이션 전체에서 공유됨
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mapping");

    // Transaction 단위를 실행할때마다 EntityManager를 만들어줌 - 데이터베이스 커넥션 하나를 받아온것
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {

      Team team = new Team();
      team.setName("TEAM A");
      em.persist(team);

      Member member = new Member();
      member.setUsername("member1");
//      member.setTeamId(team.getId());
      member.setTeam(team);
      em.persist(member);

      // 객체지향적이지 않은 설계
      Member findMember = em.find(Member.class, member.getId());
//      Long findTeamId = findMember.getTeamId();

      em.flush(); // 싱크 맞추고
      em.clear(); // 영속성 컨텐츠 싹 비우기

      // 연관관계가 없음
//      Team findTeam = em.find(Team.class, team.getId());
      Team findTeam = findMember.getTeam();

      // 수정도 가능하다
      Team newTeam = em.find(Team.class, 100L);
      findMember.setTeam(newTeam);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}
