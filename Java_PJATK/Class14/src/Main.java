public class Main {

    public static boolean checkEmail(String str){
        if(!str.contains("@")){
            System.out.println("Does not contain @!");
            return false;
        }
        if(!str.contains(".com") && !str.contains(".net")){
            System.out.println("Does not contain domain");
            return false;
        }
        System.out.println("it's ok");
        return true;
    }
    static void draw(int n){
        /*for(int i=1;i<=n;i+=2){
            for(int a=0;a<(n-i)/2;a++)
                System.out.print(" ");
            for(int b=0;b<i;b++)
                System.out.print("*");
            for(int a=0;a<(n-i)/2;a++)
                System.out.print(" ");
            System.out.println();
        }*/
        for(int i=0;i<n;i+=2){
            for(int b=0;b<=n-i;b++){
                System.out.print(" ");
            }
            for(int c=0;c<=i;c++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static int fun(int[][]arr){
        int s=0;
        for(int i=1;i<arr.length;++i)
            for(int j=0;j<arr[i].length-1;++j){
                s+=arr[i][j+1];
                if(s<10)
                    System.out.print(s+" ");
            }
            return s/4;
    }
    public static int chng(int n){
        boolean leastIsOne;
        if(n%2==0)
            leastIsOne=false;
        else
            leastIsOne=true;
        int m=n>>2;
        m=m<<2;
        if(leastIsOne){
            m+=3;
        }
        return m;
    }


    public static void main(String[] args) {
	// write your code here
        int n=0b10110;
        System.out.println(chng(n));
        
        /*String b = "General Kenobi!";
        b = b.replace('a','A');
        System.out.println(b);
        b = b.toUpperCase();
        System.out.println(b);
        b = b.replace(" ","");
        System.out.println(b);
        System.out.println(b.contains("K"));
        String email = "fdkil@gmail.com";
        System.out.println(checkEmail(email));
        Student s1 = new Student("Nomad", 223);
        Student s2 = new Student("Man", 123);
        Student[] arr = Student.generateStudentGroup(s1,s2);
        System.out.println(arr[0].index);*/

    }
}

class Student{
    String name;
    int index;
    Student(String n, int i){
        name=n;
        index=i;
    }
    public void print(){
        System.out.println("Student "+name+", number "+index);
    }
    public static Student[] generateStudentGroup(Student stud1, Student stud2){
        Student[] arr = new Student[2];
        arr[0] = new Student(stud1.name, stud1.index);
        arr[1]= new Student(stud2.name, stud2.index);

        return arr;
    }
}
