package assignment;
import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {

    private final String s ;
    private final long weight;

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight){
        if(query == null || weight < 0) throw new IllegalArgumentException();
        this.s = query;
        this.weight = weight;

    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
        return  new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {

                if(o1 == null && o2 == null) return 0;
                else if(o1 == null) return 1;
                else if(o2 == null) return -1;
                else{
                    long diff = o1.weight - o2.weight;
                    if(diff > 0) return -1;
                    else if (diff < 0) return 1;
                    else return 0;

                }

            }
        };

    }

    // Compares the two terms in lexicographic order,
    // but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r){

        return new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                if(o1 == null && o2 == null) return 0;
                else if(o1 == null) return -1;
                else if(o2 == null) return 1;
                else{
                 String sub1 = o1.s.substring(0, Math.min(r, o1.s.length()));
                 String sub2 = o2.s.substring(0, Math.min(r, o2.s.length()));
                 return sub1.compareTo(sub2);

                }
            }
        };

    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that){
        if(that == null) return 1;
        else return this.s.compareTo(that.s);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString(){
        return this.weight + "  " + this.s;

    }

    // unit testing (required)
    public static void main(String[] args){
        testReverseWeightOrder();
        testPrefixOrder();
        testNaturalOrder();

    }


    private static void testReverseWeightOrder(){
        Term[] terms = {
                new Term("Hello", 1),
                new Term ("Horse", 2),
                new Term ("Hero", 0)
        };
        Arrays.sort(terms, byReverseWeightOrder());
        printArray(terms);

    }

    private static void testPrefixOrder(){
        Term[] terms = {
                new Term("Hello", 1),
                new Term ("Horse", 2),
                new Term ("Hero", 0)
        };

        Arrays.sort(terms, byPrefixOrder(2));
        printArray(terms);

    }
    private static void testNaturalOrder(){
        Term[] terms = {
                new Term("Hello", 1),
                new Term ("Horse", 2),
                new Term ("Hero", 0)
        };

        Arrays.sort(terms);
        printArray(terms);
    }

    private static void printArray(Term[] terms){
        System.out.println();
        Arrays.stream(terms).forEach(t-> System.out.println(" " + t));

    }

}