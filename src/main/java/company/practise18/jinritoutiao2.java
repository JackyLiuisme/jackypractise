package company.practise18;

public class jinritoutiao2 {
    public static void main(String[] args) {
        int [] array = {1,2,3,3,3,4,4,5,6,6,7,8};
        int i = BinarySearchMax(array, 5);
        System.out.println(i);
    }
    static int BinarySearchMax(int [] data, int target)

    {

        int left = 0;

        int right = data.length;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (data[mid] <= target)

                left = mid + 1;
            else
                right = mid - 1;

        }

        if (data[right] == target)

            return right;

        return -1;

    }
}
