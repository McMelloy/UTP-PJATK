package main;

public class Carriage implements IAggregable<Carriage, Integer>, IDeeplyCloneable<Carriage> {

    private int numberOfSeats;

    public Carriage() {

    }

    public Carriage(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {

        return numberOfSeats;
    }

    @Override
    public Integer aggregate(Integer intermediateResult) {
        if(intermediateResult == null) {
            return numberOfSeats;
        }
        return intermediateResult + numberOfSeats;
    }

    @Override
    public Carriage deepClone() {
        Carriage clone = new Carriage();
        clone.numberOfSeats = numberOfSeats;
        return clone;
    }
}
