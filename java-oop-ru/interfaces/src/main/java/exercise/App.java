package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int elementsCount) {
        var resultList = new ArrayList<String>();
        if (!homes.isEmpty()) {
            var sortedHomes = homes.stream().sorted(Comparator.comparingDouble(Home::getArea)).toList();
            for (int i = 0; i < elementsCount; i++) {
                resultList.add(sortedHomes.get(i).toString());
            }
            return resultList;
        } else {
            return resultList;
        }
    }
}
// END
