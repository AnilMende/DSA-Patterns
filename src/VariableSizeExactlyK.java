import java.util.HashMap;

public class VariableSizeExactlyK {
    public static void main(String[] args) {

        //Problem 1
        int nums[] = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        int res = atMost(nums,k) - atMost(nums,k-1);
        System.out.println(res);

        //Problem 2
        int nums1[] = {1,3,1,2,2};
        int res1 = CountCompleteSubarrays(nums1,3) - CountCompleteSubarrays(nums1,2);
        System.out.println("Count of Complete Subarrays are " + res1);

        //Problem 3
        int nums2[] = {1,0,1,0,1};
        int goal = 2;
        int res2 = numSubarraysWithSum(nums2, goal) - numSubarraysWithSum(nums2,goal-1);
        System.out.println("Number of Subarrays with sum " + res2);
    }

    static int atMost(int nums[], int k){

        int count = 0;
        int left = 0;

        int oddCount = 0;
        for(int right = 0;right < nums.length;right++){
            if(nums[right] % 2 != 0){
                oddCount++;
            }

            while(oddCount > k){
                if(nums[left] % 2 != 0){
                    oddCount--;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    static int CountCompleteSubarrays(int nums[], int k){

        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;

        for(int right = 0;right < nums.length;right++){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);

            while(map.size() > k){
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    // Binary subarrays with sum
    //return the number of non-empty subarrays with sum goal

    static int numSubarraysWithSum(int nums[], int k){
        if(k < 0){
            return 0;
        }

        int count2 = 0;
        int sum2 = 0;
        int left = 0;

        for(int right = 0;right < nums.length;right++){
            sum2 += nums[right];

            while(sum2 > k){
                sum2 -= nums[left];
                left++;
            }

            count2 += right - left + 1;
        }
        return count2;
    }

}
