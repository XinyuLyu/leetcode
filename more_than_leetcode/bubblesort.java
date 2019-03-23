public class bubblesort{
    public static void bubblesort(int [] arr){
        if (arr==null||arr.length==0){
            return;
        }
        for (int j=0;j<arr.length-1;j++) {
            for (int i = arr.length - 1; i > j; i--)
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                }
        }

    }
    public static void swap(int [] arr,int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[]args){
        int [] arr =new int[]{3,7,2,1,5};
        bubblesort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}