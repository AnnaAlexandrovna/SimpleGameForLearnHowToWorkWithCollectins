import java.util.Map;

public class Elf extends Creature {

    public Elf() {
        energy = 40;
        costOfGoDownQuiqly = 12;
        costOfSpecicialAction = 24;
        levelOfUnderGraund = 0;
        name = "elf";
        levelOfSpecialAction = 3;
        levelOfGoDown = 1;
    }


    @Override
    protected void specialAction(Map<Integer, User> mapOfOrderAndUser) {//проверка энергии выполняется в Users
        //Map испоьзовано, так как в методе play уже создано Map и будет удобно ее использовать

        for (int i = 1; i <= mapOfOrderAndUser.size(); i++) {
            Creature creature = mapOfOrderAndUser.get(i).creature;
            if (creature.name.equals("elf")) {
                creature.energy = creature.energy - creature.costOfSpecicialAction;
                creature.levelOfUnderGraund = levelOfUnderGraund + levelOfSpecialAction;
                System.out.println("Your energy is - " + creature.energy);
                System.out.println("Your level of UnderGraund is - " + creature.levelOfUnderGraund);
            }
        }
    }


    @Override
    public String toString() {
        return "Elf";
    }
}
