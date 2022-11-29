package telran.text;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;



class ObjectTests {

	@Test
	void wrapperTest() {
		Integer a = 11;
		
		Integer b = 11;
		assertEquals(a, b);
		Integer c = 201;
		Integer d = 201;
		assertEquals(c, d);
		assertTrue(a == b);
		assertFalse(c == d);
		assertTrue(c.equals(d));
	}
	@Test
	void stringTest() {
		String hello = "hello";
		char[] helloAr = hello.toCharArray();
		assertEquals('h', helloAr[0]);
		System.out.println((byte)helloAr[0]);
		assertEquals(5, hello.length());
	}
	@Test
	void isAnagramTest() {
		String str = "yellow";
		assertTrue(Strings.isAnagram(str, "loweyl"));
		assertTrue(Strings.isAnagram(str, "elolyw"));
		assertTrue(Strings.isAnagram(str, "wolley"));
		assertTrue(Strings.isAnagram(str, "loleyw"));
		assertFalse(Strings.isAnagram(str,""));
		assertFalse(Strings.isAnagram(str, "yellob"));
		assertFalse(Strings.isAnagram(str,"yello"));
		assertFalse(Strings.isAnagram(str,"yelllo"));
	}
	
	@Test
	@Disabled
	void sortStringNumbers () {
	String[] str = {"127", "18", "1", "1", "-1"};
	Strings.sortStringNumbers(str);
	assertArrayEquals(new String[] { "-1", "1", "1", "18", "127"}, str);
	
	}
}
