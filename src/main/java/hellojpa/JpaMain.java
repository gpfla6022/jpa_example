package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello_jpa");

        EntityManager em = emf.createEntityManager();
        // EntityManager를 생성하였다는 것은 DB Connection을 획득하였다는 것과 같다.

        EntityTransaction tx = em.getTransaction();
        // transaction start;
        tx.begin();

        /* 데이터 추가
        // 작동될 코드를 입력한다.
        try {
            // DB에 저장 할 Entity객체 생성
            Member member = new Member();

            // Member객체에 값을 할당한다.
            member.setId(2L);
            member.setName("황수진");

            // EntityManager의 persist 메소드를 통하여 객체를 DB에 저장
            em.persist(member);

            // COMMIT;
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.clear(); // DB접속 끊어준다.
        }
        */

        /* 데이터 수정
        try{
            // 데이터 수정을 위해 기존 데이터를 불러온다.
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("짱구");

            // em.persist(); 를 해주지 않아도 됨
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.clear();
        }*/

        /* 데이터 삭제
        try{
            Member findMember = em.find(Member.class, 1l);

            em.remove(findMember);

        }catch(Exception e){
            tx.rollback();
        }finally {
            em.clear();
        }
         */

        // JPQL
        try{

            List<Member> members = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();

            for( Member member : members ){
                System.out.println("member : " + member.getName());
            }
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.clear();
        }


        // 어플리케이션이 종료된다면 EntityManagerFactory를 종료해야 한다.
        em.close();

    }

}
