import java.util.ArrayList;
public class ShellSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        ArrayList<Integer> sorted = new ArrayList<>(input);
        int n = sorted.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = sorted.get(i);
                int j;
                for (j = i; j >= gap && sorted.get(j - gap) > temp; j -= gap) {
                    sorted.set(j, sorted.get(j - gap));
                }
                sorted.set(j, temp);
            }
        }
        return sorted;
    }
}
