package model;

import static model.AccountType.student;

/**
 * Created by Prajwal on 11/5/2016.
 */
public  class Users {

    private int uid;
    private String username;
    private String emailId;
    private String password;
    private String telephone;
    private String accountType;

    public Users(String username, String emailId, String password, String telephone, String accountType) {
        this.username = username;
        this.emailId = emailId;
        this.password = password;
        this.telephone = telephone;
        this.accountType = accountType;
    }

    public Users(int uid, String username, String emailId, String password, String telephone, String accountType) {
        this(username,  emailId, password, telephone, accountType);
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
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

    public String getAccountType() {
        return accountType;
    }
}