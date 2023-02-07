package ex1;

import java.util.List;
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
//
//      Team team = new Team();
//      team.setName("TEAM A");
//      em.persist(team);
//
//      Member member = new Member();
//      member.setUsername("member1");
//      member.setTeamId(team.getId());
//      member.changeTeam(team);
//      em.persist(member);

//      em.flush(); // 싱크 맞추고
//      em.clear(); // 영속성 컨텐츠 싹 비우기

//      team.getMembers().add(member);
      // 만약에 em.flush(), em.clear()를 하지 않았을 경우
      // 1차 캐시에 멤버의 team select 하는 쿼리가 나가지 않은 상태
      // 이 부분은 객체지향적으로 생각할때 양쪽에 다 넣어주는 것이 맞다. - Test케이스에서도 적용이 되어야하기에

//      Team findTeam = em.find(Team.class, team.getId());
//      List<Member> members = findTeam.getMembers();
      // Member에 members라는 변수를 사용할때 team 정보를 가져오는 쿼리를 날린다.

      // 연관관계가 없음
//      Team findTeam = em.find(Team.class, team.getId());
//      Team findTeam = findMember.getTeam();

      // 수정도 가능함
//      Team newTeam = em.find(Team.class, 100L);
//      findMember.setTeam(newTeam);

      Movie movie = new Movie();
//      movie.setId(1L);
      movie.setName("바람과 함께 사라지다");
      movie.setPrice(1111);
      movie.setActor("HHH");
      movie.setDirector("hhh");

      em.persist(movie);

      em.flush();
      em.clear();

      Movie findMovie = em.find(Movie.class, movie.getId());
      // Item 과 inner join
      System.out.println("find Movie " + findMovie);



      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}
