import java.util.Scanner;
public class BattleSim {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        /*
        BATTLE SIM
        STATES NEED TO BE UPDATED
         */

        int playerMove;

        int enemyAttack = 45;
        int enemyHp = 200;

        int playerAttack = 50;
        int playerHP = 200;
        int healingPot = 25;


        do {
            Line();
            System.out.printf("Your HP: %d\n", playerHP);
            System.out.printf("Your attack: %d\n", playerAttack);
            System.out.printf("Enemy HP: %d\n",enemyHp);
            Line();
            System.out.println("1. Attack");
            System.out.println("2. Heal");
            System.out.println("3. Flee");
            Line();

            System.out.print("Pick a move: ");
            playerMove = scanner.nextInt();
            Line();

            if (playerMove == 1){
                // PLAYER TAKES THE FIRST TURN
                System.out.println("You tackled!");
                // ROUNDERS TAKES A HIT
                enemyHp = playerAttack(enemyHp,playerAttack);
                System.out.println("Rounders took a hit!");
                Thread.sleep(1500);
                Line();
                System.out.println("Rounders was staggered!");
                // JUST A LIL PAUSE FOR THE ROUNDER TO GET BACK UP
                for (int i = 1; i <= 3; i++){
                    System.out.println("...");
                    Thread.sleep(1500);
                }
                Line();
                // ROUNDERS TAKES ITS TURN
                System.out.println("Rounders tackled!");
                Thread.sleep(2000);
                // PLAYERS LOSE SOME HP
                System.out.println("You got staggered..");
                System.out.printf("You lost %d HP\n", enemyAttack);
                playerHP = enemyAttack(playerHP, enemyAttack);

                // BASICALLY A GAME ENDING MESSAGE
                if (enemyHp <= 0){
                    Line();
                    System.out.println("Game Over!");
                    System.out.println("Player Won!");
                    Line();
                    return;
                }
            }
            // HEALING MOVE, OFC IT'S UNBALANCED, CLASSIC...
            else if (playerMove == 2){
                // PLAYER HEALS
                System.out.println("Drinking Healing Potion...");
                // TAKES TIME TO HEAL
                for (int i = 1; i <= 3; i++){
                    System.out.println("...");
                    Thread.sleep(1500);
                }
                // PLAYER GETS HEALED
                playerHP = playerHeal(healingPot, playerHP);
                System.out.printf("HP healed by %dHP\n", healingPot);
                // ROUNDERS TAKES THE TURN
                System.out.println("Rounders turn..");
                System.out.println("...");
                Thread.sleep(1500);
                // ROUNDER ATTACKS
                System.out.println("Rounders Kicks!");
                // PLAYERS LOST HP AND GETS STAGGERED
                System.out.println("You got staggered!");
                System.out.println("...");
                Thread.sleep(1500);
                playerHP = enemyAttack(playerHP, enemyAttack);
                System.out.printf("You lost %d HP\n", enemyAttack);
            }
            // CATCHING THE INVALID MOVES
            else if (playerMove > 3 || playerMove <= 0){
                System.out.println("Invalid Player Move!");
            }
        // PLAYER FLEES / RUN
        }while (playerMove != 3);
        System.out.println("Player flees..");



    }
    static int playerAttack(int enemyHP, int playerAttack){
        return enemyHP - playerAttack;
    }
    static int playerHeal(int heal, int playerHP) {
        return heal + playerHP;
    }
    static int enemyAttack(int playerHP, int enemyAttack){
        return playerHP - enemyAttack;
    }
    static void Line(){
        System.out.println("================");
    }
}
