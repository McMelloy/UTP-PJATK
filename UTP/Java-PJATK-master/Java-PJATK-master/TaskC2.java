import java.util.*;
public class TaskC2 {
    // private static void DayOfYear(int day, int month) {
    //     String[] Month = {"Января", "Февраля", "Марта", "Апреля", "Мая", "Июня", "Июля", "Августа", "Сентября", "Октября", "Ноября", "Декабря"};
    //     int[] MonthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    //     int DayNum = 0;
    //     for(int i = 0; i < month - 1; i++) {
    //         DayNum = DayNum + MonthDays[i];
    //     }
    //     DayNum = DayNum + day;
    //     System.out.println(day + " " + Month[month - 1] + " 2018 это " + DayNum + " день в году.");
    // }
    private static void DayOfYear(int day, int month) {
        String[] Month = {"Января", "Февраля", "Марта", "Апреля", "Мая", "Июня", "Июля", "Августа", "Сентября", "Октября", "Ноября", "Декабря"};
        int[] MonthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int DayNum = 0;
            for(int i = 1; i < month; i++) {
                DayNum = DayNum + MonthDays[i - 1];
            }
        DayNum = DayNum + day;
        System.out.println(day + " " + Month[month - 1] + " 2018 это " + DayNum + " день в году.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер месяца: ");
        int month = sc.nextInt();
        System.out.println("Введите число: ");
        int day = sc.nextInt();
        if ((day >= 1 && day <=31) && (month >=1 && month <=12)) {
            DayOfYear(day, month);
        } else {
            System.out.println("Такого дня/месяца не существует! Зато 31 февраля у нас существует, дерзайте.");
        }
    }
}