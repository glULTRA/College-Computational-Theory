import java.util.Map;

public class Sets 
{
    // Operation of intersection .
    public static String intersection (String set1, String set2){
        // Format must be changed.
        // return reFormat(set1).toString();
        // return reFormat(set2).toString();
        String [] set1_arr = reFormat(set1).split(",");
        String [] set2_arr = reFormat(set2).split(",");

        String set3 = "";

        for (String el: set1_arr) {
            for (String el2: set2_arr) {
                // Operation intersection logic.
                if(el.equals(el2) &&  !isIn(el, set3)){
                    set3 += el2 + ",";
                }
            }
        }

        set3 = readableFormat(set3);

        return set3;
    }

    // Operation of union.
    public static String union(String set1, String set2)
    {
        String [] set1_arr = reFormat(set1).split(",");
        String [] set2_arr = reFormat(set2).split(",");
        String set3 = "";

        for (String el: set1_arr) {
            for (String el2: set2_arr) {
                // Operation union logic.
                if(!isIn(el, set3) )
                    set3 += el + ",";

                if(!isIn(el2, set3))
                    set3 += el2 + ",";
            }
        }

        set3 = readableFormat(set3);

        return set3;
    }

    public static String subtraction(String set1, String set2){
        String [] set1_arr = reFormat(set1).split(",");
        String [] set2_arr = reFormat(set2).split(",");
        String set3 = "";

        for (String el: set1_arr) {
            boolean isElementExist = false;

            for (String el2: set2_arr) {
                // Operation subtraction logic.
                if(el.equals(el2)){
                    // set3 += el + ",";
                    isElementExist = true;
                    break;
                }
            }
            
            if(!isElementExist && !isIn(el, set3)){
                set3 += el + ",";
            }
        }

        set3 = readableFormat(set3);

        return set3;
    }

    public static String readableFormat(String text){
        if(text.isEmpty())
            return "";
            
        if(text.toCharArray()[text.length()-1] == ','){
            text = text.substring(0, text.length() - 1);
        }
        text = reFormat(text);
        String result = "{ " + text + " }";

        return result;

    }

    private static String reFormat(String text){
        // Format incoming:
        // 1- {a,b,c....d}
        // 2- [a,b,c....d]
        // 3- (a,b,c....d)
        // 4- a,b,c...d
        // 5- a b c d
        // Formatting to -> a,b,c,d
        // No spaces no commas no symbols!
        String result = "";
        String gatheringLetters = "";
        for (Character letter : text.toCharArray()) {
            if(letter == ',' || letter == ' '){
                result += gatheringLetters + ",";
                gatheringLetters = "";
                continue;
            }
            if(Character.isAlphabetic(letter)){
                // System.out.println(letter);
                gatheringLetters += letter;
            }
        }

        result += gatheringLetters;

        return result;
    }

    private static boolean isIn(String item, String str){
        String[] str_list = str.split(",");
        for (String el : str_list) {
            if(el.equals(item))
                return true;
        }

        return false;
    }
}
