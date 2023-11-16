import java.util.ArrayList;
public class QuickSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        if (input.size() <= 1) {
            return input;
        }
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();
        int pivot = input.get(input.size() / 2);
        for (Integer element : input) {
            if (element < pivot) {
                less.add(element);
            } else if (element.equals(pivot)) {
                equal.add(element);
            } else {
                greater.add(element);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(sort(less));
        result.addAll(equal);
        result.addAll(sort(greater));
        return result;
    }
}
