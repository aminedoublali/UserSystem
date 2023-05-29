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
    
    public boolean logincheck(Account account, String password, Model model) {
    	
    	boolean iserror = false;
    	
    	if (account == null) {
            model.addAttribute("emailerrormessage", "メールアドレスが見つかりませんでした");
            iserror = true;
            return iserror;
        }
    	
    	if (!account.getPassword().equals(password)) {
        	model.addAttribute("passworderrormessage", "パスワードが間違っています");
        	iserror = true;
        }
    	
    	return iserror;
    	
    }
    
    public boolean signup(String name, String email, String password, String address, Model model) {
    	
    	boolean iserror = false;
    	
        if (accountdao.findByEmail(email) != null) {
            model.addAttribute("findemail", "このメールアドレスは既に登録されています");
            iserror = true;
        }

        Account account = new Account();
        
        account.setName(name);
        account.setEmail(email);
        account.setPassword(password);
        account.setAddress(address);
        account.setDeleted(false);
        
        accountdao.save(account);
        
        return iserror;
    }
    
}
