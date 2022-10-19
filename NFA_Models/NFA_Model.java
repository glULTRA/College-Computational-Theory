package NFA_Models;

public abstract class NFA_Model {
    protected boolean result;
    protected String nodes = "";
    protected String inputs = "";
    protected String dashes = "";
    protected StringBuilder subnodes = new StringBuilder();


    public abstract boolean q0(String text, int index);

    NFA_Model(){}
    NFA_Model(String text, int index){
        store(text, index);
    }

    public boolean store(String text, int index){
        nodes = "";
        inputs = "";
        dashes = "";
        subnodes = new StringBuilder();
        result = q0(text, index);
        return result;
    }

    public void showNodes(){
        System.out.println("\n<---------NFA MODELS--------->\n");
        System.out.println(inputs + "\n" + nodes +  (result() ? "Success" : "Failed") + "\n" + dashes + "\n" + dashes + "\n" + subnodes);
    }
    public boolean result(){
        return result;
    }
}
