package unit1;

public class PassByValueExamples {
    static class Mug {
        private String contents;

        public Mug(String contents) {
            this.contents = contents;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }

        public String getContents() {
            return contents;
        }
    }
    public static void spill(Mug myMug) {
        // This modifies the object pointed to by 'myMug' (which is the same object
        // pointed to by the 'teaMug' in main).
        myMug.setContents("nothing");
    }

    public static void reassignMug(Mug myMug) {
        // This reassigns the local 'myMug' variable to a new object.
        // It does NOT affect the 'teaMug' in the main method.
        myMug = new Mug("new contents");
        System.out.println("Inside reassignMug method: " + myMug.getContents());
    }

    public static void main(String[] args) {
        Mug teaMug = new Mug("tea");
        System.out.println("Before spill method: " + teaMug.getContents()); // Output: tea

        spill(teaMug); // Pass the reference value of teaMug
        System.out.println("After spill method: " + teaMug.getContents()); // Output: nothing

        System.out.println("\nBefore reassignMug method: " + teaMug.getContents()); // Output: nothing
        reassignMug(teaMug); // Pass the reference value of teaMug again
        System.out.println("After reassignMug method: " + teaMug.getContents()); // Output: nothing (original object unchanged)
    }
}
