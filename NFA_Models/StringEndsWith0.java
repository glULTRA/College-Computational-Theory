package NFA_Models;

public class StringEndsWith0 extends NFA_Model {
    /*
     * Set = {0, 00, 10, 000, ....}
     * 
     *                         0
     * (0,1 recursion) q0 --------------> q1(final node)
     * 
     */

    public StringEndsWith0(){
        super();
    }
    public StringEndsWith0(String text, int index){
        super(text, index);
    }

    @Override
    public boolean q0(String text, int index){
        super.nodes += "q0 -> ";
        if(text.length() == index)
            return false;
        
        if(text.charAt(index) == '0')
            return q1(text, index+1);
        
        return q0(text, index+1);
        
    }

    public boolean q1(String text, int index){
        super.nodes += "q1 (final node) -> ";
        if(text.length() == index)
            return true;
        
        return q0(text, index+1);
    }
}
