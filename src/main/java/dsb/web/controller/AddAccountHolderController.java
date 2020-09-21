package dsb.web.controller;

import dsb.web.controller.beans.AccountHolderTokenBean;
import dsb.web.controller.beans.ConfirmBean;
import dsb.web.controller.beans.LoginBean;
import dsb.web.controller.beans.PrintAccountDataBean;
import dsb.web.domain.Account;
import dsb.web.domain.AccountHolderToken;
import dsb.web.domain.Company;
import dsb.web.domain.Customer;
import dsb.web.repository.AccountHolderTokenRepository;
import dsb.web.repository.CustomerRepository;
import dsb.web.service.AddAccountHolderService;
import dsb.web.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Attr;

import java.sql.SQLOutput;
import java.util.*;


@Controller
@SessionAttributes({AttributeMapping.LOGGED_IN_CUSTOMER, AttributeMapping.SELECTED_ACCOUNT})
public class AddAccountHolderController {

    @Autowired
    private SignInService signInService;
    private CustomerRepository customerRepository;
    private AddAccountHolderService addAccountHolderService;

    public AddAccountHolderController(SignInService signInService, CustomerRepository customerRepository, AddAccountHolderService addAccountHolderService) {
        this.addAccountHolderService = addAccountHolderService;
        this.signInService = signInService;
        this.customerRepository = customerRepository;
    }

    @GetMapping("add-account-holder")
    ModelAndView addAccountHolderHandler(Model model){
        ModelAndView mav = new ModelAndView("add-account-holder");
        Account account = (Account) model.getAttribute(AttributeMapping.SELECTED_ACCOUNT);
        mav.addObject("accountNo", account.getAccountNo());
        return mav;
    }

    @PostMapping("confirm-add-account-holder")
    public String addAccountHolderVerifyHandler(
            @RequestParam(name = "password") String password,
            @RequestParam(name = "new_account_holder") String newAccountHolder,
            @RequestParam(name = "tokenCode") String tokenCode,
            @ModelAttribute(AttributeMapping.LOGGED_IN_CUSTOMER) Customer loggedInCustomer,
            @ModelAttribute(AttributeMapping.SELECTED_ACCOUNT) Account account,
            Model model) {
        String usernameValid = addAccountHolderService.checkUsernameValidity(newAccountHolder, loggedInCustomer, account);
        Customer passwordCorrect = signInService.checkCredentials(loggedInCustomer.getUsername(), password);
        if (usernameValid != "" || passwordCorrect == null) {
            model.addAttribute("errorMessage", usernameValid);
            return ("add-account-holder");
        } else {
            model.addAttribute("confirmBean", addAccountHolderService.getConfirmBeanAccountHolderToken());
            addAccountHolderService.createAddAccountHolderToken(customerRepository.findOneByUsername(newAccountHolder).get(), account, tokenCode);
            return "confirm";
        }
    }


    @GetMapping("confirm-add-holder")
    String addAccountHolderConfirmHandler(
            @ModelAttribute ConfirmBean confirmBean,
            Model model){
        System.out.println(confirmBean);
        model.addAttribute("confirmBean", confirmBean);
        return "confirm";
    }



    /*resolve tokens:*/

    @PostMapping("resolve-account-holder-token")
    String resolvePageHandler(@RequestParam(name = "tokenId") String tokenId,
                   Model model){
        //print Map:
        /*Map<String,Object> map = model.asMap();
        for (Map.Entry<String,Object> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }*/
        model.addAttribute("tokenId", tokenId);
        model.addAttribute("errorMsg", null);
        return "resolve-account-holder-token";
    }

    @PostMapping("resolve-account-holder-token-verify")
    String resolvePageVerifyHandler(@RequestParam(name = "tokenCode") String tokenCode,
                    @ModelAttribute("tokenId") String tokenId,
                    @ModelAttribute(AttributeMapping.LOGGED_IN_CUSTOMER) Customer loggedInCustomer,
                   Model model){
        Account acc = addAccountHolderService.resolveToken(tokenId, tokenCode, loggedInCustomer);
        if (acc != null) {
            model.addAttribute(new ConfirmBean("Gefeliciteerd!", "Je bent toegevoegd als nieuwe rekeninghouder aan " + acc.getAccountNo(), "account_overview", "OK"));
            return "confirm";
        }
        model.addAttribute("tokenId", tokenId);
        model.addAttribute("errorMsg", "De door jou ingevoerde code is incorrect, probeer het nogmaals");
        return "resolve-account-holder-token";
    }


    @RestController
    @RequestMapping(value = "/find_users")
    @SessionAttributes({AttributeMapping.LOGGED_IN_CUSTOMER, AttributeMapping.SELECTED_ACCOUNT})
    class FindUserController{


        public FindUserController() {
            super();
        }

        @GetMapping(value = "/{usernameCheck}")
        public String findUser(@PathVariable("usernameCheck") String usernameCheck,
                               @ModelAttribute(AttributeMapping.LOGGED_IN_CUSTOMER) Customer loggedInCustomer,
                               @ModelAttribute(AttributeMapping.SELECTED_ACCOUNT) Account account){
            String isValid = addAccountHolderService.checkUsernameValidity(usernameCheck, loggedInCustomer, account);
            if (isValid == null) {
                return usernameCheck;
            }
            return isValid;
        }
    }

}
