package Assignment1;

import Assignment1.Consumption;
import Assignment1.Credential;
import Assignment1.Report;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-04T23:53:07")
@StaticMetamodel(Userapp.class)
public class Userapp_ { 

    public static volatile SingularAttribute<Userapp, String> firstname;
    public static volatile SingularAttribute<Userapp, String> address;
    public static volatile SingularAttribute<Userapp, String> gender;
    public static volatile CollectionAttribute<Userapp, Consumption> consumptionCollection;
    public static volatile SingularAttribute<Userapp, Short> postcode;
    public static volatile SingularAttribute<Userapp, Short> levelofactivityonetofive;
    public static volatile SingularAttribute<Userapp, BigDecimal> weight;
    public static volatile SingularAttribute<Userapp, Integer> userid;
    public static volatile CollectionAttribute<Userapp, Report> reportCollection;
    public static volatile SingularAttribute<Userapp, Credential> credential;
    public static volatile SingularAttribute<Userapp, Integer> steppermile;
    public static volatile SingularAttribute<Userapp, String> surname;
    public static volatile SingularAttribute<Userapp, Date> dob;
    public static volatile SingularAttribute<Userapp, String> email;
    public static volatile SingularAttribute<Userapp, Integer> height;

}