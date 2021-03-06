package dsb.web.controller.beans;

import dsb.web.domain.Company;
import dsb.web.domain.Customer;
import dsb.web.domain.Employee;
import dsb.web.domain.Sector;
import dsb.web.service.validators.*;
import org.springframework.context.annotation.Scope;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CompanyBean {

    private boolean existing;


    @NotBlank(message = "Veld is leeg")
    @CompanyNameConstraint
    private String name;

    @NotBlank(message = "Veld is leeg")
    @KvKNumberConstraint
    private String KVKno;

    @NotBlank(message = "Veld is leeg")
    @VatNoConstraint
    private String BTWno;

    private Sector sector;
    private Employee accountManager;
    private Customer currentCustomer;

    public CompanyBean(boolean existing, String name, String KVKno, String BTWno, Sector sector, Employee accountManager, Customer currentCustomer) {
        this.existing = existing;
        this.name = name;
        this.KVKno = KVKno;
        this.BTWno = BTWno;
        this.sector = sector;
        this.accountManager = accountManager;
        this.currentCustomer = currentCustomer;
    }

    public CompanyBean() {
    }

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKVKno() {
        return KVKno;
    }

    public void setKVKno(String KVKno) {
        this.KVKno = KVKno;
    }

    public String getBTWno() {
        return BTWno;
    }

    public void setBTWno(String BTWno) {
        this.BTWno = BTWno;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Employee getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(Employee accountManager) {
        this.accountManager = accountManager;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    @Override
    public String toString() {
        return "CompanyBean{" +
                ", existing='" + existing + '\'' +
                ", name='" + name + '\'' +
                ", KVKno='" + KVKno + '\'' +
                ", BTWno='" + BTWno + '\'' +
                ", sector='" + sector + '\'' +
                ", accountManager='" + accountManager + '\'' +
                ", currentCustomer='" + currentCustomer + '\'' +
                '}';
    }
}
