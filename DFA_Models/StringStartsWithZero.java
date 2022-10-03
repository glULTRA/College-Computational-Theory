package DFA_Models;

public class StringStartsWithZero extends DFA_Model{
    /* DFA Model:
     *   
     * Set = {0, 01, 001, 010, 011, ...}
     * At least = 1+1 = 3 nodes.    
     * 
     *         0
     * q0  -------->  q1 (final node) (recursion wether 0 or 1 to q1).
     * |
     * |
     * | 1
     * |
     * V
     * q2 (dead node)
     * (recursion wether 0 or 1 to q2). 
     *
     *
    */

    public StringStartsWithZero(){
        super();
    }
    public StringStartsWithZero(String text, int index){
        super(text, index);
    }
    
    // Start node.
    @Override
    public boolean q0(String text, int index){
        nodes += "q0 -> ";

        if(text.length() == index){
            return false;
        }

        if(text.charAt(index) == '0')
            return q1(text, index + 1); // Final Node.
        else if(text.charAt(index) == '1')
            return q2(text, index + 1); // Dead node.

        return  false;
    }

    // Final node
    private boolean q1(String text, int index){
        nodes += "q1 (final node) -> ";

        if(text.length() == index){
            return true;
        }

        return q1(text, index+1);
    }

    private boolean q2(String text, int index){
        nodes += "q2 -> ";
        if(text.length() == index){
            return false;
        }

        return q2(text, index+1);
    }
}