package unit4.sortApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Crate implements Comparable<Crate> {
    private String receiver;
    private LocalDate shipDate;
    private double mass;

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("M/d/yyyy");

    public Crate(String receiver, String dateStr, double mass) {
        this.receiver = receiver;
        this.shipDate = LocalDate.parse(dateStr, FORMATTER);
        this.mass = mass;
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    @Override
    public int compareTo(Crate other) {
        return this.shipDate.compareTo(other.shipDate);
    }

    @Override
    public String toString() {
        return String.format("%-12s %s %10.2f",
                receiver,
                shipDate.format(FORMATTER),
                mass);
    }
}
