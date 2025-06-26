package WBJEE.demo.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public static List<Integer> findTriplet(int[] nums, int tar, int i){
        List<Integer> arr=new ArrayList();
        int j=nums.length-1;
        System.out.println("HIIIIIIIIIIIIIIIIIIIIIIII");
        while(i<j){
//            System.out.println("");
//            if(nums[i]==nums[i+1]){
//                i++;
//                continue;
//            }
//            if(nums[j]==nums[j-1]){
//                j--;
//                continue;
//            }

            if(nums[i]+nums[j]==tar){
                arr.add(tar);
                arr.add(nums[i]);
                arr.add(nums[j]);
                return arr;

            }else if(nums[i]+nums[j]>tar){
                j--;

            }else if(nums[i]+nums[j]<tar){
                i++;

            }
        }
        return arr;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList();
        Arrays.sort(nums);


        for(int i=0;i<nums.length-1;i++){

                int tar=-nums[i];
                System.out.println("tar="+tar+"i+1 = "+(i+1));
                List<Integer> arr=findTriplet(nums,tar,i+1);
                if(arr.size()!=0){
                    result.add(arr);

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int nums[]={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}