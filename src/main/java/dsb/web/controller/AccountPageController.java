package dsb.web.controller;

import dsb.web.controller.beans.AccountPageBean;
import dsb.web.domain.*;
import dsb.web.repository.AccountRepository;
import dsb.web.repository.TransactionRepository;
import dsb.web.service.AccountPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//TODO sessions / wat komt er door?
public class AccountPageController {

    private AccountPageService accountPageService;
    private AccountRepository accountRepository;


    @Autowired
    public AccountPageController(AccountPageService accountPageService, AccountRepository accountRepository) {
        this.accountPageService = accountPageService;
        this.accountRepository = accountRepository;
    }

    @GetMapping("accountPage")
    public String startAccountPage (Model model) {

        //account ophalen als dummy bean
        List <Account> listAccounts = accountRepository.findAll();
        Account account = listAccounts.get(0);

        AccountPageBean accountPageBean = accountPageService.makeAccountPageBean(account);

        model.addAttribute("accountPageBean", accountPageBean);


        List<Transaction> list = accountPageBean.getTransactions();
        for (Transaction t : list) {
            System.out.println(t);
        }

        return "account_page";
    }

}
