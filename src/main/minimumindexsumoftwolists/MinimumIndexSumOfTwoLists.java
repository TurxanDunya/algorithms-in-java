package main.minimumindexsumoftwolists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner,
 * and they both have a list of favorite restaurants represented by strings.
 * <p>
 * You need to help them find out their common interest with the least list index sum.
 * If there is a choice tie between answers, output all of them with no order requirement.
 * You could assume there always exists an answer.
 */

class MinimumIndexSumOfTwoLists {
    String[] findRestaurant(String[] firstRestaurants, String[] secondRestaurants) {
        Map<String, Integer> mapListIndexByRestaurant = new HashMap<>();
        int minimum = Integer.MAX_VALUE;

        //Put all elements by index to data structure named map
        int firstListIndex;
        for (firstListIndex = 0; firstListIndex < firstRestaurants.length; firstListIndex++) {
            mapListIndexByRestaurant.put(firstRestaurants[firstListIndex], firstListIndex);
        }

        //Check if any second list element is existed on first list
        int choiceCount = 0;
        for (int secondRestaurantIndex = 0;
             secondRestaurantIndex < secondRestaurants.length;
             secondRestaurantIndex++) {
            Integer foundedItemIndex = mapListIndexByRestaurant.get(secondRestaurants[secondRestaurantIndex]);
            if (foundedItemIndex != null) {
                int sum = foundedItemIndex + secondRestaurantIndex;
                if (sum < minimum) {
                    minimum = sum;
                    firstRestaurants[0] = secondRestaurants[secondRestaurantIndex];
                    choiceCount = 1;
                } else if (sum == minimum) {
                    firstRestaurants[choiceCount++] = secondRestaurants[secondRestaurantIndex];
                }
            }
        }

        //Eliminate null elements from result list
        String[] result = new String[choiceCount];
        System.arraycopy(firstRestaurants, 0, result, 0, choiceCount);
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        String[] andyList = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] dorisList = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        var minimumIndexSumOfTwoLists = new MinimumIndexSumOfTwoLists();
        String[] restaurant = minimumIndexSumOfTwoLists.findRestaurant(andyList, dorisList);
        System.out.println(Arrays.asList(restaurant));
    }
}