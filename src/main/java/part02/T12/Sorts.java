package part02.T12;

public class Sorts {

    public static void bubbleSort(int[] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            boolean flag = true;
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }

    public static void insertSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            int val=arr[i];
            int index = i - 1;
            while (index>=0 && arr[index]>val){
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] = val;
        }
    }

    public static void selectSort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void mergeSort(int[] arr,int left,int right){
        if (left>right){
            return;
        }
        int q = (left+right)/2;
        mergeSort(arr,left,q);
        mergeSort(arr,q+1,right);
        merge2(arr,left,q,right);
    }

    private static void merge2(int[] arr,int left,int q,int right){
        int[] leftArr = new int[q-left+2];
        int[] rightArr = new int[right-q+1];

        for (int i=0;i<=q-left;i++){
            leftArr[i] = arr[left+i];
        }

        leftArr[q-left+1] = Integer.MAX_VALUE;
        for (int i=0;i<right-q;i++){
            rightArr[i]=arr[q+1+i];
        }

        rightArr[right-q]=Integer.MAX_VALUE;

        int i=0;
        int j=0;
        int k=left;
        while (k<=right){
            if (leftArr[i]<=rightArr[j]){
                arr[k++]=leftArr[i++];
            }else {
                arr[k++]=rightArr[j++];
            }
        }
    }

    private static void merge(int[] arr,int left,int q,int right){
        int i=left;
        int j=q+1;
        int k=0;
        int[] temp = new int[right-left+1];
        while (i<=q && j<=right){
            if (arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else {
                temp[k++]=arr[j++];
            }
        }
        int start = i;
        int end = q;
        if (j<=right){
            start=j;
            end=right;
        }
        while (start<=end){
            temp[k++]=arr[start++];
        }
        for (int l=0;l<=right-left;l++){
            arr[l+left]=temp[l];
        }
    }

    public static void quickSort(int[] arr,int left,int right){
        if (left>=right){
            return;
        }

        int q = partition2(arr,left,right);
        quickSort(arr,left,q-1);
        quickSort(arr,q+1,right);
    }

    private static int partition(int[] arr,int left,int right){
        int pivot = arr[right];
        int i=left;
        for (int j=left;j<right;j++){
            if (arr[j]<pivot){
                if (i==j){
                    ++i;
                }else {
                    int temp = arr[i];
                    arr[i++]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        int temp = arr[i];
        arr[i]=arr[right];
        arr[right]=temp;
        return i;
    }

    private static int partition2(int[] arr,int left,int right){
        int middle = (left+right)/2;
        int pivot = arr[middle];
        int val = arr[right];
        arr[right] = pivot;
        arr[middle] = val;
        int i = left;

        for (int j=left;j<right;j++){
            if (arr[j]<pivot){
                if (i==j){
                    ++i;
                }else {
                    int temp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        return i;
    }

    private static void quickSort3(int[] arr,int left,int right){
        if (left>=right)return;

        int l=left;
        int k=left+1;
        int r=right;
        int pivot=arr[l];

        while (k<=r){
            if (arr[k]<pivot){
                int temp = arr[l];
                arr[l] = arr[k];
                arr[k] = temp;
                l++;
                k++;
            }else if (arr[k]==pivot){
                k++;
            }else {
                if (arr[r]>pivot){
                    r--;
                }else if (arr[r]==pivot){
                    int temp = arr[k];
                    arr[k] =arr[r];
                    arr[r]=temp;
                    k++;
                    r--;
                }else {
                    int temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = arr[k];
                    arr[k] = temp;
                    l++;
                    k++;
                    r--;
                }
            }
        }
        quickSort(arr,left,l-1);
        quickSort(arr,r+1,right);
    }

    private static void quickSort4(int[] arr,int left,int right){
        if (left>=right)return;

        int l=left;
        int k=left+1;
        int r=right;

        if (arr[l]>arr[r]){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

        int pivot1 = arr[l];
        int pivot2 = arr[r];
        while (k<r){
            if (arr[k]<pivot1){
                l++;
                if (l!=k){
                    int temp = arr[l];
                    arr[l] = arr[k];
                    arr[k] = temp;
                }
                k++;
            }else if (arr[k]>=pivot1 && arr[k]<=pivot2){
                k++;
            }else {
                --r;
                if (arr[r]>pivot2){
                }else if (arr[r]>=pivot1 && arr[r]<=pivot2){
                    int temp = arr[k];
                    arr[k] = arr[r];
                    arr[r] = temp;
                    k++;
                }else {
                    l++;
                    int temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = arr[k];
                    arr[k] = temp;
                    k++;
                }
            }
        }

        arr[left] = arr[l];
        arr[l] = pivot1;
        arr[right] = arr[r];
        arr[r] = pivot2;

        quickSort(arr,left,l-1);
        quickSort(arr,l+1,r-1);
        quickSort(arr,r+1,right);
    }

    public static int sort(int[] arr,int l,int r,int k){
        if (l>=r){
            return 0;
        }
        int p = partition(arr,l,r);
        if ((p+1)==k){
            return arr[p];
        }else if ((p+1)<k){
            return sort(arr,p+1,r,k);
        }else {
            return sort(arr,l,p-1,k);
        }
    }




}
