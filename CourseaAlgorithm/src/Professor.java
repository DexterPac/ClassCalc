public class Professor extends Person {

    public Professor(String firstname, String lastname, String location, Person.Title _title) {
        super(firstname,lastname,location,_title);
    }

    public String Teach(Person _person) {
        return(_person.getfirst() + " is teaching!");
    }


}
