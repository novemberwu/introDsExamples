package unit4.comparable;

import unit4.comparable.Review;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReviewRanking {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");


        Comparator<Review> rankByDateDesc =
                (r1, r2) -> (r2.postedAt().compareTo(r1.postedAt()));

        List<Review> l = new ArrayList<>();
        l.add(new Review(4, "good", formatter.parse("2025/01/01"), "product1"));
        l.add(new Review(3, "average", formatter.parse("2025/02/01"), "product1"));
        l.add(new Review(1, "very bad", formatter.parse("2025/01/11"), "product1"));

        l.forEach(System.out::println);

        l.sort(rankByDateDesc);

        System.out.println("\n\nAfter sorting");
        l.forEach(System.out::println);


    }
}
