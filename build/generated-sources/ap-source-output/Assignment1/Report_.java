package Assignment1;

import Assignment1.Userapp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-04T23:53:07")
@StaticMetamodel(Report.class)
public class Report_ { 

    public static volatile SingularAttribute<Report, Date> date;
    public static volatile SingularAttribute<Report, Integer> reportid;
    public static volatile SingularAttribute<Report, Integer> setcaloriegoalthatday;
    public static volatile SingularAttribute<Report, Integer> totalcalorieconsumed;
    public static volatile SingularAttribute<Report, Integer> totalsteptaken;
    public static volatile SingularAttribute<Report, Userapp> userid;
    public static volatile SingularAttribute<Report, Integer> totalcalorieburned;

}