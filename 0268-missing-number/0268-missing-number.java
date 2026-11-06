class Solution {

    public void swap(int[] arr, int i, int idx) {
        int temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }

    public int missingNumber(int[] arr) {
       int i = 0;
        while (i < arr.length) {
            if (arr[i] == arr.length || arr[i] == i) {
                i++;
            } else {
                int idx = arr[i];
                if (arr[i] != arr[idx]) {
                    swap(arr, i, idx);
                } else {
                    i++;
                }
            }
        }

        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return i;
            }
        }

        return arr.length;
    }
}