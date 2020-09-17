import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
       List<String > data=permutation("ABCD");
       for(String s: data){
           System.out.println(s);
       }
       System.out.println(data.size());
    }

    static public List<String> permutation(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() == 1) {
            result.add(s);
            return result;
        }
        List<String> tempList = permutation(s.substring(1));
        char c = s.charAt(0);
        for (String a : tempList) {
            insert(a, c, result);
        }
        return result;
    }

    static private void insert(String a, char c, List<String> result) {
        for (int i = 0; i <= a.length(); i++) {
            String k = prepareString(a, c, i);
            result.add(k);
        }
    }

    static private String prepareString(String a, char c, int i) {
        StringBuilder strb = new StringBuilder();
        char[] ch = a.toCharArray();
        boolean flag = true;
        for (int x = 0; x < ch.length; x++) {
            if (i == x) {
                strb.append(c);
                strb.append(ch[x]);
                flag = false;
                continue;
            }
            strb.append(ch[x]);

        }
        if (flag)
            strb.append(c);
        return strb.toString();
    }
}
