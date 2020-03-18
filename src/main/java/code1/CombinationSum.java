package code1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by changfubai on 2018/3/4
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        addList(lists, new ArrayList<>(), candidates, target, 0);
        return lists;
    }
    private void addList(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int i) {
        if (candidates.length == i || candidates[i] > target) {
            if (list.size() > 0 && target == 0) lists.add(list);
            return;
        }
        for (int j = 0; j < target / candidates[i]; j++) {
            if (j == 0) addList(lists, new ArrayList<>(list), candidates, target, i + 1);
            list.add(candidates[i]);
            addList(lists, new ArrayList<>(list), candidates, target - candidates[i] * (j + 1), i + 1);
        }
    }
}
