package labclass.applab.fhws.de.model;

/**
 * Created by Orrimp on 12/03/15.
 */
public class PersonData {

    public String forename;
    public String surname;
    public final int id;

    public PersonData(String forename, String surname, int id){
        this.forename = forename;
        this.surname = surname;
        this.id = id;
    }

    public String toString(){
        return "" + id + " " + forename + " " + surname;
    }
}
