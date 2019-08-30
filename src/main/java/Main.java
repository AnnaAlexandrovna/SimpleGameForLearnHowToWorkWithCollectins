import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        StartOfGame startOfGame = new StartOfGame();
        ArrayList<User> userArrayList = startOfGame.createUsersAndChooseHero(startOfGame.createListOfOrderNumber(), startOfGame.createMapOfHero(startOfGame.createHeroes()));
        startOfGame.play(startOfGame.getMapOfOrderAndUser(userArrayList));

    }
}