public class selectsort {
    public static void selecesort(int []arr){
        if(arr==null||arr.length==0){
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            int min =i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]) {
                    min = j;
                }
            }
            if(i != min){
                swap(arr,i,min);
            }
        }
    }
    public static void swap(int[]arr,int i, int min){
        int temp = arr[i];
        arr[i] =arr[min];
        arr[min]= temp;
    }
    public static void main(String []args){
        int []arr = new int[]{3,7,2,1,5};
        selecesort(arr);
        for(int i: arr){
            System.out.println(i);
        }
    }
}
