//package ex1;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
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
////       생성
////      Member member = new Member();
////      member.setId(1L);
////      member.setName("한유진");
//
////      여기까지 비영속 상태
////      em.persist(member);
////      영속상태가 됨. (DB에 저장이 되는 시점X)
//
////      조회
////      Member findMember = em.find(Member.class, 1L);
//
////      삭제
////      em.remove(findMember);
////
////      수정
////      findMember.setName("김영한");
////      실제 데이터베이스에 commit을 하지 않아도 수정이 된다.
////      변경이 되었는지 transaction하는 시점에서 수정사항이 생기면 JPA가 업데이트 쿼리를 날린다.
//
////      ENUM
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
//}
