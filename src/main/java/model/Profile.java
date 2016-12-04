package model;

/**
 * Created by Prajwal on 11/27/2016.
 */
public class Profile {

    private int uid;
    private String firstName;
    private String lastName;
    private String userName;
    private String tnumber;
    private String department;
    private String program;
    private String gpa;
    private String skills;
    private String projects;
    private String interest;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



    public  Profile(int uid,String username,String firstName,String lastName,String tnumber, String program, String department, String gpa, String skills, String interest, String projects) {
        this.uid = uid;
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=username;
        this.tnumber = tnumber;
        this.department = department;
        this.program = program;
        this.gpa = gpa;
        this.skills = skills;
        this.projects = projects;
        this.interest = interest;
    }

    public int getUid() {
        return uid;
    }

    public String getFirstname(){
        return firstName;
    }

    public String getLastname(){
        return lastName;
    }

    public String getUserName(){
        return userName;
    }

    public String getTnumber() {
        return tnumber;
    }

    public String getDepartment() {
        return department;
    }

    public String getProgram() {
        return program;
    }

    public String getGpa() {
        return gpa;
    }

    public String getSkills() {
        return skills;
    }

    public String getProjects() {
        return projects;
    }

    public String getInterest() {
        return interest;
    }
}
