import java.util.Random;

public enum Priority {
    HIGH,
    MEDIUM,
    LOW;

    public static Priority genValue() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}



