import java.util.ArrayList;
import java.util.Map;

public class Creature {
    protected int energy;
    protected int costOfGoDownQuiqly;
    protected int costOfSpecicialAction;
    protected int levelOfUnderGraund = 0;
    protected static int costOfGoDown = 5;
    protected static int energyOfRest = 2;
    protected int levelOfGoDown = 1;
    protected static int levelOfGoDownQuiqly = 2;
    protected String name = "creature";
    protected int levelOfSpecialAction;


    protected void haveRest() {
        energy = energy + energyOfRest;
        System.out.println("Your energy is - " + energy);
        System.out.println("Your level of UnderGraund is  - " + levelOfUnderGraund);
    }

    protected void goDown(Creature creature) {
        if (creature.energy >= costOfGoDown) {
            creature.energy = creature.energy - costOfGoDown;
            creature.levelOfUnderGraund = creature.levelOfUnderGraund + levelOfGoDown;
            System.out.println("Your energy is - " + creature.energy);
            System.out.println("Your level of UnderGraund is - " + creature.levelOfUnderGraund);
        } else {
            System.out.println("You can not do it. Your energy is over.");
            System.out.println("The only thing you have energy for - rest. So, now you have rest.");
            creature.haveRest();
        }

    }

    protected void goDownQuickly(Creature creature) {//проверка энергии выполняется в Users
        creature.energy = creature.energy - creature.costOfGoDownQuiqly;
        creature.levelOfUnderGraund = creature.levelOfUnderGraund + creature.levelOfGoDownQuiqly;
        System.out.println("Your energy is - " + creature.energy);
        System.out.println("Your level of UnderGraund is - " + creature.levelOfUnderGraund);
    }

    protected void specialAction(Map<Integer, User> mapOfOrderAndUser) {
        System.out.println("This creature too lazy to specialAction");
    }

    protected ArrayList<String> allActions() {
        ArrayList<String> allActions = new ArrayList<String>();
        allActions.add("haveRest");
        allActions.add("goDown");
        allActions.add("goDownQuickly");
        allActions.add("specialAction");
        return allActions;
    }

}
