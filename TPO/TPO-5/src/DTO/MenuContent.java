package DTO;

import java.util.HashMap;

public class MenuContent {
    private String Name;
    private String Surname;
    private HashMap<Integer, String> Resources;

    public MenuContent(String name, String surname, HashMap<Integer, String> resources) {
        Name = name;
        Surname = surname;
        Resources = resources;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public HashMap<Integer, String> getResources() {
        return Resources;
    }
}
