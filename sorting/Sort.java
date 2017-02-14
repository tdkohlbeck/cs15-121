public class Sort { // (1)

	public static int[] selection(int[] arr) { // (2)
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) min = j;
			}
			int tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;
		}
		return arr;
	}

	public static int[] merge(int[] arr) {
		int len = arr.length;
		if (len <= 1) return arr;

		int half = len / 2;
		int[] l = new int[half];
		int[] r = new int[len - half];

		for (int i = 0; i < half; i++) {
			l[i] = arr[i];
		}
		for (int i = half; i < len; i++) {
			//System.out.println("assigning " + arr[i] + " to index " + (i-half) + "/" + r.length);
			r[i-half] = arr[i];
		}

		int[] lSorted = new int[half];
		int[] rSorted = new int[len - half];
		lSorted = merge(l);
		rSorted = merge(r);

		int lScout = 0;
		int rScout = 0;
		int[] sorted = new int[len];

		for (int i = 0; (lScout < half && rScout < len-half); i++) {
			System.out.println(rScout);
			if (lSorted[lScout] < rSorted[rScout]) {
				sorted[i] = lSorted[lScout];
				lScout++;
			} else {
				sorted[i] = rSorted[rScout];
				rScout++;
			}
		}

		return sorted;
	}

	public static String toString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (int i : arr) sb.append(i + " ");
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] arr = {7, 8};
		Sort sort = new Sort();
		//System.out.println(sort.toString(sort.selection(arr)));
		System.out.println(sort.toString(sort.merge(arr)));
	}
}
/*
LESSONS:
(1) public outer class cannot be static?
(2) constructor also cannot be static
*/
