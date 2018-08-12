package com.qa.AccountManagement;

import com.qa.AccountManagement.model.Account;
import com.qa.AccountManagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/api")
public class ApplicationController {



    @Autowired
    private AccountRepository accountRepository;




    @GetMapping("/accounts")
    @ResponseBody
    public List<Account> retrieveAllAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping("/accounts")
    public Account addAccount(@RequestBody Account account) {


        return accountRepository.save(account);


    }



    @GetMapping("/accounts/{accountNumber}")
    @ResponseBody
    public List<Optional<Account>> retrieveAccountById(@PathVariable String accountNumber) {

        List<Optional<Account>> list = new ArrayList<>();
        list.add(accountRepository.findById(accountNumber));


        return list;

    }

    @DeleteMapping("/accounts/delete/{accountNumber}")
    public void deleteQuestion(@PathVariable String accountNumber) {

        accountRepository.deleteById(accountNumber);

    }



}
