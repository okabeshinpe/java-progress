import java.util.Scanner;
public class RpgCharacterCreator {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("======= SKILL TREE =======");

        System.out.println("You currently have 50 skill points");
        System.out.println("Use them wisely.\n");
        /*
        ask for user input, kind of like a stat points

        use the methods to convert or multiply them
         */
        System.out.print("Enter Strength: ");
        int strength = scanner.nextInt();
        int attack = calculateAttack(strength);

        System.out.print("Enter Vitality: ");
        int vitality = scanner.nextInt();
        int health = calculateHealth(vitality);

        System.out.print("Enter Defense: ");
        int defense = scanner.nextInt();
        int mainDefense = calculateDefense(defense);

        System.out.print("Enter Dexterity: ");
        int dexterity = scanner.nextInt();
        int critChance = calculateCritChance(dexterity);

        System.out.print("Enter luck: ");
        int luck = scanner.nextInt();
        int mainLuck = calculateLuck(luck);

        System.out.print("Enter Intelligence: ");
        int intelligence = scanner.nextInt();
        int mainIntelligence = calculateIntelligence(intelligence);

        System.out.print("Enter Charisma: ");
        int charisma = scanner.nextInt();
        int mainCharisma = calculateCharisma(charisma);

        int totalSkillPoints = strength + vitality + defense + dexterity + luck + intelligence + charisma;

        if (totalSkillPoints > 50){
            System.out.println("You exceeded the current skill points!");
            return;
        }

        // BASED STATS HERE

        System.out.println("========== BASE STATS ==========");
        System.out.printf("Strength: %d\n", strength);
        System.out.printf("Vitality: %d\n", vitality);
        System.out.printf("Defense: %d\n", defense);
        System.out.printf("Dexterity: %d\n", dexterity);
        System.out.printf("Luck: %d\n", luck);
        System.out.printf("Intelligence: %d\n", intelligence);
        System.out.printf("Charisma: %d\n", charisma);

        // MAIN STATS HERE

        System.out.println("========== STATS ==========");
        System.out.printf("Attack: %d\n", attack);
        System.out.printf("Health: %d\n", health);
        System.out.printf("Defense: %d\n", mainDefense);
        System.out.println("Crit Chance: " + critChance + '%');
        System.out.println("Luck: "+ mainLuck + '%');
        System.out.printf("Magic: %d\n", mainIntelligence);
        System.out.printf("Charisma: %d\n", mainCharisma);

    }
    static int calculateAttack(int strength){
        return strength * 5;
    }
    static int calculateHealth(int vitality){
        return vitality * 25;
    }
    static int calculateDefense(int defense){
        return defense * 3;
    }
    static int calculateCritChance(int crit){
        return crit * 2;
    }
    static int calculateLuck(int luck){
        return luck;
    }
    static int calculateIntelligence(int intelligence){
        return intelligence * 6;
    }
    static int calculateCharisma(int charisma){
        return charisma * 6;
    }
}
