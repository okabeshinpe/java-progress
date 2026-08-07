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

        // ENEMY STATS
        int enemyAttack = 18;
        int enemyHp = 120;

        // PLAYER STATS (about to scrap this)
        int playerAttack = 0;
        int playerMana;
        int playerHP = 0;
        int playerDefense;

        int healingPot = 25;

        int playerClass;

        // ASTROLOGER STATS
        int astrologerHp = 90;
        int astrologerMana = 150;
        int astrologerAttack = 32;
        int astrologerDefense = 5;

        //  WARRIOR STATS
        int warriorHp = 110;
        int warriorMana = 120;
        int warriorAttack = 20;
        int warriorDefense = 11;

        // CONFESSOR STATS;
        int confessorHp = 190;
        int confessorMana = 110;
        int confessorAttack = 55;
        int confessorDefense = 14;


        do {
            playerClass();
            System.out.print("Pick a class: ");
            playerClass = scanner.nextInt();

            switch (playerClass) {
                case 1 -> {
                    astrologerStats(astrologerHp, astrologerMana, astrologerAttack, astrologerDefense);
                    playerHP = astrologerHp;
                    playerMana = astrologerMana;
                    playerAttack = astrologerAttack;
                    playerDefense = astrologerDefense;
                }
                case 2 -> {
                    warriorStats(warriorHp, warriorMana, warriorAttack, warriorDefense);
                    playerHP = warriorHp;
                    playerMana = warriorMana;
                    playerAttack = warriorAttack;
                    playerDefense = warriorDefense;
                }
                case 3 -> {
                    confessorStats(confessorHp, confessorMana, confessorAttack, confessorDefense);
                    playerHP = confessorHp;
                    playerMana = confessorMana;
                    playerAttack = confessorAttack;
                    playerDefense = confessorDefense;
                }
                default -> {
                    System.out.println("INVALID CLASS");

                }
            }
        }while (playerClass < 1 || playerClass > 3);

        do {
            // SHOWS THE CURRENT GAME STATS
            playerMoves(playerHP,playerAttack,enemyHp,enemyAttack);
            System.out.print("Pick a move: ");
            playerMove = scanner.nextInt();
            line();
            if (playerMove == 1){
                enemyHp = playerTurn(playerAttack, enemyHp);
                line();
                playerHP = enemyTurn(playerHP, enemyAttack);
            }
            else if (playerMove == 2) {
                if (playerHP >= 200){
                    System.out.println("Heal Denied!");
                    System.out.println("Player cannot heal further the max hp!");
                    playerHP = enemyTurn(playerHP, enemyAttack);
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
                line();
                System.out.println("Game Over!");
                System.out.println("Rounders Wins!");
                line();
                return;
            } else if (enemyHp <= 0){
                line();
                System.out.println("Game Over!");
                System.out.println("Player Wins!");
                line();
                return;
            }
            if (playerMove > 3 || playerMove <= 0) {
                System.out.println("Invalid Player Move!");
            }
            // PLAYER FLEES / RUN
        } while (playerMove != 3);
        System.out.println("Player flees..");

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
    static void line() {
        System.out.println("================");
    }
    // SHOWS CURRENT GAME STATS
    static void roundInfo(int playerHP, int playerStrength, int enemyHp, int enemyAttack) {
        line();
        System.out.printf("Your HP: %d\n", playerHP);
        System.out.printf("Your Attack: %d\n", playerStrength);
        line();
        System.out.printf("Enemy HP: %d\n", enemyHp);
        System.out.printf("Enemy Attack: %d\n", enemyAttack);
        line();
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
    static void playerMoves(int hp, int attack, int enemyHp, int enemyAttack){
        roundInfo(hp,attack,enemyHp,enemyAttack);
        System.out.println("1. Attack");
        System.out.println("2. Heal");
        System.out.println("3. Run");
        line();
    }
    static void playerClass(){
        line();
        System.out.println("   BATTLE SIM");
        line();
        System.out.println("1. Astrologer");
        System.out.println("2. Warrior");
        System.out.println("3. Confessor");
        line();
    }
    static void astrologerStats(int hp, int mana, int attack, int defense){
        line();
        System.out.printf("HP: %d\n", hp);
        System.out.printf("MP: %d\n", mana);
        System.out.printf("ATK: %d\n", attack);
        System.out.printf("DEF: %d\n", defense);
        line();
    }
    static void warriorStats(int hp, int mana, int attack, int defense){
        line();
        System.out.printf("HP: %d\n", hp);
        System.out.printf("MP: %d\n", mana);
        System.out.printf("ATK: %d\n", attack);
        System.out.printf("DEF: %d\n", defense);
        line();
    }
    static void confessorStats(int hp, int mana, int attack, int defense){
        line();
        System.out.printf("HP: %d\n", hp);
        System.out.printf("MP: %d\n", mana);
        System.out.printf("ATK: %d\n", attack);
        System.out.printf("DEF: %d\n", defense);
        line();
    }
}