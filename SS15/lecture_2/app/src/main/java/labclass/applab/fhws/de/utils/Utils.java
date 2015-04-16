package labclass.applab.fhws.de.utils;

import java.util.ArrayList;
import java.util.List;

import labclass.applab.fhws.de.model.PersonData;

/**
 * Created by Orrimp on 15/04/15.
 */
public class Utils {

    private final static List<PersonData> personData = new ArrayList<>();

    public static List<PersonData>  createData() {
        if(personData.size() > 0){
            return personData;
        }

        final PersonData person1 = new PersonData("John", "Doe", 1);
        final PersonData person2 = new PersonData("Lisa", "Simpsons", 2);
        final PersonData person3 = new PersonData("Max", "Power", 3);
        final PersonData person4 = new PersonData("Homer", "Simpsons", 4);
        final PersonData person5 = new PersonData("Edna", "Krabappel", 5);
        final PersonData person6 = new PersonData("Herschel", "Krustofski", 6);
        final PersonData person7 = new PersonData("John Junior", "Frink", 7);
        final PersonData person8 = new PersonData("Horatio", "McCallister", 8);
        final PersonData person9 = new PersonData("Doris", "Peterson", 9);
        final PersonData person10 = new PersonData("Charles Montgomery", "Burns", 10);

        personData.add(person1);
        personData.add(person2);
        personData.add(person3);
        personData.add(person4);
        personData.add(person5);
        personData.add(person6);
        personData.add(person7);
        personData.add(person8);
        personData.add(person9);
        personData.add(person10);

        return personData;
    }

}
