package p1;

public class P1_main {
    public static void main(String[] args) {
        int a = 3;
        a = getNumber(a);
        System.out.println(a);
    }
    static public int getNumber(int a){
        a = (a>42) ? 42 : 0;
        return a;
    }
}
