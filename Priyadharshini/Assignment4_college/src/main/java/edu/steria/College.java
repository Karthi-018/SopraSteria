package edu.steria;
import java.util.*;
public class College {
    private int id;
    private String name;
    private String website;
    private String mobile;
    private String founder;
    private int numberOfdept;
    private String location;
    private Date startingdate;



    public College(int id, String name,String website,String mobile,String founder, int numberOfdept,String location, Date startingdate) {
        this.id= id;
        this.name = name;
        this.website = website;
        this.mobile = mobile;
        this.founder = founder;
        this.numberOfdept = numberOfdept;
        this.location = location;
        this.startingdate = startingdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public int getNumberOfdept() {
        return numberOfdept;
    }

    public void setNumberOfdept(int numberOfdept) {
        this.numberOfdept = numberOfdept;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartingdate() {
        return startingdate;
    }

    public void setStartingdate(Date startingdate) {
        this.startingdate = startingdate;
    }

    @Override
    public String toString() {
        return "College{" +
                "name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", mobile='" + mobile + '\'' +
                ", founder='" + founder + '\'' +
                ", numberOfdept=" + numberOfdept +
                ", location='" + location + '\'' +
                ", startingdate=" + startingdate +
                '}';
    }
}


