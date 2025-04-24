public class Dichotomy {
    //第一种写法，左闭右闭
    public int search(int[] nums,int target){
        if(target<nums[0]||target>nums[nums.length-1]){
            return -1;
        }
        int left=0;
        int right=nums.length-1;
        //left==right时有区间有意义，[left,right]
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(nums[mid]>target){
                //此时mid位置的值肯定不是target,所以要搜索[left,mid-1]内的元素
                right=mid-1;
            }else if(nums[mid]<target){
                //此时mid位置的值一定不是target,所以要搜索[mid+1,right]内的元素
                left=mid+1;
            }else{
                //此时nums[mid]==target
                return mid;
            }
        }
        return -1;//未找到目标值
    }
    //第二种写法：左闭右开
    public int search1(int[] nums,int target){
        if(target<nums[0]||target>nums[nums.length-1]){
            return -1;
        }
        int left=0;
        int right=nums.length-1;
        //因为搜索的区间是[left,right),当left==right时无区间没意义，所以不写=，比如left=right=1时,[1,1）无区间
        while(left<right){
            int mid=left+((right-left)>>1);
            if(nums[mid]>target){
                //此时mid位置的值肯定不是target,需要搜索的区间时[left,mid-1],也就是[left,mid)
                right=mid;
            }else if(nums[mid]<target){
                //此时mid位置的值肯定不是target,需要搜索的区间是[mid+1,right),故left=mid+1;
                left=mid+1;
            }else{
                //此时nums[mid]==target
                return mid;
            }
        }
        return -1;
    }
}
