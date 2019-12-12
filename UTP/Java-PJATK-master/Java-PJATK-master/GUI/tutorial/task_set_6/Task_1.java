class Task_1{

    static int sum(int a, int b) {
        if (b == 0) return a;
        return sum(++a, --b);
    }

    static void times(int i) {
        if (i == 0) return;
        System.out.println("i: " + i);
        times(--i);
    }

    public static void main(String[] args) {
        
        // Summing two numbers
        System.out.println(sum(6, 9));
        
        // Iteration without a loop
        times(10);
    
    }
}