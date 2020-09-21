package dsb.web.controller.beans;

import dsb.web.service.validators.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@FieldsValueMatch(field = "password", fieldMatch = "password2")
public class SignUpBean {

    //TODO default message not blank wijz
    //TODO alles 1 annotatie

    @Size(min=2, message = "Moet minimaal 2 letters zijn")
    private String surname;

    private String inserts;

    @NotBlank(message = "Veld is leeg")
    private String initials;

    @NotBlank(message = "Veld is leeg")
    private String street;

    @NotBlank(message = "Veld is leeg")
    @IntegerConstraint
    private String houseNumberString;
    private Integer houseNumber;

    private String affixes;

    @NotBlank(message = "Veld is leeg")
    @ZipCodeConstraint
    private String zipCode;

    @NotBlank(message = "Veld is leeg")
    private String city;

    @NotBlank(message = "Veld is leeg")
    @IntegerConstraint
    private String socialSecurityNoString;
    private Integer socialSecurityNo;

    @Size(min=6, message = "Moet minimaal 6 tekens zijn")
    @UsernameOccupiedConstraint
    private String username;

    @NotBlank(message = "Veld is leeg")
    private String password;

    @NotBlank(message = "Veld is leeg")
    private String password2;


    public SignUpBean() {
    }


    public Integer checkIfInteger(String ageString) {


        try {
            return Integer.parseInt(ageString);
        } catch(NumberFormatException e){
            return null;
        }
    }


    public void nameStyler() {
        //styling of initials
        String[] asArray = initials.trim().replaceAll("[^a-zA-Z]", "")
                .toUpperCase().split("");
        initials = String.join(".", asArray) + ".";

        //styling of surname
        String mid = surname.toLowerCase();
        surname = mid.substring(0,1).toUpperCase() + mid.substring(1);
    }



    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInserts() {
        return inserts;
    }

    public void setInserts(String inserts) {
        this.inserts = inserts;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAffixes() {
        return affixes;
    }

    public void setAffixes(String affixes) {
        this.affixes = affixes;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSocialSecurityNo() {
        return socialSecurityNo;
    }

    public void setSocialSecurityNo(Integer socialSecurityNo) {
        this.socialSecurityNo = socialSecurityNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //TODO dit moet nog opgelost
    public String getHouseNumberString() {
        setHouseNumber(checkIfInteger(houseNumberString));
        setSocialSecurityNo(checkIfInteger(socialSecurityNoString));
        return houseNumberString;
    }

    public void setHouseNumberString(String houseNumberString) {
        this.houseNumberString = houseNumberString;
    }

    public String getSocialSecurityNoString() {
        setSocialSecurityNo(checkIfInteger(socialSecurityNoString));
        return socialSecurityNoString;
    }

    public void setSocialSecurityNoString(String socialSecurityNoString) {
        this.socialSecurityNoString = socialSecurityNoString;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}