package part02.T13;

public class RadixSort {

    public static void radixSort(int[] arr){
        int max = arr[0];
        for (int i=0;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }

        for (int exp=1;max/exp>0;exp*=10){
            countingSort(arr,exp);
        }
    }

    public static void countingSort(int[] arr,int exp){
        if (arr.length<=1){
            return;
        }

        int[] c = new int[10];
        for (int i=0;i<arr.length;i++){
            c[(arr[i]/exp)%10]++;
        }

        for (int i=1;i<c.length;i++){
            c[i] += c[i-1];
        }

        int[] r = new int[arr.length];
        for (int i=arr.length-1;i>=0;i--){
            r[c[(arr[i]/exp)%10]-1] = arr[i];
            c[(arr[i]/exp)%10]--;
        }

        for (int i=0;i<arr.length;i++){
            arr[i]=r[i];
        }
    }

}
