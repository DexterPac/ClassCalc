public class Student extends Person {

    public Student(String _firstname, String _lastname, String _location, Title _title) {
        super(_firstname,_lastname,_location,_title);
        System.out.println("created!");
    }

    public String Study(Person _person) {
        return(_person.getfirst() + " is studying!");
    }
    
}
