package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.Entity.Account;
import com.example.demo.dao.AccountDao;

@Service
public class AccountService {
	
    private final AccountDao accountdao;

    @Autowired
    public AccountService(AccountDao accountdao) {
        this.accountdao = accountdao;
    }

    public List<Account> getAllAccounts() {
        return accountdao.findAll();
    }
    
    public Account login(String email) {
    	
        Account account = accountdao.findByEmail(email);
        
        return account;
    }
    
    public void logincheck(Account account, String password, Model model) {
    	
    	if (account == null) {
            model.addAttribute("emailerrormessage", "メールアドレスが見つかりませんでした");
            return;
        }
    	
    	if (!account.getPassword().equals(password)) {
        	model.addAttribute("passworderrormessage", "パスワードが間違っています");
        }
    	
    }
    
    public void registerAccount(String name, String email, String password, String address) {
    	
        if (accountdao.findByEmail(email) != null) {
            throw new IllegalArgumentException("同じEmailが既に存在します");
        }

        Account account = new Account();
        account.setName(name);
        account.setEmail(email);
        account.setPassword(password);
        account.setDeleted(false);
        
        accountdao.save(account);
    }
    
}
