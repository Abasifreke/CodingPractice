import java.util.Arrays;

/**
 *
 * @author Arpit
 */
public class minSum {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 5, 7, 8, 11, 12, 12, 13, 16, 33, 60, 65, 101};

        new minSum().partition(arr);

    }

    public void partition(int[] arr) {

        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++)
        {
        	System.out.print(arr[i] + " ");
        }
        System.out.println("");

        int[] arr1 = new int[(int) Math.floor(arr.length / 2)];
        int[] arr2 = new int[(int) Math.ceil(arr.length / 2) + 1];

        int counter = 0;
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[counter++];
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[counter++];
        }

        int leftSum = sum(arr1);
        int rightSum = sum(arr2);
        int diff = Math.abs(leftSum - rightSum);

        int left = 0;
        int mid = arr1.length - 1;
        int right = arr2.length - 1;

        while ((left <= arr1.length - 1) && (right >= 0)) {
            int leftDif = ((leftSum - arr1[left]) + arr2[right]);
            int rghtDif = ((rightSum - arr2[right]) + arr1[left]);
            if (Math.abs(leftDif - rghtDif) <= diff) {
                leftSum = leftSum - arr1[left] + arr2[right];
                rightSum = rightSum - arr2[right] + arr1[left];
                diff = Math.abs(leftSum - rightSum);
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left++;
                right = arr2.length - 1;
            } else {
                if (Math.abs(leftDif - rghtDif) > diff) {
                    right--;
                }

            }

        }
        int arr1Sum = 0;
        int arr2Sum = 0;
        
        for (int a : arr1) {
            System.out.print(a + " ");
            arr1Sum += a;
        }
        System.out.println("");
        System.out.println(arr1Sum);
        

        for (int a : arr2) {
            System.out.print(a + " ");
            arr2Sum += a;
        }
        System.out.println("");
        System.out.println(arr2Sum);

    }

    private int sum(int[] arr) {
        int count = 0;
        for (int a : arr) {
            count += a;
        }

        return count;
    }

}