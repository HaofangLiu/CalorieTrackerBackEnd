package Assignment1;

import Assignment1.Consumption;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-04T23:53:07")
@StaticMetamodel(Food.class)
public class Food_ { 

    public static volatile SingularAttribute<Food, String> foodname;
    public static volatile CollectionAttribute<Food, Consumption> consumptionCollection;
    public static volatile SingularAttribute<Food, Integer> calorieamount;
    public static volatile SingularAttribute<Food, BigDecimal> servingamount;
    public static volatile SingularAttribute<Food, Integer> foodid;
    public static volatile SingularAttribute<Food, Short> fat;
    public static volatile SingularAttribute<Food, String> category;
    public static volatile SingularAttribute<Food, String> servingunit;

}