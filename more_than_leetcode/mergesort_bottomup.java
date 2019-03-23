public class mergesort_bottomup {
        public static void main(String[] args) {
            int []a = new int []{1,4,1,0,7,4,2,5,7};
            sort(a);
        }
        private static void sort(int a[]) { //cited from 4th edition of Algorithm 2.2.3
            int N = a.length;
            int[] b = new int[N];
            for (int sz = 1; sz < N; sz = sz + sz) {
                for (int lo = 0; lo < N - sz; lo += sz + sz)
                    merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1), b);
            }
        }
        private static void merge(int[] arr, int left, int mid, int right, int[] temp) {//partly cited from http://blog.csdn.net/yuehailin/article/details/68961304
            int i = left;
            int j = mid + 1;
            int t = 0;
            while (i <= mid && j <= right) {//  two sub arrays both have elements
                if (arr[i]< arr[j]) temp[t++] = arr[i++];
                else {
                    temp[t++] = arr[j++];
                }
            }
            while (i <= mid && j > right) temp[t++] = arr[i++];    //second sub array has no elements
            while (j <= right && i > mid) temp[t++] = arr[j++];//first sub array has no elements
            for (int k = 0; k < t; k++)// get the merged the sequence from the temp to the original array
                arr[left + k] = temp[k];
        }

}
