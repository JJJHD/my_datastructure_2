package part01;

public class T3 {

//  (2n+2)*unit_time
//    int cal(int n) {
//        int sum = 0;
//        int i = 1;
//        for (; i <= n; ++i) {
//            sum = sum + i;
//        }
//        return sum;
//    }


//  (2n2+2n+3)*unit_time
//    int cal(int n) {
//        int sum = 0;
//        int i = 1;
//        int j = 1;
//        for (; i <= n; ++i) {
//            j = 1;
//            for (; j <= n; ++j) {
//                sum = sum +  i * j;
//            }
//        }
//        return sum;
//    }

//  O(n)
//    int cal(int n) {
//        int sum = 0;
//        int i = 1;
//        for (; i <= n; ++i) {
//            sum = sum + i;
//        }
//        return sum;
//    }


//    O(n2)
//    int cal(int n) {
//        int sum_1 = 0;
//        int p = 1;
//        for (; p < 100; ++p) {
//            sum_1 = sum_1 + p;
//        }
//
//        int sum_2 = 0;
//        int q = 1;
//        for (; q < n; ++q) {
//            sum_2 = sum_2 + q;
//        }
//
//        int sum_3 = 0;
//        int i = 1;
//        int j = 1;
//        for (; i <= n; ++i) {
//            j = 1;
//            for (; j <= n; ++j) {
//                sum_3 = sum_3 +  i * j;
//            }
//        }
//
//        return sum_1 + sum_2 + sum_3;
//    }


//    O(n2)
//    int cal(int n) {
//        int ret = 0;
//        int i = 1;
//        for (; i < n; ++i) {
//            ret = ret + f(i);
//        }
//        return ret;
//    }
//
//    int f(int n) {
//        int sum = 0;
//        int i = 1;
//        for (; i < n; ++i) {
//            sum = sum + i;
//        }
//        return sum;
//    }


//    O(1)
//    int i = 8;
//    int j = 6;
//    int sum = i + j;

//    O(log2n)
//    i=1;
//    while (i <= n)  {
//        i = i * 2;
//    }

//    O(log3n)
//    i=1;
//    while (i <= n)  {
//        i = i * 3;
//    }

//    O(logn)


//    O(m+n)
//    int cal(int m, int n) {
//        int sum_1 = 0;
//        int i = 1;
//        for (; i < m; ++i) {
//            sum_1 = sum_1 + i;
//        }
//
//        int sum_2 = 0;
//        int j = 1;
//        for (; j < n; ++j) {
//            sum_2 = sum_2 + j;
//        }
//
//        return sum_1 + sum_2;
//    }


//    O(n)
//    void print(int n) {
//        int i = 0;
//        int[] a = new int[n];
//        for (i; i <n; ++i) {
//            a[i] = i * i;
//        }
//
//        for (i = n-1; i >= 0; --i) {
//            print out a[i]
//        }
//    }



}
