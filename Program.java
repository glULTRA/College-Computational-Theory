public class Program {
    public static void main(String[] args) {
        // Example 1
        boolean result = DFA_Models.StringStartsWithZero.q0("010", 0);
        DFA_Models.StringStartsWithZero.showNodes();
        System.out.println(result);

        // Example 2
        result = DFA_Models.StringLengthOfTwo.q0("11", 0);
        DFA_Models.StringLengthOfTwo.showNodes();
        System.out.println(result);

        // Example 3
        result = DFA_Models.StringIncludeOf0011.q0("0011", 0);
        DFA_Models.StringIncludeOf0011.showNodes();
        System.out.println(result);

        // Example 4
        result = DFA_Models.StringIncludeThe.q0("mother", 0);
        DFA_Models.StringIncludeThe.showNodes();
        System.out.println(result);
    }
}
