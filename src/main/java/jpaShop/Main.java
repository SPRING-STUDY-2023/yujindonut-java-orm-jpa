//package jpaShop;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import jpaShop.domain.Book;
//import jpaShop.domain.Order;
//import jpaShop.domain.OrderItem;
//
//public class Main {
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
//
//      // 양방향 설계
////      Order order = new Order();
////      em.persist(order);
////      개발상의 편의, 조회할때의 편의를 위해서 양방향 관계를 만드는 것
////      order.addOrderItem(new OrderItem());
////
////      OrderItem orderItem = new OrderItem();
////      orderItem.setOrder(order);
////      em.persist(orderItem);
//
//      Book book = new Book();
//      book.setName("HH");
//      book.setPrice(1000);
//      book.setStockQuantity(1);
//
//      em.persist(book);
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