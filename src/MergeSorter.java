import java.util.ArrayList;

public class MergeSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        if (input.size() <= 1) {
            return input;
        }
        int middle = input.size() / 2;
        ArrayList<Integer> onepert = new ArrayList<>(input.subList(0, middle));
        ArrayList<Integer> twopart = new ArrayList<>(input.subList(middle, input.size()));
        onepert = sort(onepert);
        twopart = sort(twopart);
        return merge(onepert, twopart);
    }
    private ArrayList<Integer> merge(ArrayList<Integer> onepart, ArrayList<Integer> twopart) {
        ArrayList<Integer> result = new ArrayList<>();
        int oneIndex = 0;
        int twoIndex = 0;
        while (oneIndex < onepart.size() && twoIndex < twopart.size()) {
            if (onepart.get(oneIndex) < twopart.get(twoIndex)) {
                result.add(onepart.get(oneIndex));
                oneIndex++;
            } else {
                result.add(twopart.get(twoIndex));
                twoIndex++;
            }
        }
        result.addAll(onepart.subList(oneIndex, onepart.size()));
        result.addAll(twopart.subList(twoIndex, twopart.size()));
        return result;
    }
}
