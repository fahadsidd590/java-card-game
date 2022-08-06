import java.util.Random;
import java.util.Scanner;

class game {
    // intializing
    // all card set according to priority
    String cardnum[] = { "2", "3", "4", "5", "6", "7", "8", "9", "1", "J", "Q", "K", "A" };
    // all cards used in game 52cards
    String cards[] = { "As", "2s", "3s", "4s", "5s", "6s", "7s", "8s", "9s", "10s", "Js", "Qs", "Ks",
            "Ah", "2h", "3h", "4h", "5h", "6h", "7h", "8h", "9h", "10h", "Jh", "Qh", "Kh",
            "Ac", "2c", "3c", "4c", "5c", "6c", "7c", "8c", "9c", "10c", "Jc", "Qc", "Kc",
            "Ad", "2d", "3d", "4d", "5d", "6d", "7d", "8d", "9d", "10d", "Jd", "Qd", "Kd" };
    // char used to hide cards
    char c = '#';
    // generating the random number arry between 1-52
    int numbers[];
    int b = 1, check = 0;
    int number;
    // scanner class for useer input
    Scanner a = new Scanner(System.in);
    // players scores top 5
    int player[] = { 2, 3, 1, 5, 6 };
    // random numbber class
    Random random = new Random();
    // cards class
    String sel_cards[];

    // method to asign card or shuffle cards
    void asign_value(int num) {
        check = 0;
        numbers = new int[num];
        sel_cards = new String[num];
        int num2[] = new int[num];
        // intializng the numbers arrray
        for (int t = 0; t < num; t++) {
            numbers[t] = b;
            b = b + 1;
        }
        // genrating different number between 1-52 and no any num repeat
        while (check < num) {
            // generating forst random number
            if (check == 0) {
                num2[check] = random.nextInt(1 + 51) + 1;

                check = check + 1;
            }
            // comparing other number so that not any number is same
            else {
                num2[check] = random.nextInt(1 + 51) + 1;
                int i = 0;
                while (i < check) {

                    if (num2[check] == num2[i]) {
                        num2[check] = random.nextInt(1 + 51) + 1;

                        i = 0;
                    } else {
                        i = i + 1;
                    }
                }

                check = check + 1;
            }
        }
        sel_cards = new String[num];

        // selcting the cards from cards array according to random number index
        for (int i = 0; i < num; i++) {
            // number = random.nextInt(1+50)+ 1 ;
            // System.out.println(" "+number);
            sel_cards[i] = cards[num2[i] - 1];
            System.out.print("   " + sel_cards[i]);
        }
    }

    void playgame() {
        int n = 0;
        do {
            // selecting wheather to play or leave game
            System.out.println("Please select the option");
            System.out.println("1.) Play ");
            System.out.println("2.) exit");
            int sel = a.nextInt();
            int w = 0;
            int v = 0, z = 0;
            int sele = 0, sele2 = 0, sele3;
            int score = 0;
            switch (sel) {
                case 1:
                    // asking user to enter number cards
                    System.out.println("Select the number of cards ");
                    int num1 = a.nextInt();
                    this.asign_value(num1);
                    int num2 = num1 - 1;
                    while (w != 1) {
                        
                        if (v == num2) {
                            System.out.println("All cards successfully guessed " + score);
                            w = 1;
                            System.out.println("\n following are the cards you have");
                            System.out.println();
                            int i = 0;
                            for (; i < num1; i++) {

                                System.out.print(" " + sel_cards[i] + " ");

                            }
                            break;
                        }
                       
                        System.out.println("\n following are the cards you have");
                        System.out.println();
                        int i = 0;
                        for (; i < num1; i++) {
                            if (i <= v) {
                                System.out.print(" " + sel_cards[i] + " ");
                            } else {
                                System.out.print(" " + c);
                            }
                        }
                       
                        System.out.println("");
                        System.out.println(" your score is " + score);
                        System.out.println("Select higher or lower (select only number 1 or 2 or 3)");
                        System.out.println("1.)Higher");
                        System.out.println("2.)lower");
                        System.out.println("3.)withdraw");
                        sele3 = a.nextInt();
                        if (sele3 == 3) {
                            System.out.println("you with draw the game");
                            break;
                        }
                        String t = sel_cards[v].substring(0, 1);

                        String q = sel_cards[v + 1].substring(0, 1);

                        for (int e = 0; e < 13; e++) {

                            if (cardnum[e].equals(t)) {
                                sele = e;
                            }
                            if (cardnum[e].equals(q)) {
                                sele2 = e;
                            }
                        }
                        if (sele == sele2) {
                            System.out.println("Game is draw");
                            break;
                        }
                        if (sele > sele2) {
                            z = 2;
                        }
                        if (sele < sele2) {
                            z = 1;
                        }
                        if (sele3 == z) {
                            score = score + 1;
                            System.out.println("your score is " + score);
                            
                        } else {
                            System.out.println("You lose the game try again your score is " + score);
                            w = 1;
                        }
                        v=v+1;
                        
                    }
                    System.out.println("The players scores are");
                    for (int i = 0; i < player.length; i++) {
                        if (player[i] < score) {
                            player[i] = score;
                            break;
                        }
                    }
                    for (int i = 0; i < player.length; i++) {
                        System.out.println("The player no: " + (i + 1) + " scores is " + player[i]);
                    }
                    System.out.println("Your score is " + score);

                    break;
                case 2:
                    n = 1;
                    break;
                default:
                    System.out.println("a wrong input ");
            }
        } while (n != 1);
    }
}

class demo2 {
    public static void main(String args[]) {
        game a = new game();
        // a.asign_value(52);
        a.playgame();
    }
}