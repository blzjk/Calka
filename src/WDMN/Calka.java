/* Błażej Kozikowski nr albumu 9705
Program napisany w języku JAVA.
Program obliczający wartość całki oznaczonej ∫20x3−2x2+3x−3dx w 4, 20 i 1000 krokach metodami:
prostokątów, trapezów i Simpsona.
Funkcja podcałkowa, przedział całkowania oraz liczba kroków są zakodowane wewnątrz programu.
Wynik działania programu to wartości całki dla trzech metod.
 */
package WDMN;

public class Calka {


    public static void main(String[] args) {


        double calkaProstokaty4 =  calka_prostokaty(0,2,4);
        double calkaProstokaty20 =  calka_prostokaty(0,2,20);
        double calkaProstokaty1000 =  calka_prostokaty(0,2,1000);
        System.out.println("Wartość całki oznaczonej obliczonej metodą prostokątów w ilości kroków : ");
        System.out.println(String.format ("4 kroki = " + "%.3f", calkaProstokaty4));
        System.out.println(String.format ("20 kroków = " + "%.3f", calkaProstokaty20));
        System.out.println(String.format ("1000 kroków = " + "%.3f", calkaProstokaty1000));
        System.out.println("");


        double calkaTrapezy4 = calka_trapezy(0,2,4);
        double calkaTrapezy20 = calka_trapezy(0,2,20);
        double calkaTrapezy1000 = calka_trapezy(0,2,1000);
        System.out.println("Wartość całki oznaczonej obliczonej metodą trapezów w ilości kroków : ");
        System.out.println(String.format ("4 kroki = " + "%.3f", calkaTrapezy4));
        System.out.println(String.format ("20 kroków = " + "%.3f", calkaTrapezy20));
        System.out.println(String.format ("1000 kroków = " + "%.3f", calkaTrapezy1000));
        System.out.println("");

        double calkaSimpsona4 = calka_Simpsona(0,2,4);
        double calkaSimpsona20 = calka_Simpsona(0,2,20);
        double calkaSimpsona1000 = calka_Simpsona(0,2,1000);
        System.out.println("Wartość całki oznaczonej obliczonej metodą Simpsona w ilości kroków : ");
        System.out.println(String.format ("4 kroki = " + "%.3f", calkaSimpsona4));
        System.out.println(String.format ("20 kroków = " + "%.3f", calkaSimpsona20));
        System.out.println(String.format ("1000 kroków = " + "%.3f", calkaSimpsona1000));
    }

    static double funkcja(double x){
        return ((x*x*x)-(2*x*x)+(3*x)-3);

    }

    static double calka_prostokaty ( double a, double b, int ilosc_krokow ){
        double h = (b - a) / ilosc_krokow;
        double wynik = 0.0;
        for (int i = 0; i < ilosc_krokow; i++){
            wynik += h * funkcja(a +  h * (i+0.5));
        }
        return wynik;
    }

    static double calka_trapezy ( double a, double b, int ilosc_krokow ){
        double h = (b - a) / ilosc_krokow;
        double wynik = 0.5 * (funkcja(a) + funkcja(b));
        for (int i = 1; i < ilosc_krokow; i++){
            double x =a + h * i;
            wynik = wynik + funkcja(x);
        }
        return wynik * h;
    }
    
    static double calka_Simpsona(double a, double b, int ilosc_krokow ){
        double h = (b - a) / ilosc_krokow;
        double[] x = new double[1001];
        double[] fx= new double[1001];
        for (int i = 0; i <= ilosc_krokow; i++) {
            x[i] = a + i * h;
            fx[i] = funkcja(x[i]);
        }

        double wynik = 0;
        for (int i = 0; i <= ilosc_krokow; i++) {
            if (i == 0 || i == ilosc_krokow)
                wynik += fx[i];
            else if (i % 2 != 0)
                wynik += 4 * fx[i];
            else
                wynik += 2 * fx[i];
        }
        wynik = wynik * (h / 3);
        return wynik;
    }
}