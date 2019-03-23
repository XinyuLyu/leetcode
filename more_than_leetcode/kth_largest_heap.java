import java.util.PriorityQueue;

public class kth_largest_heap {
    public static void main(String[] args) {
    int []a = new int []{2,2,2,5,7,4,0,1,3,1};
    median(a,3);
    System.out.println();
}
    public static double median(int[] array,int k){
        int heapSize = k;
        PriorityQueue<Integer> heap = new PriorityQueue<>(heapSize);
        for(int i=0; i<heapSize; i++){
            heap.add(array[i]);
        }
        for(int i=heapSize; i<array.length; i++){
            if(heap.peek()<array[i]){
                heap.poll();
                heap.add(array[i]);
            }
        }
        if(array.length % 2 == 1){
            return (double)heap.peek();
        }
        else{
            return (double)(heap.poll()+heap.peek())/2.0;
        }
    }
}
