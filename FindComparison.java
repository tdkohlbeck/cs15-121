import java.util.*;

public class FindComparison {
	private static int ARRAY_SIZE = 10000;
	private static int TRIALS = 10000;
	private static Random rand = new Random();

	public static void main(String[] args) {
		float totalSeqTick = 0, totalRandTick = 0;
		float totalSeqTime = 0, totalRandTime = 0;
		float avgSeqTick = 0, avgRandTick = 0, avgSeqTime = 0, avgRandTime = 0;

		for (int i = 1; i <= TRIALS; i++) {
			int[] array = createRandomArray(ARRAY_SIZE);
			Trial results = new Trial(array);
			totalSeqTick += results.seqTick;
			totalRandTick += results.randTick;
			totalSeqTime += results.seqTime;
			totalRandTime += results.randTime;
			avgSeqTick = totalSeqTick / i;
			avgRandTick = totalRandTick / i;
			avgSeqTime = totalSeqTime / (float) i;
			avgRandTime = totalRandTime / (float) i;
			if (i % 1000 == 0) System.out.print(".");

			//System.out.println("Trial: " + i);
			//System.out.println("Sequential Access Find Iteration: " + results.seqTick);
			//System.out.println("Random Access Find Iteration: " + results.randTick);
			//System.out.println("Sequential Access Find Time: " + results.seqTime);
			//System.out.println("Random Access Find Time: " + results.randTime);
		}
		System.out.println("\n_____________________________________");
		System.out.println("Sequential Access Average Find Iteration: " + avgSeqTick);
		System.out.println("Random Access Average Find Iteration: " + avgRandTick);
		System.out.println("Sequential Access Average Find Time: " + avgSeqTime);
		System.out.println("Random Access Average Find Time: " + avgRandTime);
		System.out.println("Ratio of seq-iter / rand-iter: " + avgSeqTick / avgRandTick);
	}

	private static int[] createRandomArray(int arraySize) {
		boolean[] hasAppeared = new boolean[arraySize];
		int[] searchArray = new int[arraySize];
		int num;

		for (int i = 0; i < arraySize; i++) {
			do {
				num = rand.nextInt(arraySize);
			} while (hasAppeared[num] != false);

			searchArray[i] = num;
			hasAppeared[num] = true;
		}

		return searchArray;
	}

	private static class Trial {
		public int[] array;
		public int seqTick;
		public long seqTime;
		public int randTick;
		public long randTime;

		public Trial(int[] array) {
			this.array = array;

			int find = rand.nextInt(ARRAY_SIZE);
			findSequential(find, true);
			findRandom(find, true);
		}


		private void findSequential(int find, boolean uniqueOnly) {
			boolean[] hasAppeared = new boolean[ARRAY_SIZE];
			long t1, t2;
			int tick;
			int num;
			t1 = System.currentTimeMillis();
			for (tick = 0; tick < ARRAY_SIZE; tick++) {
				num = rand.nextInt(ARRAY_SIZE);
				if (uniqueOnly) {
					while (hasAppeared[num] != false) num = rand.nextInt(ARRAY_SIZE);
					hasAppeared[num] = true;
				}
				if (array[tick] == find) break;

			}
			t2 = System.currentTimeMillis();
			seqTick = tick;
			seqTime = (t2 - t1);
		}

		private void findRandom(int find, boolean uniqueOnly) {
			boolean[] hasAppeared = new boolean[ARRAY_SIZE];
			long t1, t2;
			int tick, num;
			t1 = System.currentTimeMillis();
			for (tick = 0; tick < ARRAY_SIZE; tick++) {
				num = rand.nextInt(ARRAY_SIZE);
				if (uniqueOnly) {
					while (hasAppeared[num] != false) num = rand.nextInt(ARRAY_SIZE);
					hasAppeared[num] = true;
				}
				if (array[num] == find) break;

			}
			t2 = System.currentTimeMillis();
			randTick = tick;
			randTime = (t2 - t1);
		}
	}
}
