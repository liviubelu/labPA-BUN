import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] arr = {2, 6, 4, 7, 3, 9, 8};
        Insertie(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {1, 2, 8, 5, 3, 6, 9, 7};
        SortareSelectieMinim(arr2);
        System.out.println(Arrays.toString(arr2));

        int cmmdc = Euclid.euclid(15, 60);
        System.out.println("Euclid= " + cmmdc);

        int fibo = FibonacciRecursiv.fibo(10);
        System.out.println("Fibonacci recursiv= " + fibo);

        int fiboIterativ = FibonaccIterative.fiboIterativ(10);
        System.out.println("Fibonacci iterativ= " + fiboIterativ);

        int[][] A = {{4, 4}, {5, 7}};
        int[][] B = {{5, 3}, {2, 9}};
        int[][] C = ProdusulMatricelor.produsulMatricelor(A, B);
        System.out.println("Produsul matricelor= " + Arrays.deepToString(C));

        int prod = InmultireRusse(1546, 5642);
        System.out.println("Inmultirea a la russe= " + prod);

    }

    public static void Insertie(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
    }


    public static void SortareSelectieMinim(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            int minVal = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minVal) {
                    minIdx = j;
                    minVal = arr[j];
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public class Euclid {
        public static int euclid(int m, int n) {
            while (n != 0) {
                int temp = n;
                n = m % n;
                m = temp;
            }
            return m;
        }
    }

    public class FibonacciRecursiv {
        public static int fibo(int n) {
            if (n < 2) {
                return n;
            } else {
                return fibo(n - 1) + fibo(n - 2);
            }
        }
    }

    public class FibonaccIterative {
        public static int fiboIterativ(int n) {
            int i = 0, j = 1;
            for (int k = 1; k <= n; k++) {
                int temp = j;
                j += i;
                i = temp;
            }
            return i;
        }
    }

    public class ProdusulMatricelor{
        public static int[][] produsulMatricelor (int[][] A, int[][] B) {
            int m = A.length;
            int n = A[0].length;
            int p = B[0].length;
            int[][] C = new int[m][p];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < p; j++) {
                    for (int k = 0; k < n; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            return C;
        }
    }

    public static int InmultireRusse(int a, int b) {
        int[] X = new int[100];
        int[] Y = new int[100];

        X[0] = a;
        Y[0] = b;

        int i = 0;
        while (X[i] > 1) {
            X[i + 1] = X[i] / 2;
            Y[i + 1] = Y[i] + Y[i];
            i++;
        }

        int prod = 0;
        while (i >= 0) {
            if (X[i] % 2 == 1) {
                prod += Y[i];
            }
            i--;
        }

        return prod;
    }

}