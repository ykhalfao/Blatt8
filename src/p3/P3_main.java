package p3;

import java.util.Arrays;

public class P3_main {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] Array1 = {3, -1, 5};
        int[] Array2 = {2,  6, 0};

        int[] AusgabeA = elementwiseMultiply(arr1, arr2);
        System.out.println(Arrays.toString(AusgabeA));

        boolean AusgabeB = areOrthogonal(Array1,Array2);
        System.out.println(AusgabeB);
    }

    public static int[] elementwiseMultiply(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return new int[]{};
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] * arr2[i];
        }
        return result;
    }

    public static boolean areOrthogonal(int[] arr1, int[] arr2){
        if (arr1.length != arr2.length){
            return false;
        }
        int[] multiplied = elementwiseMultiply(arr1, arr2);
        int sum = 0;
        for(int i = 0; i < multiplied.length; i++){
            sum = sum + multiplied[i];
        }
        return sum == 0;
    }
}

