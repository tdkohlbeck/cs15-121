/* Array Quiz

1. 2 and 4 (or none?)
2. 0
3. 1
4. 2
5. "CMU"
6. unknown, a is a reference to the array, and therefore foobar could modify the array.
7. "{1, 2, 3, 4, 5"
8. false; true x3;
9.
*/

import java.util.*;

public class Quiz {
	public static int guestsUntilMatchFound() {
		Random rand = new Random();
		ArrayList<Integer> party = new ArrayList<Integer>();
		party.add(rand.nextInt(365));
		while(true) {
			int guests = party.size();
			int guestBirthday = rand.nextInt(365);
			boolean match = false;
			for(int i = 0; i < guests; i++) {
				if (party.get(i) == guestBirthday) {
					match = true;
				}
			}
			if (match == true) {
				return guests;
			}
			party.add(guestBirthday);
		}
	}
	public static void main(String[] args) {
		int count = 1, totalGuests = 1;
		float avg = 0;
		while(count < 1000000) {
			count++;
			int guestCount = guestsUntilMatchFound();
			totalGuests += guestCount;
			avg = (float) totalGuests / count;
		}
		System.out.println("Simulations: " + count);
		System.out.println("Average: " + avg + "\n----------------------------------");

	}
}
