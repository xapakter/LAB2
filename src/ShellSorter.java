import java.util.ArrayList;
public class ShellSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        ArrayList<Integer> sorted = new ArrayList<>(input);
        int n = sorted.size();
        for (int m = n / 2; m > 0; m /= 2) {
            for (int i = m; i < n; i++) {
                int temp = sorted.get(i);
                int j;
                for (j = i; j >= m && sorted.get(j - m) > temp; j -= m) {
                    sorted.set(j, sorted.get(j - m));
                }
                sorted.set(j, temp);
            }
        }
        return sorted;
    }
}
