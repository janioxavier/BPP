package pratica1.floricultura.dominio;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
 
public class Contracts {
    public static void main(String[] args) {
        System.out.println(new Numbers().add(-10, 5));
    }
}
 
class Numbers {
    @Requires({ "c > 0", "b > 0" })
    @Ensures({ "result > a", "result > b" })
    int add(int a, int b) {
        return a - b;
    }
}