import java.util.ArrayList;
import java.util.Arrays;

public class Person {

    private String FirstName;
    private String LastName;
    private String Location;
    public static ArrayList<Person> peoplelist = new ArrayList<Person>();
    public enum Title {PROFESSOR,STUDENT};
    private Title title;

    //person constructor
    Person(String _firstnanem, String _lastname, String _location, Title _title) {
        FirstName = _firstnanem;
        LastName = _lastname;
        Location = _location;
        title = _title;
    }

    //person talks
    public String talk(String words) {
        return(FirstName + " says " + words);
    }

    //person eats
    public String eat(String food) {
        return(FirstName + " eats " + food);
    }

    //person sleeps
    public String sleep() {
        return(FirstName + " is sleeping");
    }

    //location of person
    public String getlocation() {
        return(Location);
    }

    //change location of person
    public void setlocation(String _location) {
        Location = _location;
    }

    //list of people
    public static String getPeopleList() {
        String listString = "";
        for(Person p : peoplelist)
        {
            //System.out.println(p.toString2());
            listString += String.join(", ", p.toString2());
        }
        
        return (listString);
    }

    /* 
    public static void getPerson(String _firstname, String _lastname) {
        String name = _firstname + " " + _lastname;
        for(Person p : peoplelist)
        {
            String personname = p.FirstName + " " + p.LastName;
            if(name.equals(personname))
            {
                System.out.print("Found the person!"); 
            }
        }
    }
    */

    //get specified person
    public static Person getPerson(int num) {
        
        for(Person p : peoplelist)
        {
            if(p == peoplelist.get(num))
            {
                //System.out.print("Found " + p.FirstName + " " + p.LastName);
                return(p); 
            }
        }
        return(null);
    }

    //add person to person list
    public static void setPeopleList(Person _people) {
        peoplelist.add(_people);
    }   

    public String toString2()
    {
        return ("Name : " + FirstName + " " + LastName + " ");
    }

    //get first name of person
    public String getfirst()
    {
        return(FirstName);
    }

    

}
