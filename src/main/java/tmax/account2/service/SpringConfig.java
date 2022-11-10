//package tmax.account2.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import tmax.account2.repository.AccountRepository;
//import tmax.account2.repository.JpaAccountRepository;
//import javax.persistence.EntityManager;
//
////
//@Configuration
//public class SpringConfig {
//
//        private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
////    private final AccountRepository accountRepository;
////
////    @Autowired
////    public SpringConfig(AccountRepository accountRepository) {
////        this.accountRepository = accountRepository;
////    }
//
//    @Bean
//    public AccountRepository accountRepository() {
//        return new JpaAccountRepository(em);
//    }
//
//    @Bean
//    public AccountService accountService(){
//        return new AccountService(accountRepository());
//    }
//}