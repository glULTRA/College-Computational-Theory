package DFA_Models;

public class StringInclude0011 extends DFA_Model{
    /* Logic...
     *
     * Set = {0011, 00011, 10011, 00110, ......}
     * at least = 4 + 1 = 5 super.nodes.
     *      
     *                      0              0             1             1
     * (1 recursion) q0 ---------> q1 ----------> q2 ----------> q3 --------> q4 (final node) (0-1 recursion)
     *               /\            |/\       (0 recusion)        |
     *               |             ||                            |
     *               |______1______||______________0_____________|
     *                              
     */ 

    public StringInclude0011(){
        super();
    }
    public StringInclude0011(String text, int index){
        super(text, index);
    }

    @Override
    public boolean q0(String text, int index){
        super.nodes += "q0 -> ";
        if(text.length() == index){
            return false;
        }

        if(text.charAt(index) == '0')
            return q1(text, index+1);
        else if(text.charAt(index) == '1')
            return q0(text, index+1);
        
        return q0(text, index+1);
    }
    private boolean q1(String text, int index){
        super.nodes += "q1 -> ";

        if(text.length() == index){
            return false;
        }

        if(text.charAt(index) == '0')
            return q2(text, index+1);

        return q0(text, index+1);
    }
    private boolean q2(String text, int index){
        super.nodes += "q2 -> ";

        if(text.length() == index){
            return false;
        }

        if(text.charAt(index) == '0')
            return q2(text, index+1);
        else if(text.charAt(index) == '1')
            return q3(text, index+1);
        
        return q0(text, index+1); // In case there's not any 0 or 1
    }

    private boolean q3(String text, int index){
        super.nodes += "q3 -> ";

        if (text.length() == index) {
            return false;
        }

        if(text.charAt(index) == '0')
            return q1(text, index+1);
        else if(text.charAt(index) == '1')
            return q4(text, index+1);
        
        return q0(text, index+1); // in case it's not 0 or 1.
    }

    // Final node.
    private boolean q4(String text, int index){
        super.nodes += "q4 (final node) -> ";

        if(text.length() == index){
            return true;
        }

        return q4(text, index+1);
    }
}