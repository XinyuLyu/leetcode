public class insertsort {
    public static void insersort(int [] arr){
        if(arr==null||arr.length==0){
            return;
        }
        for(int i=1;i<arr.length;i++) {
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
                else{
                    break;
                }
            }
        }
    }
    public static void swap(int []arr,int i,int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j]=temp;
    }
    public static void main(String[]args){
        int [] arr =new int[]{3,7,2,1,5};
        insersort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
