package budget.utils;

import budget.model.Expense;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListSorter {

    public static List<Expense> bubbleSortDesc(List<Expense> originalList) {
        List<Expense> list = new ArrayList<>(List.copyOf(originalList));

        for (int mainIndex = 0; mainIndex < list.size(); mainIndex++) {
            for (int subIndex = 0; subIndex < (list.size() - mainIndex - 1); subIndex++) {
                if (list.get(subIndex).getPrice() < list.get(subIndex + 1).getPrice()) {
                    Expense temp = list.get(subIndex);
                    // Swap the element
                    list.set(subIndex, list.get(subIndex + 1));
                    list.set(subIndex + 1, temp);
                }
            }
        }

        return list;
    }

    public static List<Map.Entry<String, Double>> bubbleSortDesc(Map<String, Double> categories) {
        List<Map.Entry<String, Double>> entries = new ArrayList<>(categories.entrySet());

        for (int mainIndex = 0; mainIndex < entries.size(); mainIndex++) {
            for (int subIndex = 0; subIndex < (entries.size() - mainIndex - 1); subIndex++) {
                if (entries.get(subIndex).getValue() < entries.get(subIndex + 1).getValue()) {
                    Map.Entry<String, Double> temp = entries.get(subIndex);
                    // Swap the element
                    entries.set(subIndex, entries.get(subIndex + 1));
                    entries.set(subIndex + 1, temp);
                }
            }
        }

        return entries;
    }
}
