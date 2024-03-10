package edu.steria.training;
import lombok.*;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class College {
    private String name;
    private String website;
    private String mobile;
    private String founder;
    private Integer numberOfDept;
    private String location;
    private Date startingDate;

//    static final College obj = new College();

    static College createCollege(String name, String website, String mobile, String founder, Integer numberOfDept, String location, Date startingDate)
    {

        return new College(name, website, mobile, founder, numberOfDept, location, startingDate);
    }

}
