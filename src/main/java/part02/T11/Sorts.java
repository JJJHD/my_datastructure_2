package part02.T11;

public class Sorts {

    public static void bubbleSort(int[] a,int n){
        if (n<=1)return;
        for (int i=0;i<n;++i){
            boolean flag = false;
            for (int j=0;j<n-i-1;++j){
                if (a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag=true;
                }
            }
            if (!flag)break;
        }
    }

    public static void bubbleSort2(int[] a,int n){
        if (n<=1)return;

        int lastExchange = 0;
        int sortBorder = n-1;

        for (int i=0;i<n;i++){
            boolean flag = false;
            for (int j=0;j<sortBorder;j++){
                if (a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag=true;
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag)break;
        }
    }

    public static void insertionSort(int[] a,int n){
        if (n<=1)return;

        for (int i=1;i<n;++i){
            int value = a[i];
            int j = i-1;
            for (;j>=0;--j){
                if (a[j]>value){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1]=value;
        }
    }

    public static void selectionSort(int[] a,int n){
        if (n<=1)return;

        for (int i=0;i<n-1;++i){
            int minIndex = i;
            for (int j=i+1;j<n;++j){
                if (a[j]<a[minIndex]){
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }



}
