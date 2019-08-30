import java.util.Map;

public class Human extends Creature {

    public Human() {
        energy = 30;
        costOfGoDownQuiqly = 13;
        costOfSpecicialAction = 15;
        levelOfUnderGraund = 0;
        name = "human";
        levelOfSpecialAction = 1;
        levelOfGoDown = 1;
    }

    @Override
    protected void specialAction(Map<Integer, User> mapOfOrderAndUser) {//проверка энергии выполняется в Users
        //Map испоьзовано, так как в методе play уже создано Map и будет удобно ее использовать
        for (int i = 1; i <= mapOfOrderAndUser.size(); i++) {
            Creature creature = mapOfOrderAndUser.get(i).creature;
            if (!creature.name.equals("human")) {
                if (creature.levelOfUnderGraund == (this.levelOfUnderGraund + levelOfSpecialAction)) {
                    creature.levelOfUnderGraund = creature.levelOfUnderGraund - levelOfSpecialAction;
                    System.out.println(creature + " level of UnderGraund is - " + creature.levelOfUnderGraund);
                }
            }
        }
        this.levelOfUnderGraund = this.levelOfUnderGraund + levelOfSpecialAction;
        this.energy = this.energy - costOfSpecicialAction;
        System.out.println("Your energy is - " + this.energy);
        System.out.println("Your level of UnderGraund is - " + this.levelOfUnderGraund);

    }

    @Override
    public String toString() {
        return "Human";
    }

}
