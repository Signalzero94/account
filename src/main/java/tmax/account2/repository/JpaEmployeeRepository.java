//package tmax.account2.repository;
//
//import org.springframework.stereotype.Repository;
//import tmax.account2.domain.Account;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//import java.util.Optional;
//
//public class JpaAccountRepository implements AccountRepository{
//
//    @PersistenceContext
//    private final EntityManager em;
//
//    public JpaAccountRepository(EntityManager em) {
//        this.em = em;
//    }
//
//    @Override
//    public Account save(Account account) {
//        em.persist(account);
//        return account;
//    }
//
//    @Override
//    public Optional<Account> findById(Long id) {
//        Account account = em.find(Account.class, id);
//        return Optional.ofNullable(account);
//    }
//
//    @Override
//    public Optional<Account> findByName(String name) {
//        List<Account> result = em.createQuery("select m from Account m where m.name =:name", Account.class)
//                .setParameter("name", name).getResultList();
//        return result.stream().findAny();
//    }
//
//    @Override
//    public Optional<Account> findByResRegiNumber(String resRegiNumber) {
//        List<Account> result = em.createQuery("select a from Account a where a.resRegiNumber=:resRegiNumber", Account.class)
//                .setParameter("resRegiNumber",resRegiNumber).getResultList();
//        return result.stream().findAny();
//    }
//
//    @Override
//    public List<Account> findAll() {
//        return em.createQuery("select m from Account m", Account.class).getResultList();    }
//
//    @Override
//    public Optional<Account> delete(Account account){
//        em.remove(account);
//        return Optional.ofNullable(account);
//    }
//
//    @Override
//    public Optional<Account> deleteById(Long id){
//        Account account = em.find(Account.class, id);
//        em.remove(account);
//        return Optional.ofNullable(account);
//    }
//
//    @Override
//    public Optional<Account> deleteByName(String name) {
//        List<Account> result = em.createQuery("select a from Account a where a.name=:name", Account.class)
//                .setParameter("name", name).getResultList();
//        Optional<Account> account = result.stream().findAny();
//        em.remove(account);
//        return account;
//    }
//
//    @Override
//    public Optional<String> deleteByResRegiNumber(String resRegiNumber) {
//        em.createQuery("delete from Account a where a.resRegiNumber=:resRegiNumber")
//                .setParameter("resRegiNumber", resRegiNumber).executeUpdate();
//        em.flush();
//        return Optional.ofNullable(resRegiNumber);
//    }
//}