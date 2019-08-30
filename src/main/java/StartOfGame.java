import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class StartOfGame {

    protected int numberOfUsers = 2;

    protected ArrayList<Creature> createHeroes() {
        ArrayList<Creature> heroList = new ArrayList<Creature>();

        Human human = new Human();
        Gnome gnome = new Gnome();
        Elf elf = new Elf();

        heroList.add(human);
        heroList.add(gnome);
        heroList.add(elf);
        return heroList;
    }


    protected Map<String, Creature> createMapOfHero(ArrayList<Creature> heroList) {
        Map<String, Creature> mapOfHero = new HashMap<String, Creature>();
        for (int i = 0; i < heroList.size(); i++) {
            mapOfHero.put(heroList.get(i).name, heroList.get(i));
        }
        return mapOfHero;
    }


    protected ArrayList<Integer> createListOfOrderNumber() {
        ArrayList<Integer> orderNumberList = new ArrayList<Integer>();
        for (int i = 0; i < numberOfUsers; i++) {
            orderNumberList.add(i + 1);
        }
        return orderNumberList;
    }


    protected ArrayList<User> createUsersAndChooseHero(ArrayList<Integer> listOfOrderNumber, Map<String, Creature> mapOfHero) {
        ArrayList<User> userList = new ArrayList<User>();
        for (int i = 0; i < numberOfUsers; i++) {
            User user = new User();
            System.out.println("User" + (i + 1) + " make choice:");
            user.choseHero(mapOfHero);
            int order = user.choseOrderNumber(listOfOrderNumber);
            System.out.println("User" + (i + 1) + " have order " + order);
            userList.add(user);
            System.out.println("");
        }

        return userList;

    }


    protected Map<Integer, User> getMapOfOrderAndUser(ArrayList<User> userArrayList) {
        Map<Integer, User> mapOfOrderAndUser = new HashMap<Integer, User>();
        for (int i = 0; i < numberOfUsers; i++) {
            mapOfOrderAndUser.put(userArrayList.get(i).orderNumber, userArrayList.get(i));
        }
        return mapOfOrderAndUser;
    }


    protected void play(Map<Integer, User> mapOfOrderAndUser) {
        for (int i = 1; i <= numberOfUsers; i++) {
            User user = mapOfOrderAndUser.get(i);
            user.doAction(user.creature.allActions(), mapOfOrderAndUser);
            if (user.creature.levelOfUnderGraund < 20) {
                if (i == numberOfUsers) {
                    i = i - numberOfUsers;
                }
            } else {
                System.out.println("Win " + user.creature);
                break;
            }
        }
    }


}
