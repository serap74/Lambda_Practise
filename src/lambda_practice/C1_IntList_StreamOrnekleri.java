package lambda_practice;

import java.util.*;
import java.util.stream.Collectors;

public class C1_IntList_StreamOrnekleri {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5,-8,-2,-12,0,1,12,5,6,9,15,8));
        hepsiniYaz(list);
        System.out.println("\n   ***   ");
        negatifSayilar(list);
        System.out.println("\n   ***   ");
        System.out.println("pozitifSayilarListe( list) = " + pozitifSayilarListe(list));
        System.out.println("\n   ***   ");
        System.out.println("elemanKareListe(list) = " + elemanKareListe(list));
        System.out.println("\n   ***   ");
        System.out.println("tekrarsizelemanKareListe( list) = " + tekrarsizelemanKareListe(list));
        System.out.println("\n   ***   ");
        ListElemanSirala( list);
        System.out.println("\n   ***   ");
        TersListElemanSirala(list);
        System.out.println("\n   ***   ");
        System.out.println("ListKupBirlerBasBes( list) = " + ListKupBirlerBasBes(list));
        System.out.println("\n   ***   ");
        System.out.println("ListKareBirlerBasBesOlmayan(list) = " + ListKareBirlerBasBesOlmayan(list));
        System.out.println("\n   ***   ");
        System.out.println("ListElemanlarToplami(list) = " + ListElemanlarToplami(list));
        System.out.println("\n   ***   ");
        NegatifKareList(list);
        System.out.println("\n   ***   ");
        System.out.println("bestenBuyukSayiVarmi( list) = " + bestenBuyukSayiVarmi(list));
        System.out.println("\n   ***   ");
        System.out.println("bestenBuyukSayiVarmiTumElemanlar(list) = " + bestenBuyukSayiVarmiTumElemanlar(list));
        System.out.println("\n   ***   ");
        System.out.println("yuzeEsitSayiVarmiTumElemanlar(list) = " + yuzeEsitSayiVarmiTumElemanlar(list));
        System.out.println("\n   ***   ");
        System.out.println("sifiraEsitSayiVarmiTumElemanlar(list) = " + sifiraEsitSayiVarmiTumElemanlar(list));
        System.out.println("\n   ***   ");
        System.out.println("İlkBesElemanTopla(list) = " + İlkBesElemanTopla(list));
        System.out.println("\n   ***   ");
        System.out.println("SonBesElemanListele(list) = " + SonBesElemanListele(list));
    }
    // S1:listi aralarinda bosluk birakarak yazdiriniz //
    public static void hepsiniYaz(List<Integer> list){
        list.stream().forEach(t->System.out.print(t+" "));

    }



    //S2: sadece negatif olanlari yazdir
    public static void negatifSayilar(List<Integer> list){
       list.
               stream().
               filter(t->t<0).
               forEach(t->System.out.print(t+" "));

    }




    //S3: pozitif olanlardan yeni bir liste olustur
    public static List<Integer> pozitifSayilarListe(List<Integer> list){
        return  list.
                stream().
                filter(t->t>0).
                collect(Collectors.toList());

    }


    // S4: list in elemanlarin karelerinden yeni bir list olusturalim
    public static  List<Integer> elemanKareListe(List<Integer> list){
                return list.
                stream().
                map(t->t*t).
                collect(Collectors.toList());

    }



    //S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim
    public static List<Integer> tekrarsizelemanKareListe(List<Integer> list){
                return list.
                stream().
                map(t ->t*t).
                distinct().
                collect(Collectors.toList());
    }


    //S6: listin elemanlarini kucukten buyuge siralayalim
    public static void ListElemanSirala(List<Integer> list){
                list.
                stream().
                sorted().forEach(t->System.out.print(t+" "));
    }


    //S7: listin elemanlarini buyukten kucuge siralayalim

    public static void TersListElemanSirala(List<Integer> list){
       list.
                stream().
                sorted(Comparator.reverseOrder()).
               forEach(t->System.out.print(t+" "));

    }

    // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer> ListKupBirlerBasBes(List<Integer> list){
                return list.
                stream().
                filter(t->t>0).
                map(t->t*t*t).
                filter(t->t%10==5).
                collect(Collectors.toList());

    }


    //S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim

    public static List<Integer> ListKareBirlerBasBesOlmayan(List<Integer> list) {
                return list.
                stream().
                filter(t -> t > 0).
                map(t -> t * t ).
                filter(t -> t % 10  != 5).
                collect(Collectors.toList());
    }
    // S10 :list elemanlarini toplamini bulalim
    public static Optional<Integer> ListElemanlarToplami(List<Integer> list) {
                return list.
                stream().
                reduce(Integer::sum);
    }




    // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim
    public static List<Integer> NegatifKareList(List<Integer> list) {

                return list.
                stream().
                filter(t->t<0).
                peek(t-> System.out.println("negatifler :" +t)).
                map(t->t*t).
                peek(t-> System.out.println("kareleri :" + t)).
                collect(Collectors.toList());
        //denetlemek istedigimizin sonrasına ekliyoruz



    }


    // S12 : listeden 5 den buyuk  sayi var mi?
    public static boolean bestenBuyukSayiVarmi(List<Integer> list) {
                return  list.
                stream().
                anyMatch(t->t>5);
    }



    // S13 : listenin tum elemanlari sifirdan kucuk mu?
    public static boolean bestenBuyukSayiVarmiTumElemanlar(List<Integer> list) {
                return list.
                stream().
                allMatch(t->t>5);
    }


    // S14: listenin 100 e esit elemani yok mu ?
    public static boolean yuzeEsitSayiVarmiTumElemanlar(List<Integer> list) {
                return list.
                stream().
                noneMatch(t->t==100);
    }



    // S15: listenin sifira esit elemani yok mu?

    public static boolean sifiraEsitSayiVarmiTumElemanlar(List<Integer> list) {
        return list.
                stream().
                noneMatch(t->t==10);
    }

    // S16:  listenin ilk 5 elemanini topla?
    public static Optional<Integer> İlkBesElemanTopla(List<Integer> list) {
        return list.
                stream().
                limit(5).
                reduce(Integer::sum);
    }


    //S17: listenin son bes elemaninin  listele
    public static List<Integer>  SonBesElemanListele(List<Integer> list) {

                return list.
                stream().
                skip(list.size()-5).
                collect(Collectors.
                        toList());

}
}