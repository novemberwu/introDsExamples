package unit4.comparable;

import java.util.Date;

public record Review(int rating, String comments, Date postedAt, String productId) {
}
