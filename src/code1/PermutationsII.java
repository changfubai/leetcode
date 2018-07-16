package code1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by changfubai96@gmail.com on 2018/7/16
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        permute(lists, nums, 0);
        return lists;
    }
    private void permute(ArrayList<List<Integer>> lists, int[] nums, int seq){
        if(seq == nums.length - 1){
            lists.add(convert2List(nums));
        }
        for(int i = seq; i < nums.length; i++){
            if(isSwap(nums, seq, i)){
                swap(nums, i, seq);
                permute(lists, nums, seq + 1);
                swap(nums, i, seq);
            }
        }
    }
    private boolean isSwap(int[] a, int s, int e){
        for(int i = s; i < e; i++){
            if(a[i] == a[e]){
                return false;
            }
        }
        return true;
    }
    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private ArrayList<Integer> convert2List(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            list.add(nums[i]);
        }
        return list;
    }
}
