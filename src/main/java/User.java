import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class User {


    protected Creature creature = null;
    protected int orderNumber = 0;


    protected int choseOrderNumber(ArrayList<Integer> listOfOrderNumber) {
        int randomElementInList = new Random().nextInt(listOfOrderNumber.size());
        int randomObjectInList = listOfOrderNumber.get(randomElementInList);
        listOfOrderNumber.remove(randomElementInList);
        this.orderNumber = randomObjectInList;
        return randomObjectInList;

    }

    protected Creature choseHero(Map<String, Creature> mapOfHero) {

        Creature creature = null;
        System.out.println("Choose hero, type:  human, gnome , elf");

        while (creature == null) {
            if (mapOfHero.size() > 0) {
                try {
                    String userChooice = userInputChoose();
                    if (mapOfHero.containsKey(userChooice)) {
                        creature = mapOfHero.get(userChooice);
                        System.out.println("User chooice is - " + userChooice);
                        mapOfHero.remove(userChooice);
                    } else {
                        System.out.println("Creature was chosen/ is not acceptable, please, try again");
                    }

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                System.out.println("There is no hero now");
            }
        }
        System.out.println("User is - " + creature);
        this.creature = creature;
        return creature;
    }

    private String userInputChoose() throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String userInput = bufferedReader.readLine();

        return userInput;
    }

    protected void doAction(ArrayList<String> allActions, Map<Integer, User> mapOfOrderAndUsers) {
        System.out.println(creature + " turn!");
        System.out.println("Please, make some action:");
        for (int i = 0; i < allActions.size(); i++) {
            System.out.print(allActions.get(i) + "; ");
        }
        System.out.println("");
        try {
            String userAction = userInputChoose();
            if (userAction.equals("haveRest") && allActions.contains("haveRest")) {
                creature.haveRest();
                System.out.println(creature + " haveRest");
                System.out.println("");
            } else if (userAction.equals("goDown") && allActions.contains("goDown")) {
                creature.goDown(creature);
                System.out.println(creature + " goDown");
                System.out.println("");
            } else if (userAction.equals("goDownQuickly") && allActions.contains("goDownQuickly")) {
                if (creature.energy >= creature.costOfGoDownQuiqly) {
                    creature.goDownQuickly(creature);
                    System.out.println(creature + " goDownQuickly");
                    System.out.println("");
                } else {
                    allActions.remove("goDownQuickly");
                    System.out.println("You can not do it. Your energy is over.");
                    System.out.println("Please, choose something else");
                    doAction(allActions, mapOfOrderAndUsers);
                }
            } else if (userAction.equals("specialAction") && allActions.contains("specialAction")) {
                if (creature.energy >= creature.costOfSpecicialAction) {
                    creature.specialAction(mapOfOrderAndUsers);
                    System.out.println(creature + " specialAction");
                    System.out.println("");
                } else {
                    allActions.remove("specialAction");
                    System.out.println("You can not do it. Your energy is over.");
                    System.out.println("Please, choose something else");
                    doAction(allActions, mapOfOrderAndUsers);
                }
            } else {
                System.out.println("You have type incorrect action, please, try again");
                System.out.println("");
                doAction(allActions, mapOfOrderAndUsers);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


}
