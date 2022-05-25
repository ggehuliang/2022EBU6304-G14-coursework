package main.utils;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.HashMap;

public class BookingNoTest {

	@Test
	public void test() {
		DataService dataService = new DataService();
		HashMap<String, Boolean> testCases = new HashMap<>();
		testCases.put("A #a", false);
		testCases.put("Aaaa", false);
		testCases.put("12#34", false);
		testCases.put("1234", false);
		testCases.put("a12 #", false);
		testCases.put("ab23", false);
		testCases.put("Ab# de", false);
		testCases.put("Abcde", false);
		testCases.put("123 45", false);
		testCases.put("12345", false);
		testCases.put("a12 #34", false);
		testCases.put("Ab12345", true);
		testCases.put("Ab#cdefghijkl", false);
		testCases.put("Abcdefghijkl", false);
		testCases.put("12345##67890", false);
		testCases.put("1234567890", false);
		testCases.put("Ab12##3456789", false);
		testCases.put("Ab123456789", false);

		testCases.forEach((key, value) -> {
			assertEquals(value, dataService.verifyBookingNumber(key));
		});
	}

}
