package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
    
    List<Account> findAll();
    
    Account findByEmail(String email);
    
}