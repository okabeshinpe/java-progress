import java.util.Scanner;
public class BattleSim {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        /*
        BATTLE SIM
        STATES NEED TO BE UPDATED

        THIS WOULD BE BETTER SOON, JUST TESTING THE WATERS FOR NOW

        THE SEQUENCE OF THE METHODS ARE BOTHERING ME, I WOULD FIX IT SOON

         */

        // CHECKS THE MOVES
        int playerMove;

        // GAME STATS
        int enemyAttack = 45;
        int enemyHp = 200;
        int playerStrength = 50;
        int playerHP = 200;
        int healingPot = 25;

        do {
            // SHOWS THE CURRENT GAME STATS
            roundInfo(playerHP, playerStrength, enemyHp, enemyAttack);
            System.out.print("Pick a move: ");
            playerMove = scanner.nextInt();
            Line();
            if (playerMove == 1){
                // PLAYER TAKES IT TURN THEN ENEMY TAKES THEIRS. SIMPLE
                enemyHp = playerTurn(playerStrength, enemyHp);
                Line();
                playerHP = enemyTurn(playerHP, enemyAttack);
            }
            // HEALING MOVE, OFC IT'S UNBALANCED, CLASSIC...
            else if (playerMove == 2) {
                if (playerHP >= 200){
                    // CHECKS IF HP IS GREATER THAN OR EQUAL TO 200, IF IT IS THEN DENY TH HEAL
                    System.out.println("Heal Denied!");
                    System.out.println("Player cannot heal further the max hp!");
                    playerHP = enemyTurn(playerHP, enemyAttack);
                    // THIS COULD BE BETTER. WOULD BE BETTER SOON
                }
                else{
                    /*
                    IF HP IS NOT MAXED OUT THEN PROCEED
                    - PLAYER HEALS
                    - ENEMY ATTACKS
                     */
                    playerHP = playerHeal(healingPot, playerHP);
                    playerHP = enemyTurn(playerHP, enemyAttack);
                }
                // CHECKS CURRENT HP STATS TO SEE IF SOMEONE DIED ALREADY
            } if (playerHP <= 0){
                Line();
                System.out.println("Game Over!");
                System.out.println("Rounders Wins!");
                Line();
                return;
            } else if (enemyHp <= 0){
                Line();
                System.out.println("Game Over!");
                System.out.println("Player Wins!");
                Line();
                return;
            }
            // CATCHING THE INVALID MOVES // THIS IS IN A WEIRD STATE COULD BE BETTER
            if (playerMove > 3 || playerMove <= 0) {
                System.out.println("Invalid Player Move!");
            }
            // PLAYER FLEES / RUN
        } while (playerMove != 3);
        System.out.println("Player flees..");

    /*
    NAMING COULD DEFINITELY DO SOME WORK
    AND THE ORDER OF IT BOTHERS ME. MAKE IT CLEANER SOON
     */
    }
    // PLAYER INFLICTS DAMAGE TO ENEMY
    static int playerAttack(int enemyHP, int playerAttack) {
        return enemyHP - playerAttack;
    }
    // PLAYER HEALS
    static int heal(int heal, int playerHp) {
        return heal + playerHp;
    }
    // ENEMY INFLICTS DAMAGE TO PLAYER
    static int enemyAttack(int playerHp, int enemyAttack) {
        return playerHp - enemyAttack;
    }
    // JUST A LINE, AESTHETIC PURPOSES
    static void Line() {
        System.out.println("================");
    }
    // SHOWS CURRENT GAME STATS
    static void roundInfo(int playerHP, int playerStrength, int enemyHp, int enemyAttack) {
        Line();
        System.out.printf("Your HP: %d\n", playerHP);
        System.out.printf("Your Attack: %d\n", playerStrength);
        Line();
        System.out.printf("Enemy HP: %d\n", enemyHp);
        System.out.printf("Enemy Attack: %d\n", enemyAttack);
        Line();
    }
    // PLAYER ATTACK SEQUENCE / TURN
    static int playerTurn(int playerAttack, int enemyHp) throws InterruptedException {
        System.out.println("Player attacks!");
        pause();
        System.out.println("Rounders staggered!");
        System.out.printf("Rounders lost %d HP", playerAttack);
        pause();
        return playerAttack(enemyHp, playerAttack);
    }
    // JUST A PAUSE. IMMERSION PURPOSES
    static void pause() throws InterruptedException{
        for (int i = 1; i <= 2; i++) {
            System.out.println("...");
            Thread.sleep(1000);
        }
    }
    // ENEMY ATTACK SEQUENCE / TURN
    static int enemyTurn(int playerHp, int enemyAttack )throws InterruptedException{
        System.out.println("Rounders Tackled!");
        pause();
        System.out.println("Player staggered!");
        System.out.printf("Player lost %d HP", enemyAttack);
        pause();
        return enemyAttack(playerHp, enemyAttack);
    }
    // PLAYER HEALING STATE
    static int playerHeal(int healingPot, int playerHp)throws InterruptedException{
        System.out.println("Drinking Healing Potion...");
        pause();
        System.out.printf("HP healed by %d HP\n", healingPot );
        return heal(healingPot, playerHp);
    }
}