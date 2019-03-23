
public class quicksort {

    public static void main(String[] args) {
        int []a = new int []{1,4,1,0,7,4,2,5,7};
        quickSort(a, 0, a.length - 1);//quick sort without cut off to insertion sort
    }
    public static void quickSort(int[] arr, int left, int right) {
        if(right<=left) return;
        int i=left,j=right+1;
        three_median_Pivot(arr,left,right);
        int v=arr[left];
        while(true)
        {
            while(arr[++i]<v) if(i==right) break;
            while((v<arr[--j])) if(j==left) break;
            if(i>=j) break;
            swap(arr,i,j);
        }
        swap(arr,left,j);
        quickSort(arr,left,j-1);  //sort left
        quickSort(arr,j+1,right);// sort right
    }
    public static void three_median_Pivot(int[] arr, int left, int right) {// get the pivot as the median among left, mid and right
        int mid = (left + right) / 2;
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[right] < arr[mid]) {
            swap(arr, right, mid);
        }// aim: left < mid < right
        swap(arr,mid,left);// exchange mid and left, so we can get a[left] as the three-median-pivot
    }
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
