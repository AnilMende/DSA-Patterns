public class CyclicSort {
    public static void main(String[] args) {
        int nums[] = {3,0,1};
        //sort(nums)
        //sort1(nums)
    }
    //If the values in nums are in the range of [0, N] => index = value
    //If the values in nums are in the range of [1, N] => index = value - 1

    //For inputs in the range [0,N]
    static void sort(int nums[]){
        int i=0;
        while(i < nums.length){
            int current = nums[i];
            if(nums[i] != nums[current]){
                swap(nums, i, current);
            }
            else{
                i++;
            }
        }
        //finding missing element
       // for(int ind = 0; ind < nums.length;ind++){
       //     if(nums[ind] != ind){
       //         return ind;
       //     }
       // }
       // return nums.length;
    }

    //For inputs in the range [1,N]
    static void sort1(int nums[]){
        int i = 0;
        while(i < nums.length){
            int current = nums[i] - 1;
            if(nums[i] != nums[current]){
                swap(nums, i, current);
            }
            else{
                i++;
            }
        }
        //finding missing element
       // for(int ind = 0;ind < nums.length;ind++){
       //     if(nums[ind] != ind + 1){
       //         return ind+1;
       //     }
       // }
    }

    static void swap(int nums[], int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
