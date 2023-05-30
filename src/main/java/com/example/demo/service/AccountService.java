package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.Entity.Account;
import com.example.demo.dao.AccountDao;

@Service
public class AccountService {

	private final AccountDao accountdao;
	static int page = 1;

	@Autowired
	public AccountService(AccountDao accountdao) {
		this.accountdao = accountdao;
	}

	public List<Account> getAllAccounts() {
		return accountdao.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Account login(String email) {

		Account account = accountdao.findByEmail(email);

		return account;
	}

	public Boolean logincheck(Account account, String password, Model model) {

		boolean iserror = false;

		if (account == null) {
			model.addAttribute("emailerrormessage", "メールアドレスが見つかりませんでした");
			iserror = true;
			return iserror;
		}
		
		if (account.isDeleted()) {
			model.addAttribute("emailerrormessage", "メールアドレスが削除されています");
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

		Account account = accountdao.findByEmail(email);

		if (account != null) {

			if (account.isDeleted()) {

				account.setName(name);
				account.setPassword(password);
				account.setAddress(address);
				account.setDeleted(false);

				accountdao.save(account);

				return false;

			} else {

				model.addAttribute("findemail", "このメールアドレスは既に登録されています");
				return true;

			}

		}

		account = new Account();

		account.setName(name);
		account.setEmail(email);
		account.setPassword(password);
		account.setAddress(address);
		account.setDeleted(false);

		accountdao.save(account);

		return false;
	}

	public void deleteaccount(String email) {
		Account account = accountdao.findByEmail(email);
		account.setDeleted(true);
		accountdao.save(account);
	}

	public List<Account> sortAscending(List<Account> accounts) {
		Collections.reverse(accounts);
		return accounts;
	}
	
	public List<Account> paging(List<Account> account) {
		
		List<Account> list = new ArrayList<Account>();
		
		for(int i = 1 * ((page - 1) * 10) - 1; i < page * 10; i++) {
			
			if(i == -1) {
				i = 0;
			}
			
			try {
				
				list.add(account.get(i));
				
			} catch(Exception e) {
				
				break;
				
			}
		}
		
		return list;
	}

	public static int getPage() {
		return page;
	}

	public static void setPage(int page) {
		AccountService.page = page;
	}

}
