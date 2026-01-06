package assignment;

public class Autocomplete {

    private final Term[] terms;

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms){
        if (terms == null) {
            throw new IllegalArgumentException();
        }

        // defensive copy and sort in natural (lexicographic) order
        this.terms = new Term[terms.length];
        System.arraycopy(terms, 0, this.terms, 0, terms.length);
        java.util.Arrays.sort(this.terms);
    }

    // Returns all terms that start with the given prefix,
    // in descending order of weight.
    public Term[] allMatches(String prefix){
        if (prefix == null) {
            throw new IllegalArgumentException();
        }

        if (terms.length == 0) {
            return new Term[0];
        }

        int r = prefix.length();
        Term key = new Term(prefix, 0);

        int first = BinarySearchDeluxe.firstIndexOf(terms, key, Term.byPrefixOrder(r));
        if (first == -1) {
            return new Term[0];
        }
        int last = BinarySearchDeluxe.lastIndexOf(terms, key, Term.byPrefixOrder(r));

        int count = last - first + 1;
        Term[] result = new Term[count];
        for (int i = 0; i < count; i++) {
            result[i] = terms[first + i];
        }

        java.util.Arrays.sort(result, Term.byReverseWeightOrder());
        return result;

    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix){
        if (prefix == null) {
            throw new IllegalArgumentException();
        }

        if (terms.length == 0) {
            return 0;
        }

        int r = prefix.length();
        Term key = new Term(prefix, 0);
        int first = BinarySearchDeluxe.firstIndexOf(terms, key, Term.byPrefixOrder(r));
        if (first == -1) {
            return 0;
        }
        int last = BinarySearchDeluxe.lastIndexOf(terms, key, Term.byPrefixOrder(r));
        return last - first + 1;

    }

    // unit testing
    public static void main(String[] args){
        // simple sanity test
        Term[] sample = {
                new Term("hello", 5),
                new Term("hell", 3),
                new Term("he", 10),
                new Term("world", 2)
        };
        Autocomplete ac = new Autocomplete(sample);
        Term[] matches = ac.allMatches("he");
        for (Term t : matches) {
            System.out.println(t);
        }
    }
}

