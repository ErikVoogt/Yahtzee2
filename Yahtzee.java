import java.util.Scanner;
import java.util.ArrayList;

public class Yahtzee {

    public static void main(String[] args) {
        YahtzeeSpel spelen = new YahtzeeSpel();
        spelen.spelen();


    }
}

 class YahtzeeSpel {
     ArrayList<Speler> spelers = new ArrayList();
     static ArrayList<Dobbelsteen> dobbelstenen = new ArrayList();
     int[] blokkeren = {0, 0, 0, 0, 0};
     boolean spelen = true;


     public YahtzeeSpel() {
         for (int x = 0; x < 5; x++) {
             Dobbelsteen ds = new Dobbelsteen();
             dobbelstenen.add(ds);
         }
     }


     void spelen() {
         System.out.println("Welkom bij Yahtzee");
         System.out.println("Deze versie is geschikt voor  2 spelers");
         System.out.println("Voer de namen van de spelers in.");
         naamToevoegen();

                 //System.out.println("Je hebt op enter gedrukt");
                 while (spelen) {
                     for (Speler i : spelers) {
                         Scanner invoer = new Scanner(System.in);
                         System.out.println("Druk op s om te spelen of op q om te stoppen");
                         String keuze = invoer.nextLine();
                         if (keuze.equals("s")) {
                             for (int z = 0; z < 5; z++) {
                                 if (blokkeren[z] == 0) {
                                     dobbelstenen.get(z).werpen();
                                 }
                             }
                         System.out.println(i + " gooit.");
                             printHand();
                             vastHouden();
                             System.out.println(i + "'s tweede worp");
                             doorGaan();
                             vastHouden();
                             System.out.println(i +"'s laatste worp");
                             doorGaan();
                             System.out.println("\nJe beurt is voorbij je hebt:");
                             Worp.worpUitslag();
                             i.aantalbeurten--;
                             if (i.aantalbeurten == 0){
                                 spelen = false;
                                 break;
                             }
                         } else if (keuze.equals("q")) {
                             System.out.println("Het spel is klaar");
                         } else {
                             System.out.println("Kies opnieuw");
                         }

                     }


                 }


     }

     void naamToevoegen(){
         Scanner deelnemer = new Scanner(System.in);
         String naam;
         for(int x = 0; x < 2; x++){
             naam = deelnemer.nextLine();
             spelers.add(new Speler(naam));

         }
         System.out.println();

     }

     void printHand(){
         for (Dobbelsteen i : dobbelstenen) {
             System.out.print(i.laatsteWorp + " ");
         }
     }

     void vastHouden() {

         System.out.println("\nWelke dobbelstenen wil je vasthouden?");
         Scanner sc = new Scanner(System.in);
         String keuze = sc.nextLine();
         for (int x = 0; x < keuze.length(); x++) {
             char c = keuze.charAt(x);
             String s = Character.toString(c);
             int y = Integer.parseInt(s) - 1;
             for (int a = 0; a < blokkeren.length; a++) {
                 if (y == a) {
                     blokkeren[a] = 1;
                     //System.out.println(blokkeren[a]);
                 }
             }
         }
     }

     void doorGaan() {
         for (int z = 0; z < 5; z++) {
             if (blokkeren[z] == 0) {
                 dobbelstenen.get(z).laatsteWorp = dobbelstenen.get(z).werpen();
             }
         }


         //void printHand () {
             for (Dobbelsteen i : dobbelstenen) {
                 System.out.print(i.laatsteWorp + " ");
             }

         }



         }



     class Dobbelsteen {

         int laatsteWorp;

         int werpen() {
             laatsteWorp = (int) (Math.random() * 6) + 1;
             return laatsteWorp;

         }
     }

     class Worp {

         int[] worpen = {0, 0, 0, 0, 0};

         static Worp worpUitslag() {
             Worp worp = new Worp();
             for (int n = 0; n < 5; n++) {
                 worp.worpen[n] = YahtzeeSpel.dobbelstenen.get(n).laatsteWorp;

             }
             //Speler speler = new Speler();
             //speler.worpGeschiedenis.add(worp);
             return worp;
         }

     }

     class Speler {

         ArrayList<Worp> worpGeschiedenis = new ArrayList();
         int aantalbeurten = 13;
         String naam;

         public Speler(String naam) {
             this.naam = naam;
         }

         @Override
         public String toString() {
             return naam;

         }
     }




