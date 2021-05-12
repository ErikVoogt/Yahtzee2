import java.util.Scanner;
import java.util.ArrayList;

public class Yahtzee {

    public static void main(String[] args) {
        YahtzeeSpel spelen = new YahtzeeSpel();
        spelen.spelen();


    }
}

class YahtzeeSpel {

    int aantalDobbelstenen = 5;
    ArrayList<Dobbelsteen> dobbelstenen = new ArrayList();
    int[] blokkeren = {0,0,0,0,0};

    public YahtzeeSpel() {
        dobbelstenen.add(new Dobbelsteen());
        dobbelstenen.add(new Dobbelsteen());
        dobbelstenen.add(new Dobbelsteen());
        dobbelstenen.add(new Dobbelsteen());
        dobbelstenen.add(new Dobbelsteen());

    }


    void spelen() {
        boolean doorspelen = true;
        Scanner invoer = new Scanner(System.in);
        while (doorspelen) {
            System.out.println("Druk op s om te spelen of op q om te stoppen");
            String keuze = invoer.nextLine();
            if (keuze.equals("s")) {
                //System.out.println("Je hebt op enter gedrukt");
                for(int z = 0; z < 5; z++) {
                    if (blokkeren[z] == 0) {
                        //System.out.println(dobbelstenen.get(z).laatsteWorp);
                        dobbelstenen.get(z).werpen();
                        //System.out.println(dobbelstenen.get(z).laatsteWorp);
                        //i.werpen();
                    }
                }
                printHand();
                vastHouden();
                //doorGaan();


            } else if (keuze.equals("q")) {
                doorspelen = false;
                System.out.println("Het spel is klaar");
            } else {
                System.out.println("Kies opnieuw");
            }
        }
    }

    void vastHouden() {
        System.out.println("\nWelke dobbelstenen wil je vasthouden?");
        Scanner sc = new Scanner(System.in);
        String keuze = sc.nextLine();
        for(int x = 0; x<keuze.length(); x++) {
            char c = keuze.charAt(x);
            String s = Character.toString(c);
            int y = Integer.parseInt(s)-1;
            for(int a = 0; a<blokkeren.length; a++) {
                if(y == a) {
                    blokkeren[a] = 1;
                    //System.out.println(blokkeren[a]);
                }
            }
        }
    }
    //void doorGaan() {
        //for(int z = 0; z < 5; z++){
            //if (blokkeren[z] == 0){
                //System.out.println(dobbelstenen.get(z).laatsteWorp);
               // dobbelstenen.get(z).werpen();
                //System.out.println(dobbelstenen.get(z).laatsteWorp);








    void printHand(){
        for (Dobbelsteen i : dobbelstenen) {
            System.out.print(i.laatsteWorp+" ");
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

class Worp{

    int[] X = {0,0,0,0,0};
    Worp worp = new Worp();


}

class Speler{

    ArrayList<Worp> worpgeschiedenis = new ArrayList();

    public Speler (){
        worpgeschiedenis.add(new Worp());
        worpgeschiedenis.add(new Worp());
        worpgeschiedenis.add(new Worp());
        worpgeschiedenis.add(new Worp());
        worpgeschiedenis.add(new Worp());
    }

    }



