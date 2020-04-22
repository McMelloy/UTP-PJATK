package DTO;

public class ResourceContent {
    private String Name;
    private String Surname;

    private String ResName;
    private String ResContent;

    public ResourceContent(String name, String surname, String resName, String resContent) {
        Name = name;
        Surname = surname;
        ResName = resName;
        ResContent = resContent;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getResName() {
        return ResName;
    }

    public String getResContent() {
        return ResContent;
    }
}
