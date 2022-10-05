package DFA_Models;

public class StringEndsWith00Or11 extends DFA_Model {
  /*
  * language = {00, 11, 000, 011, 100, 111, 0011....}
  * at least = 2+1 = 3 nodes
  * 
  *        0              0
  * q0 ------->  q1  -----------> q2 (final node) (recursion 0)
  * |           ↙ ⬆             ↙ 
  * |         ↙ ↗ ⬆           ↙
  * | 1   1 ↙ ↗ 0 ⬆         ↙
  * |     ↙ ↗     ⬆       ↙ 0
  * V   ↙ ↗       ⬆     ↙
  * q3  ↗⬅⬅⬅⬅⬅⬆⬅ ↙ 
  * |             ⬆  
  * |         1   ⬆     
  * |            ↗
  * |          ↗
  * | 1      ↗
  * |      ↗
  * |    ↗
  * |  ↗
  * V   
  * q4 (final node) (recursion 1)
*/    

    public StringEndsWith00Or11(){
        super();
    }

    public StringEndsWith00Or11(String text, int index){
        super(text, index);
    }
     
    @Override 
    public boolean q0(String text, int index){
        super.nodes += "q0 -> ";
        if(text.length() == index)
            return false;
        
        // Spliting the path for 2 way
        // Whether 0 or 1 appears.
        if(text.charAt(index) == '0')
            // Go for the first path of 0.
            return q1(text, index+1);
        else if(text.charAt(index) == '1')
            // Go for the second path of 1.
            return q3(text, index+1);
        
        return q0(text, index+1);
    }

    private boolean q1(String text, int index){
        super.nodes += "q1 -> ";

        if(text.length() == index)
            return false;
        if(text.charAt(index) == '0')
            // Go for final node of 0 path.
            return q2(text, index+1);
        else if(text.charAt(index) == '1')
            // Go for 1's path.
            return q3(text, index+1);
        
        return q0(text, index+1);
    }
    // Q2 is final node.
    private boolean q2(String text, int index){
        super.nodes += "q2 (final node) -> ";

        if(text.length() == index)
            return true;
        if(text.charAt(index) == '0')
            // Recursion...
            return q2(text, index+1);
        else if(text.charAt(index) == '1')
            // Go for 1's path.
            return q3(text, index+1);
        
        return q0(text, index+1);
    }
    private boolean q3(String text, int index){
        super.nodes += "q3 -> ";

        if(text.length() == index)
            return false;
        
        if(text.charAt(index) == '1')
            // Go for final node of 1.
            return q4(text, index+1);
        else if(text.charAt(index) == '0')
            // Go for 0's path.
            return q1(text, index+1);
        
        return q0(text, index+1);
    }
    // Q4 is final node as well.
    private boolean q4(String text, int index){
        super.nodes += "q4 (final node) -> ";

        if(text.length() == index)
            return true;
        
        if(text.charAt(index) == '1')
            // Recursion...
            return q4(text, index+1);
        else if(text.charAt(index) == '0')
            // Go for 0's path.
            return q1(text, index+1);
        
        return q0(text, index+1);
    }
}
