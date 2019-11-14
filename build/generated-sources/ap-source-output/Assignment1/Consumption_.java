package Assignment1;

import Assignment1.Food;
import Assignment1.Userapp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-04T23:53:07")
@StaticMetamodel(Consumption.class)
public class Consumption_ { 

    public static volatile SingularAttribute<Consumption, Date> date;
    public static volatile SingularAttribute<Consumption, Integer> quantity;
    public static volatile SingularAttribute<Consumption, Integer> consumptionid;
    public static volatile SingularAttribute<Consumption, Food> foodid;
    public static volatile SingularAttribute<Consumption, Userapp> userid;

}