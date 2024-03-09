package edu.steria.train;
import lombok.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@ToString
@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegePojo
{
    private String name;
    private String website;
    private String mobile;
    private String founder;
    private Integer numberOfDept;
    private String location;
    private Date startingDate;
    public CollegePojo(String detail) throws ParseException {
        String[] details = detail.split(",");
        this.name = details[0];
        this.website = details[1];
        this.mobile = details[2];
        this.founder = details[3];
        this.numberOfDept = Integer.parseInt(details[4]);
        this.location = details[5];
        this.startingDate = new SimpleDateFormat("yyyy-MM-dd").parse(details[6]);
    }
    public static CollegePojo createCollege(String detail) throws ParseException  {

        return new CollegePojo(detail);

    }
}
