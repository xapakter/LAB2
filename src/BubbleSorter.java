import java.util.ArrayList;
public class BubbleSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        ArrayList<Integer> sorted = new ArrayList<>(input);
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < sorted.size() - 1; i++) {
                if (sorted.get(i) > sorted.get(i + 1)) {
                    int temp = sorted.get(i);
                    sorted.set(i, sorted.get(i + 1));
                    sorted.set(i + 1, temp);
                    swapped = true;
                }
            }
        } while (swapped);
        return sorted;
    }
}
