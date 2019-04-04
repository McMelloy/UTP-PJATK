import java.util.*;

class Person implements Comparable<Person>{
    private String name;
    private int yearOfBirth;
    private String id;
    public Person(String name, int year){
        this.name = name;
        yearOfBirth = year;
        this.id = name+year;
    }
    @Override
    public String toString(){
        return this.name+", born in "+this.yearOfBirth+" "+this.id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return yearOfBirth == person.yearOfBirth &&
                Objects.equals(name, person.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfBirth);
    }

    @Override
    public int compareTo(Person o) {
        return this.id.compareTo(o.id);
    }
}

class Hailstone implements Iterable<Integer>{
    int el;
    Hailstone(int ini){
        el = ini;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new HailstoneIterator(el);
    }
}
class HailstoneIterator implements Iterator<Integer>{
    int el;

    HailstoneIterator(int el){
        this.el = el;
    }

    @Override
    public boolean hasNext() {
        return el!=1;
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        if(el%2==0)
            el /= 2;
        else
            el = 3*el + 1;
        return el;
    }
}

class Casino implements Iterable<Integer>{
    @Override
    public Iterator<Integer> iterator() {
        return new CasinoIterator();
    }
}

class CasinoIterator implements Iterator<Integer>{
    int first=0;
    int second=-1;
    int third=-1;
    int change = 1;
    @Override
    public boolean hasNext() {
        return !(first==second && second==third);
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        int tmp = (int)(Math.random()*2);
        switch(change){
            case 1:
                first = tmp;
                change++;
                break;
            case 2:
                second = tmp;
                change++;
                break;
            case 3:
                third = tmp;
                change = 1;
                break;
        }
        return tmp;
    }
}

public class Main {

    public static boolean findInColl(Collection<Person> coll, String name, int year){
        Person tmp = new Person(name,year);
        return coll.contains(tmp);
    }

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        ArrayList<Person> society = new ArrayList<>();
        String input, name;
        int year=0;
        do{
            System.out.println("Input the name. Or end to end a loop");
            input = in.nextLine();
            if(input.equals("end"))
                break;
            else
                name = input;
            System.out.println("Input the year of birth");
            input = in.nextLine();
            try {
                year = Integer.parseInt(input);
            }catch (NumberFormatException n){
                System.out.println("Year is incorrect, try again");
                continue;
            }
            society.add(new Person(name, year));
        }while(true);
        System.out.println("Your society: ");
        for(Person p : society)
            System.out.println(p);
        System.out.println("input name you want to check");
        name = in.nextLine();
        System.out.println("input year you want to check");
        year = in.nextInt();
        System.out.println(findInColl(society, name, year));
        HashSet<Person> soc2 = new HashSet<>(society);
        System.out.println(findInColl(soc2, name, year));
        TreeSet<Person> soc3 = new TreeSet<>(society);
        System.out.println(findInColl(soc3, name, year));

        /////////////////////////////Task 2
        /*int ini = 10, count = 0, maxel = 0;
        Hailstone hailstone = new Hailstone(ini);
        for (int h : hailstone) {
            if (h > maxel)
                maxel = h;
            ++count;
            //System.out.println(h);
        }
        System.out.println(ini + " " + count + " " + maxel);
        */
        /////////////////////////////Task 3
        /*
        for (int turn = 0; turn < 10; ++turn) {
            for (Integer i : new Casino())
                System.out.print(i + " ");
            System.out.println();
        }
        */
    }
}
