package steria;
import java.util.Date;
public class College
{
    private String name;
    private String website;
    private String mobile;
    private String founder;
    private Integer numberOfDept;
    private String location;
    private Date startingDate;

    public College(){}
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
    public Integer getNumberOfDept() {
        return numberOfDept;
    }
    public void setNumberOfDept(Integer numberOfDept) {
        this.numberOfDept = numberOfDept;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Date getStartingDate() {
        return startingDate;
    }
    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }
    public College(String name, String website, String mobile, String founder, Integer numberOfDept, String location, Date startingDate) {
        this.name = name;
        this.website = website;
        this.mobile = mobile;
        this.founder = founder;
        this.numberOfDept = numberOfDept;
        this.location = location;
        this.startingDate = startingDate;
    }
    static College createCollege(String name, String website, String mobile, String founder, Integer numberOfDept, String location, Date startingDate)
    {
        return new College(name, website, mobile, founder, numberOfDept, location, startingDate);
    }
    @Override
    public String toString() {
        return "College{" +
                "name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", mobile='" + mobile + '\'' +
                ", founder='" + founder + '\'' +
                ", numberOfDept=" + numberOfDept +
                ", location='" + location + '\'' +
                ", startingDate=" + startingDate +
                '}';
    }   }

