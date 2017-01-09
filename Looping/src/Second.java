import java.lang.reflect.Field;

class First
{
      public String publicName;
     private String privateName;
}
public class Second
{
    public static void main(String args[])
    {                           
            Field fld[] = First.class.getDeclaredFields();
            for (int i = 0; i < fld.length; i++)
            {
                System.out.println("Variable Name is : " + fld[i].getName());
            }                       
    }
}