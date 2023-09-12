package problems.easy;

import java.util.HashSet;
import java.util.Set;

public class SetsTest {

    public static void main(String[] args) {
        Set<String> myFavoriteFoods = new HashSet<>();
        myFavoriteFoods.add("pizza");
        myFavoriteFoods.add("sushi");
        myFavoriteFoods.add("steak");
        myFavoriteFoods.add("chicken");
        Set<String> yourFavoriteFoods = Set.of("pizza", "sushi", "pasta", "candy");

        Set<String> ourFavouriteFoods = new HashSet<>(myFavoriteFoods);
        ourFavouriteFoods.retainAll(yourFavoriteFoods);
        System.out.println("Our favs: " + ourFavouriteFoods);

        // Not our favourite foods, symmetric difference between my and your favs
        Set<String> notOurFavouriteFoods = new HashSet<>(myFavoriteFoods);
        notOurFavouriteFoods.addAll(yourFavoriteFoods);
        notOurFavouriteFoods.removeAll(ourFavouriteFoods);
        System.out.println("Not our favs: " + notOurFavouriteFoods);
    }
}
