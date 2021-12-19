import com.cjy.domain.Account;
import com.cjy.service.AccountService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class AccountServiceTest {
    private AccountService accountService;
    @Before
    public void init() throws IOException {
        accountService = new AccountService();
    }
    @Test
    public void testFindAll(){
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }

    @Test
    public void testDeleteByPrimaryKey() {
        accountService.deleteByPrimaryKey("412");
    }

    @Test
    public void testInsert() {
        Date date = new Date();
        accountService.insert(new Account("412", "Feng", 100, date, date));
    }

    @Test
    public void testSelectByPrimaryKey() {
        Account account = accountService.selectByPrimaryKey("1234");
        System.out.println(account);
    }

    @Test
    public void testUpdateByPrimaryKey() {
        Date date = new Date();
        accountService.updateByPrimaryKey(new Account("412", "Feng", 200, date, date));
    }

    @Test
    public void transfer() {
        accountService.transfer("1234","125", 100);
    }

}
