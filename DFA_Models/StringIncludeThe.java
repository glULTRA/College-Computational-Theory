package DFA_Models;

public class StringIncludeThe extends DFA_Model{
    /*
     * Set = {the, thea,tthe,tthee, the world,......}
     * At least = 3 + 1 = 4 super.nodes
     * 
     * 
     *                                 t                              h               e
     * ( (a:z)-[t] recursion ) q0 -----------> q1 (t recursion) ------------> q2 ------------> q3 (final node)(recursion a:z)
     *                         /\              |                              |
     *                         |               |                              |
     *                         |__(a:z)-[t,h]__|                              |
     *                         |                                              |
     *                         |______________________(a:z)-e_________________|
     * 
     */      

    public StringIncludeThe(){
        super();
    }
    public StringIncludeThe(String text, int index){
        super(text, index);
    }
    @Override
    public boolean q0(String text, int index){
        super.nodes += "q0 -> ";
        if(text.length() == index){
            return false;
        }

        if(text.charAt(index) == 't'){
            return q1(text, index + 1);
        }
        
        return q0(text, index + 1);
    }

    private boolean q1(String text, int index){
        super.nodes += "q1 -> ";

        if (text.length() == index) {
            return false;
        }

        if(text.charAt(index) == 't'){
            return q1(text, index + 1);
        }else if(text.charAt(index) == 'h'){
            return q2(text, index + 1);
        }
        
        return q0(text, index+1);
    }

    private boolean q2(String text, int index){
        super.nodes += "q2 -> ";

        if(text.length() == index){
            return false;
        }

        if(text.charAt(index) == 'e'){
            return q3(text, index+1);
        }

        return q0(text, index+1);
    }

    // Final node.
    private boolean q3(String text, int index){
        super.nodes += "q3 (final nodes) -> ";

        if(text.length() == index){
            return true;
        }

        return q3(text, index+1);
    }
}