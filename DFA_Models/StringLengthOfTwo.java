package DFA_Models;

public class StringLengthOfTwo extends DFA_Model{
        /*
         * Set = {00, 01, 10, 11}
         * At least = 2 + 1 = 3 super.nodes 
         * 
         *      0,1         0,1                       0,1
         * q0 -------> q1 --------> q2 (fianl node) -------> q3 (dead node) (recursion with 0 or 1.)
         *  
         */

        public StringLengthOfTwo(){
            super();
        }
        public StringLengthOfTwo(String text, int index){
            super(text, index);
        }
        
        @Override
        public boolean q0(String text,int index){
            super.nodes += "q0 -> ";
           
            if(text.length() == index){
                return false;
            }
            return q1(text, index+1);
        }

        private boolean q1(String text,int index){
            super.nodes += "q1 -> ";

            if(text.length() == index)
               return false;
           
            return q2(text, index + 1);
        }

        // Final true
        private boolean q2(String text, int index){
            super.nodes += "q2 (final node) -> ";

            if(text.length() == index)
                return true;
           
            return q3(text, index+1);
        }

        private boolean q3(String text, int index){
            super.nodes += "q3 -> ";
            
            if(text.length() == index)
                return false;
            
            return q3(text, index+1);
        }
        
}