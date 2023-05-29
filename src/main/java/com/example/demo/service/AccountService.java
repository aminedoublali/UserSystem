package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDao;

@Service
public class AccountService {
	
    private final Repository accountdao;

    @Autowired
    public AccountService(AccountDao accountdao) {
        this.accountdao = accountdao;
    }

    public List<Account> getAllAccounts() {
        return accountdao.findAll();
    }
}
