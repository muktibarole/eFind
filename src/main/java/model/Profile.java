package model;

/**
 * Created by Prajwal on 11/27/2016.
 */
public class Profile {

    private String uid;
    private String tnumber;
    private String department;
    private String program;
    private String gpa;
    private String skills;
    private String projects;
    private String interest;

    public  Profile(String uid, String tnumber, String department, String program, String gpa, String skills, String projects, String interest) {
        this.uid = uid;
        this.tnumber = tnumber;
        this.department = department;
        this.program = program;
        this.gpa = gpa;
        this.skills = skills;
        this.projects = projects;
        this.interest = interest;
    }

    public String getUid() {
        return uid;
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
