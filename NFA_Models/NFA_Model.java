package NFA_Models;

public abstract class NFA_Model {
    protected boolean result;
    protected String nodes = "";

    public abstract boolean q0(String text, int index);

    NFA_Model(){}
    NFA_Model(String text, int index){
        store(text, index);
    }

    public boolean store(String text, int index){
        nodes = "";
        result = q0(text, index);
        return result;
    }

    public void showNodes(){
        System.out.println(nodes +  (result() ? "Success" : "Failed"));
    }
    public boolean result(){
        return result;
    }
}
