package shape;

enum ShapeType {
    ELLIPSE(0), RECTANGLE(1), TRIANGLE(2);

    private final int value;

    private ShapeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}