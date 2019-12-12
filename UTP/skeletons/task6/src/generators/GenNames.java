package generators;

import java.util.HashMap;
import java.util.Random;

public class GenNames {
    static HashMap<String, String[]> nameDB = new HashMap<String, String[]>();
    static HashMap<String, String[]> surnameDB = new HashMap<String, String[]>();


    static {
        nameDB.put("POLISH",new String[]{"Piotr","Patryk","Kacper","Jakub"});
        nameDB.put("BELARUSIAN",new String[]{"Ales'","Zmicer","Yauheni","Yanka"});
        nameDB.put("UKRAINIAN",new String[]{"Oleksandr","Dmytro","Danylo","Maksym"});
        nameDB.put("SLOVAK",new String[]{"Drahoslav","Imrich","Adam","Matej"});
        nameDB.put("LATVIAN",new String[]{"Aleksandrs","Jānis","Gustavs","Ralfs"});
        nameDB.put("BRITISH",new String[]{"Johnathan","Benedict","George","Harry"});
        nameDB.put("INDIAN",new String[]{"Amar","Mahmud","Aarav","Muhammad"});
        nameDB.put("CHINESE",new String[]{"Lu","Cao","Bai","Zhang"});
        nameDB.put("VIETNAMESE",new String[]{"Lan","Nguyễn","Hoang","Phan"});

        surnameDB.put("POLISH",new String[]{"Nowak","Kowalski","Wiśniewski","Wójcik"});
        surnameDB.put("BELARUSIAN",new String[]{"Adamovich","Baranovski","Morozov","Dziuba"});
        surnameDB.put("UKRAINIAN",new String[]{"Shevchenko","Tkachenko","Koval","Kravchenko"});
        surnameDB.put("SLOVAK",new String[]{"Obecny","Kovac","Petrik","Mikus"});
        surnameDB.put("LATVIAN",new String[]{"Jansons","Ozoliņš","Bērziņš","Kalniņš"});
        surnameDB.put("BRITISH",new String[]{"Joestar","Wilkinson","Atkinson","McArthur"});
        surnameDB.put("INDIAN",new String[]{"Khatri","Acharya","Laghari","Ramshesh"});
        surnameDB.put("CHINESE",new String[]{"Bu","Cao","Zhang","Huang"});
        surnameDB.put("VIETNAMESE",new String[]{"Lê","Võ","Huỳnh","Trần"});

        /*surnameDB.put("POLISH",new String[]{"ANowak","AKowalski","ĄWiśniewski","ĄWójcik"});
        surnameDB.put("BELARUSIAN",new String[]{"Adamovich","ABaranovski","ĄMorozov","ĄDziuba"});
        surnameDB.put("UKRAINIAN",new String[]{"AShevchenko","ATkachenko","Koval","ĄKravchenko"});
        surnameDB.put("SLOVAK",new String[]{"AObecny","Kovac","ĄPetrik","ĄMikus"});
        surnameDB.put("LATVIAN",new String[]{"AJansons","Ozoliņš","ĄBērziņš","ĄKalniņš"});
        surnameDB.put("BRITISH",new String[]{"AJoestar","AWilkinson","ĄAtkinson","ĄMcArthur"});
        surnameDB.put("INDIAN",new String[]{"AKhatri","Acharya","ĄLaghari","Ramshesh"});
        surnameDB.put("CHINESE",new String[]{"ABu","ACao","Zhang","ĄHuang"});
        surnameDB.put("VIETNAMESE",new String[]{"ALê","AVõ","Huỳnh","ĄTrần"});*/
    }

    static String giveName(String locale){
        Random r = new Random();
        String[] list = nameDB.get(locale);
        return list[r.nextInt(4)];
    }

    static String giveSurname(String locale){
        Random r = new Random();
        String[] list = surnameDB.get(locale);
        return list[r.nextInt(4)];
    }
}
