public class Book {
    private String title;
    private int numberOfPages;
    private String author;

    public Book(){
        title =" -NONE-";
        numberOfPages = -1;
        author = "-none-";
    }
    public Book(String t, int n, String a){
        title = t;
        numberOfPages = n;
        author = a;
    }

    @Override 
    public String toString(){
        return title + " " + numberOfPages + " " + author;
    }
}