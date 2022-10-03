import DFA_Models.*;

public class Program {
    public static void main(String[] args) {
        // Example 1
        DFA_Model model = new StringStartsWithZero("01", 0);
        model.showNodes();

        // Example 2
        model = new StringLengthOfTwo("01", 0);
        model.showNodes();

        // Example 3
        model = new StringInclude0011("110011", 0);
        model.showNodes();

        // Example 4
        model = new StringIncludeThe("mother", 0);
        model.showNodes();
        model.store("teacher", 0);
        model.showNodes();

        // Example 5
        model = new StringEndsWith00Or11("00110", 0);
        model.showNodes();
        model.store("01011", 0);
        model.showNodes();


    }
}
