//package tmax.account2.repository;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import tmax.account2.domain.Account;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.*;
//
//public class MemoryAccountRepositoryTest {
//
//    MemoryAccountRepository repository = new MemoryAccountRepository();
//
//    @AfterEach
//    public void afterEach(){
//        repository.clearStore();
//    }
//
//    @Test
//    public void save(){
//        Account account = new Account();
//        account.setName("신호영");
//        repository.save(account);
//        Account result = repository.findById(account.getId()).get();
//        assertThat(account).isEqualTo(result);
//    }
//
//    @Test
//    public void findByName(){
//        Account account1 = new Account();
//        account1.setName("정상구");
//        repository.save(account1);
//
//        Account account2 = new Account();
//        account2.setName("정지우");
//        repository.save(account2);
//
//        Account result = repository.findByName("정지우").get();
//        assertThat(account2).isEqualTo(result);
//    }
//
//    @Test
//    public void findByResRegiNum(){
//        Account account1 = new Account();
//        account1.setName("정상구");
//        account1.setResRegiNumber("960513-1152248");
//        repository.save(account1);
//
//        Account account2 = new Account();
//        account2.setName("정지우");
//        account2.setResRegiNumber("941024-1022354");
//        repository.save(account2);
//
//        Account result = repository.findByResRegiNumber("960513-1152248").get();
//        assertThat(account1).isEqualTo(result);
//    }
//
//    @Test
//    public void findAll(){
//        Account account3 = new Account();
//        account3.setName("철수");
//        repository.save(account3);
//
//        Account account4 = new Account();
//        account4.setName("영희");
//        repository.save(account4);
//
//        Account account5 = new Account();
//        account5.setName("바둑이");
//        repository.save(account5);
//
//        List<Account> result = repository.findAll();
//        assertThat(result.size()).isEqualTo(3);
//    }
//}