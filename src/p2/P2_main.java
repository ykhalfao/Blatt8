package p2;

public class P2_main {
    public static void main(String[] args) {
    String Ausgabe = "RindfLeischetikETTierung";
    Ausgabe = shortenToLowerCase(Ausgabe,13);
        System.out.println(Ausgabe);
    }
    static public String shortenToLowerCase( String input, int shortenBy){
        input = input.substring(0, input.length() - shortenBy).toLowerCase();
        return input;
    }
}
