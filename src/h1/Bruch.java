package h1;
public class Bruch {
    int zaehler;
    int nenner;

    public Bruch(int z, int n) {
        if (n == 0) throw new IllegalArgumentException("Nenner darf nicht 0 sein");
        this.zaehler = z;
        this.nenner = n;
    }
        private int ggT (int x , int y){
        x = Math.abs(x);
        y = Math.abs(y);
        if (x == 0 && 0 == y) throw new IllegalArgumentException("ggT(0, 0) ist undefiniert.");
        int a;
        int b;
        if (x > y){
            a = x;
            b = y;
        } else {
            a = y;
            b = x;
        }
        int r;
        int a1=0;
        while (b != 0){
          r = a % b;
          a = b;
          b = r;
        }
    return a;
    }
        public void shorten(){
        int kuerzen = ggT(zaehler,nenner);
        this.zaehler /= kuerzen;
        this.nenner /= kuerzen;
        if (nenner < 0){
            zaehler = -zaehler;
            nenner = -nenner;
        }
        }

        public boolean hasSameValueAs (Bruch b) {
        Bruch Eins = new Bruch(this.zaehler,this.nenner);
        Bruch Zwei = new Bruch(b.zaehler,b.nenner);

            Eins.shorten();
            Zwei.shorten();
            boolean b1 = Eins.zaehler == Zwei.zaehler && Eins.nenner == Zwei.nenner;
            return b1;
        }

}
