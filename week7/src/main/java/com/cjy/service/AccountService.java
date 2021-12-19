package com.cjy.service;

import com.cjy.dao.AccountDao;
import com.cjy.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AccountService {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private AccountDao accountDao;

    public AccountService() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession();

        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    private void destroy() {
        try {
            sqlSession.commit();
            sqlSession.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Account> findAll() {
        List<Account> accounts = accountDao.findAll();
        destroy();
        return accounts;
    }

    public void deleteByPrimaryKey(String id) {
        accountDao.deleteByPrimaryKey(id);
        destroy();
    }

    public void insert(Account record) {
        accountDao.insert(record);
        destroy();
    }

    public Account selectByPrimaryKey(String id) {
        Account account = accountDao.selectByPrimaryKey(id);
        destroy();
        return account;
    }

    public void updateByPrimaryKey(Account record) {
        Date date = new Date();
        record.setUpdatetime(date);
        accountDao.updateByPrimaryKey(record);
        destroy();
    }

    public void transfer(String remitterId, String remitteeId, int money) {
        Account remitter = accountDao.selectByPrimaryKey(remitterId);
        Account remittee = accountDao.selectByPrimaryKey(remitteeId);
        remitter.setMoney(remitter.getMoney()-money);
        remittee.setMoney(remittee.getMoney()+money);
        accountDao.updateByPrimaryKey(remitter);
        accountDao.updateByPrimaryKey(remittee);
        destroy();
    }

}
