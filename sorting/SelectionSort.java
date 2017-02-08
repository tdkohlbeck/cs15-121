public class SelectionSort { // (1)

	public SelectionSort(int[] arr) { // (2)
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) min = j;
			}
			int tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;
		}
		for (int i : arr) System.out.print(i + ", ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {4, 7, 23, 7, 9, 6, 3, 6, 5, 27};
		SelectionSort sort = new SelectionSort(arr);
	}
}
/*
LESSONS:
(1) public outer class cannot be static?
(2) constructor also cannot be static
*/
