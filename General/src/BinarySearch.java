class BinarySearch {

    public static int BinarySearch(int arr[], int left, int right, int key) {

        if (right >= left) {

            int MidElement = left + (right - left) / 2;
            if (arr[MidElement] == key) // If the required element is found at the middle index
                return MidElement;

            if (key < arr[MidElement]) // If the required element is smaller than the element at the middle index  It can only be present in the left subarray
                return BinarySearch(arr, left, MidElement - 1, key);

            return BinarySearch(arr, MidElement + 1, right, key); // else, it would be present in the right subarray
        }
        return -1; // Element not found, and the array can not be further divided.
    }

    public static void main(String args[]) {

        int arr[] = { 3, 5, 7, 15, 25 };

        int key = 7; // to find, feel free to change this
        int result = BinarySearch(arr, 0, arr.length - 1, key);

        if (result != -1)
            System.out.println("Key " + "\"" + key + "\" found at index = " + result);
        else
            System.out.println("Key " + "\"" + key + "\"not found!");

        key = 0; // Trying for a different value
        result = BinarySearch(arr, 0, arr.length - 1, key);

        if (result != -1)
            System.out.println("Key " + "\"" + key + "\" found at index = " + result);
        else
            System.out.println("Key " + "\"" + key + "\"not found!");

    }
}
