package main;

public class Book implements IAggregable<Book, Integer>, IDeeplyCloneable<Book> {

    private int numberOfPages;

    public Book(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int returnNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public Integer aggregate(Integer intermediateResult) {
        if(intermediateResult == null) {
            return numberOfPages;
        }

        return numberOfPages + intermediateResult;
    }

    @Override
    public Book deepClone() {
        Book clone = new Book(numberOfPages);
        return clone;
    }
}