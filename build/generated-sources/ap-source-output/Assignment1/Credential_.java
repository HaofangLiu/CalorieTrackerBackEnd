package Assignment1;

import Assignment1.Userapp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-04T23:53:07")
@StaticMetamodel(Credential.class)
public class Credential_ { 

    public static volatile SingularAttribute<Credential, Date> signupdate;
    public static volatile SingularAttribute<Credential, String> passwordhashing;
    public static volatile SingularAttribute<Credential, Userapp> userapp;
    public static volatile SingularAttribute<Credential, Integer> userid;
    public static volatile SingularAttribute<Credential, String> username;

}