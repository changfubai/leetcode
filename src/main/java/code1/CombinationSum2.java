package code1;

import java.util.*;

/**
 * Created by changfubai on 2018/3/6
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : candidates) hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        Set<Integer> set = hashMap.keySet();
        List<List<Integer>> lists = new ArrayList<>();
        int[] array = set.stream().mapToInt(i -> i).toArray();
        Arrays.sort(array);
        addList(lists, new ArrayList<>(),array , hashMap, target, 0);
        return lists;
    }

    private void addList(List<List<Integer>> lists, List<Integer> list, int[] candidates, HashMap<Integer, Integer> hashMap, int target, int i) {
        if (candidates.length <= i || candidates[i] > target) return;
        int num = candidates[i];
        if (num == target) {
            list.add(num);
            lists.add(list);
            return;
        }
        if (hashMap.get(num) == 1) {
            addList(lists, new ArrayList<>(list), candidates, new HashMap<>(hashMap), target, i + 1);
            list.add(num);
            addList(lists, new ArrayList<>(list), candidates, new HashMap<>(hashMap), target - num, i + 1);
        } else {
            int j = 0;
            while (hashMap.get(num) > 0) {
                j++;
                hashMap.put(num, hashMap.get(num) - 1);
                if (j == 1) addList(lists, new ArrayList<>(list), candidates, new HashMap<>(hashMap), target, i + 1);
                list.add(num);
                target = target - num;
                if (target == 0) {
                    lists.add(list);
                    return;
                }
                if (target < 0) return;
                addList(lists, new ArrayList<>(list), candidates, new HashMap<>(hashMap), target, i + 1);
            }
        }
    }
}
