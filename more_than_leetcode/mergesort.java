
public class mergesort {
    public static void main(String []args){
        int []a = new int []{1,4,1,0,7,4,2,5,7};
        int []b=new int[a.length];
        sort(a, 0, a.length - 1,b);//quick sort without cut off to insertion sort
        System.out.println();
    }
    private static void sort(int[] arr,int left,int right,int []temp){

        if(left>=right)return;
        int mid = (left+right)/2;
        sort(arr,left,mid,temp);//sort left
        sort(arr,mid+1,right,temp);//sort right
        merge(arr,left,mid,right,temp);//merge
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){//partly cited from http://blog.csdn.net/yuehailin/article/details/68961304
        int i = left;
        int j = mid+1;
        int t = 0;
        while (i<=mid && j<=right){//  two sub arrays both have elements
            if(arr[i]<arr[j])temp[t++] = arr[i++];
            else {temp[t++] = arr[j++]; }
        }
        while(i<=mid&&j>right) temp[t++] = arr[i++];    //second sub array has no elements
        while(j<=right&&i>mid)temp[t++] = arr[j++];//first sub array has no elements
        for(int k=0;k<t;k++)// get the merged the sequence from the temp to the original array
            arr[left+k] = temp[k];
    }
}
