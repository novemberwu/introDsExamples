package unit4;

import java.util.Date;

public record Review(int rating, String comments, Date postedAt, String productId) {
}
