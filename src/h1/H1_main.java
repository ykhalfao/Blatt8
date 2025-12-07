package h1;
public class H1_main {
    public static void main(String[] args) {
        Bruch a = new Bruch(100,10);
        Bruch b = new Bruch(10, 1);
        boolean Ausgabe = a.hasSameValueAs(b);
        System.out.println(Ausgabe);

    }
}
