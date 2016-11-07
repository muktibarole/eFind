package model;

import static model.AccountType.student;

/**
 * Created by Prajwal on 11/5/2016.
 */
public  class Users {

    private int uid;
    private String username;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private String telephone;
    private AccountType accountType;

    public Users(String username, String firstName, String lastName, String emailId, String password, String telephone, AccountType accountType) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
        this.telephone = telephone;
        this.accountType = accountType;
    }

    public Users(int uid, String username, String firstName, String lastName, String emailId, String password, String telephone, AccountType accountType) {
        this(username, firstName, lastName, emailId, password, telephone, accountType);
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}