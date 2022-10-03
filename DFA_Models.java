public class DFA_Models {
    // Static classes.
    static class StringStartsWithZero{
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
        
        // Start node.
        public static boolean q0(String text, int index){
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
        private static boolean q1(String text, int index){
            nodes += "q1 (final node) -> ";

            if(text.length() == index){
                return true;
            }

            return q1(text, index+1);
        }

        private static boolean q2(String text, int index){
            nodes += "q2 -> ";
            if(text.length() == index){
                return false;
            }

            return q2(text, index+1);
        }


        private static String nodes = "";

        public static void showNodes(){
            System.out.println(nodes);
        }

    }

    static class StringLengthOfTwo{
        /*
         * Set = {00, 01, 10, 11}
         * At least = 2 + 1 = 3 nodes 
         * 
         *      0,1         0,1                       0,1
         * q0 -------> q1 --------> q2 (fianl node) -------> q3 (dead node) (recursion with 0 or 1.)
         *  
         */

        public static boolean q0(String text,int index){
            nodes += "q0 -> ";
           
            if(text.length() == index){
                return false;
            }
            return q1(text, index+1);
        }

        private static boolean q1(String text,int index){
            nodes += "q1 -> ";

            if(text.length() == index)
               return false;
           
            return q2(text, index + 1);
        }

        // Final true
        private static boolean q2(String text, int index){
            nodes += "q2 (final node) -> ";

            if(text.length() == index)
                return true;
           
            return q3(text, index+1);
        }

        private static boolean q3(String text, int index){
            nodes += "q3 -> ";
            
            if(text.length() == index)
                return false;
            
            return q3(text, index+1);
        }
        
         private static String nodes = "";

        public static void showNodes(){
            System.out.println(nodes);
        }
    }

    static class StringIncludeOf0011{
        /* Logic...
         *
         * Set = {0011, 00011, 10011, 00110, ......}
         * at least = 4 + 1 = 5 nodes.
         *      
         *                      0              0             1             1
         * (1 recursion) q0 ---------> q1 ----------> q2 ----------> q3 --------> q4 (final node) (0-1 recursion)
         *               /\            |/\       (0 recusion)        |
         *               |             ||                            |
         *               |______1______||______________0_____________|
         *                              
         */ 

        public static boolean q0(String text, int index){
            nodes += "q0 -> ";
            if(text.length() == index){
                return false;
            }

            if(text.charAt(index) == '0')
                return q1(text, index+1);
            else if(text.charAt(index) == '1')
                return q0(text, index+1);
            
            return q0(text, index+1);
        }
        private static boolean q1(String text, int index){
            nodes += "q1 -> ";

            if(text.length() == index){
                return false;
            }

            if(text.charAt(index) == '0')
                return q2(text, index+1);

            return q0(text, index+1);
        }
        private static boolean q2(String text, int index){
            nodes += "q2 -> ";

            if(text.length() == index){
                return false;
            }

            if(text.charAt(index) == '0')
                return q2(text, index+1);
            else if(text.charAt(index) == '1')
                return q3(text, index+1);
            
            return q0(text, index+1); // In case there's not any 0 or 1
        }

        private static boolean q3(String text, int index){
            nodes += "q3 -> ";

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
        private static boolean q4(String text, int index){
            nodes += "q4 (final node) -> ";

            if(text.length() == index){
                return true;
            }

            return q4(text, index+1);
        }
        
        private static String nodes = "";
        public static void showNodes(){
            System.out.println(nodes);
            // return null;
        }
    }

    static class StringIncludeThe{
        /*
         * Set = {the, thea,tthe,tthee, the world,......}
         * At least = 3 + 1 = 4 nodes
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

        public static boolean q0(String text, int index){
            nodes += "q0 -> ";
            if(text.length() == index){
                return false;
            }

            if(text.charAt(index) == 't'){
                return q1(text, index + 1);
            }
            
            return q0(text, index + 1);
        }

        private static boolean q1(String text, int index){
            nodes += "q1 -> ";

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

        private static boolean q2(String text, int index){
            nodes += "q2 -> ";

            if(text.length() == index){
                return false;
            }

            if(text.charAt(index) == 'e'){
                return q3(text, index+1);
            }

            return q0(text, index+1);
        }

        // Final node.
        private static boolean q3(String text, int index){
            nodes += "q3 (final nodes) -> ";

            if(text.length() == index){
                return true;
            }

            return q3(text, index+1);
        }

        private static String nodes = "";
        public static void showNodes(){
            System.out.println(nodes);
        }

    }
}
