package lambda_practice;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {

    public static void main(String[] args) {
        ilkOtuz(30);
        System.out.println("*******************");
        ilkOtuzDahil(30);
        System.out.println("*******************");
        System.out.println("İtenenikiDegerArasiTopla(a,b) = " + İtenenikiDegerArasiTopla(10,20));
        System.out.println("****************");
        System.out.println("ort(30,40) = " + ort(30, 40));
        System.out.println("****************");
        System.out.println("sekizeBolunen(325,468) = " + sekizeBolunen(325, 468));
        System.out.println("****************");
        sekizeBolunenSayilar(325,468);
        System.out.println("****************");
        System.out.println("sekizeBolunenayilarTop(325,468) = " + sekizeBolunenayilarTop(325, 468));
        System.out.println("****************");
        System.out.println("tekSayiCarpim(325,468) = " + tekSayiCarpim(7, 15));
        System.out.println("****************");
        pozitifTekSayi(10);
        System.out.println("****************");
        yedininKatlari(21);
        System.out.println("****************");
        yedininKatlaritoplam(21);

    }

    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //range(int startInclusive, int endExclusive)
    public static void ilkOtuz(int a) {
        IntStream.
        range(1, a).
        forEach(t -> System.out.print(t + " "));
    }


    //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //rangeClosed(int startInclusive, int endInclusive)
    public static void ilkOtuzDahil(int a) {
        IntStream.
        rangeClosed(1, a).
        forEach(Methods::yazInteger);
    }

    //S3 Istenen iki deger(dahil) arasindaki sayilari toplayalim
    public static int İtenenikiDegerArasiTopla(int a, int b) {
        return IntStream.
        rangeClosed(a, b).
        sum();
        // return IntStream.rangeClosed(bas,bitis+1).sum();
    }


    //S4: 30 ile 40 arasindaki sayilarin (dahi) ortalamasini bulalim
    public static OptionalDouble ort(int a, int b) {
        return IntStream.
                rangeClosed(a, b).
                average();

    }

    //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?

    public static long sekizeBolunen(int a, int b) {
        return IntStream.
        rangeClosed(a, b).
        filter(t -> t % 10 == 8).
        count();
    }

    //S6: 325 ile 468 arasinda 8 bolunen sayilari yazdiralim
    public static void sekizeBolunenSayilar(int a, int b) {
        IntStream.
        rangeClosed(a, b).filter(t -> t % 10 == 8).
        forEach(Methods::yazInteger);
    }


    // S7:325 ile 468 arasinda 8 bolunen sayilarin toplamini bulalim
    public static int sekizeBolunenayilarTop(int a, int b) {
        return IntStream.
        rangeClosed(a, b).
        filter(t -> t % 10 == 8).
        sum();
    }

    // S8: 7ile 15 arasindaki tek sayilarin carpimini bulalim
    public static double tekSayiCarpim(int a, int b) {
        return IntStream.
        rangeClosed(a, b).
        filter(t -> t % 2 == 1).
        reduce(1, (x, y) -> x * y);
    }

    //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim
    public static void pozitifTekSayi(int a) {
        IntStream.
        iterate(1, t -> t + 2).
        limit(10).
        filter(Methods::tekMi).
        forEach(Methods::yazInteger);
    }

    //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim
    public static void yedininKatlari(int a) {
        IntStream.
                iterate(21, t -> t + 7).
                filter(Methods::tekMi).
                limit(10).
                forEach(Methods::yazInteger);
    }

        //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim
        public static int yedininKatlaritoplam(int a) {
            return IntStream.iterate(21, t -> t + 7).
                    limit(20).
                    sum();

        }

}
//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belilioruz