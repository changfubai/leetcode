package code1;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by changfubai96@gmail.com on 2018/7/16
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        getPermute(lists, nums, 0);
        return lists;
    }

    private void getPermute(ArrayList<List<Integer>> lists, int[] nums, int seq) {
        if (seq == nums.length - 1) {
            lists.add(covert2List(nums));
        }
        for (int i = seq; i < nums.length; i++) {
            swap(nums, i, seq);
            getPermute(lists, nums, seq + 1);
            swap(nums, i, seq);
        }
    }

    private List<Integer> covert2List(int[] nums) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            integers.add(nums[i]);
        }
        return integers;
    }

    private void swap(int[] a, int i, int seq) {
        int num = a[i];
        a[i] = a[seq];
        a[seq] = num;
    }
}
