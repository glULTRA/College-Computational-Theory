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
        if(text.length() != index){
            super.inputs+= "    "+ text.charAt(index) +"   ";
            super.nodes += "q0 ---> ";
        }
        if(text.length() == index){
            super.nodes += "q0 ";
            return false;
        }
        
        if(text.charAt(index) == '0'){   
            return q1(text, index+1) || q0(text, index+1);
        }

        return q0(text, index+1);
        
    }

    public boolean q1(String text, int index){
        String spaces = "";
        int n = nodes.length() - subnodes.length();
        System.out.println(nodes);
        for (int i = 0; i < n; i++) {
            spaces += " ";
        }


        if(text.length() == index){
            super.nodes += "q0 ";
            super.dashes += spaces +  "|    ";
            super.subnodes.insert(super.subnodes.length(), spaces + " ->qf (accepted)");
            return true;
        }else{
            super.dashes += spaces +  "|      ";
            super.subnodes.insert(super.subnodes.length(), spaces + " ->qf x");
        }
        
        return false;
    }
   
}
