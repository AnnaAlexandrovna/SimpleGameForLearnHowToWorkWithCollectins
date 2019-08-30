import java.util.ArrayList;
import java.util.Map;

public class Gnome extends Creature {

    public Gnome() {
        energy = 50;
        costOfGoDownQuiqly = 15;
        costOfSpecicialAction = 20;
        levelOfUnderGraund = 0;
        name = "gnome";
    }


    @Override
    protected void specialAction(Map<Integer, User> mapOfOrderAndUser) {//проверка энергии выполняется в Users
        //Map испоьзовано, так как в методе play уже создано Map и будет удобно ее использовать

        User userGnome = null;
        int userOrder = 0;

        for (int i = 1; i <= mapOfOrderAndUser.size(); i++) {
            if (mapOfOrderAndUser.get(i).creature.name.equals("gnome")) {
                userGnome = mapOfOrderAndUser.get(i);
                userOrder = userGnome.orderNumber;
                System.out.println("userOrder=" + userOrder);
            }
        }

        int numderOfPlayer = 2;
// увеличиваем уровень, уменьшаем энергию гнома
        this.levelOfUnderGraund = this.levelOfUnderGraund + 1;
        this.energy = this.energy - costOfSpecicialAction;
        System.out.println("Your energy is - " + this.energy);
        System.out.println("Your level of UnderGraund is - " + this.levelOfUnderGraund);
        System.out.println("");
        //ищем следующего персонажа
        int nextPlayerOrderNumder = userOrder + 1;
        if (nextPlayerOrderNumder > numderOfPlayer) {
            nextPlayerOrderNumder = nextPlayerOrderNumder - numderOfPlayer;
        }
        User user = mapOfOrderAndUser.get(nextPlayerOrderNumder);
        System.out.println("next is " + user.creature);

        // в зависимости от типа и уровня персонажа ходим им
        ArrayList<String> arrayListOfActionForHuman = allActions();
        ArrayList<String> arrayListOfActionForElf = allActions();
        ArrayList<String> arrayListForGnome = allActions();
        if (user.creature.name.equals("human")) {
            if ((user.creature.levelOfUnderGraund + Creature.levelOfGoDownQuiqly) >= this.levelOfUnderGraund) {
                arrayListOfActionForHuman.remove("goDownQuickly");
                if ((user.creature.levelOfUnderGraund + 1) >= this.levelOfUnderGraund) {
                    arrayListOfActionForHuman.remove("goDown");
                    arrayListOfActionForHuman.remove("specialAction");
                }
            }

            user.doAction(arrayListOfActionForHuman, mapOfOrderAndUser);
            System.out.println(user.creature + " energy is - " + user.creature.energy);
            System.out.println(user.creature + " level of UnderGraund is - " + user.creature.levelOfUnderGraund);
            System.out.println("");
        } else if (user.creature.name.equals("elf")) {
            if ((user.creature.levelOfUnderGraund + user.creature.levelOfSpecialAction) >= this.levelOfUnderGraund) {
                arrayListOfActionForElf.remove("specialAction");
                if ((user.creature.levelOfUnderGraund + Creature.levelOfGoDownQuiqly) >= this.levelOfUnderGraund) {
                    arrayListOfActionForElf.remove("goDownQuickly");
                    if ((user.creature.levelOfUnderGraund + user.creature.levelOfGoDown) >= this.levelOfUnderGraund) {
                        arrayListOfActionForElf.remove("goDown");
                    }
                }
            }

            user.doAction(arrayListOfActionForElf, mapOfOrderAndUser);
            System.out.println(user.creature + " energy is - " + user.creature.energy);
            System.out.println(user.creature + " level of UnderGraund is - " + user.creature.levelOfUnderGraund);
            System.out.println("");
        }

        // возвращаемся к гному (так как персонажа всего 2) и ходим им
        nextPlayerOrderNumder = nextPlayerOrderNumder + 1;
        if (nextPlayerOrderNumder > numderOfPlayer) {
            nextPlayerOrderNumder = nextPlayerOrderNumder - numderOfPlayer;
        }

        User user1 = mapOfOrderAndUser.get(nextPlayerOrderNumder);
        user1.doAction(arrayListForGnome, mapOfOrderAndUser);

    }


    @Override
    public String toString() {
        return "Gnome";
    }
}
