package Haromszogek;

/**
 *
 * @author Fabian Tamas 1.0
 */
public class DHaromszog {
    
    private double a;
    private double b;
    private double c;
    private final int sorSzama;


public DHaromszog(String sor, int sorSzama) throws Kivetel {
    this.sorSzama = sorSzama;
    String[] s = sor.replace(",",".").split(" ");
    seta (Double.parseDouble(s[0]));
    setb (Double.parseDouble(s[1]));
    setc (Double.parseDouble(s[2]));
    ellenoriz();
}

private void seta(double a) throws Kivetel {
    if (a > 0) {
        this.a = a;
    } else {
        throw new Kivetel(sorSzama + 
                ". sor: Az a oldal nem lehet nulla, vagy negatív!");
    }
}

private void setb(double b) throws Kivetel {
    if (b > 0) {
        this.b = b;
    } else {
        throw new Kivetel(sorSzama + 
                ". sor: A b oldal nem lehet nulla, vagy negatív!");
    }
}

private void setc(double c) throws Kivetel {
    if (c > 0) {
        this.c = c;
    } else {
        throw new Kivetel(sorSzama + 
                ". sor: A c oldal nem lehet nulla, vagy negatív!");
    }
}

private void ellenoriz() throws Kivetel {
    if (a > b || b > c)
        throw new Kivetel(sorSzama + ". sor: Az adatok nincsennek"
                + " növekvő sorrendben!");
    else if (a + b <= c)
        throw new Kivetel (sorSzama + ". sor: A háromszöget"
                + " nem lehet szerkeszteni!");
    else if (Math.abs(a * a + b * b - c * c) > 0.00000005)
        throw new Kivetel (sorSzama + ". sor: A háromszög"
                + " nem derékszögű!");
}

public String getAdatok() {
    return String.format("%d. sor: a=%.2f b=%.2f c=%.2f", sorSzama, a,b,c);
}

public double getTerulet() {
    return a * b / 2;
}

public double getKerulet() {
    return a + b + c;
}

class Kivetel extends Exception {
    public Kivetel (String uzenet) {
        super(uzenet);
        }
    }
}