//package tmax.account2.service;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import tmax.account2.domain.Account;
//import tmax.account2.repository.MemoryAccountRepository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class AccountServiceTest {
//
//    AccountService accountService;
//    MemoryAccountRepository repository;
//
//    @BeforeEach
//    public void beforeEach(){
//        repository = new MemoryAccountRepository();
//        accountService = new AccountService(repository);
//
//
//    }
//
//    @AfterEach
//    public void afterEach(){
//        repository.clearStore();
//    }
//
//    @Test
//    void 회원가입() {
//        //given
//        Account account = new Account();
//        account.setName("호영");
//
//        //when
//        Long saveId = accountService.join(account);
//
//        //then
//        Account findAccount = accountService.findOne(saveId).get();
//        Assertions.assertThat(account.getName()).isEqualTo(findAccount.getName());
//    }
//
//    @Test
//    public void 중복_회원_예외(){
//        //given
//        Account account1 = new Account();
//        account1.setName("지우");
//        account1.setResRegiNumber("999999-1111111");
//
//        Account account2 = new Account();
//        account2.setName("정지우");
//        account2.setResRegiNumber("999999-1111111");
//
//        //when
//        accountService.join(account1);
//        IllegalStateException e = assertThrows(IllegalStateException.class, () -> accountService.join(account2));
//        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
////        try{
////            accountService.join(account2);
////            fail();
////        }catch(IllegalStateException e){
////            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
////        }
//
//        //then
//    }
//
//
//    @Test
//    void findAccount() {
//    }
//
//    @Test
//    void findOne() {
//    }
//}