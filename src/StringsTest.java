import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StringsTest {
String word="yellow";
	@Test
	@Disabled
	void sortStringsNumbersTest() {
		String str[] = {"127", "-128", "0", "25", "25", "-128", "127"};
		String expected[] = {"-128", "-128", "0", "25", "25", "127", "127"};
		Strings.sortStringNumbers(str);
		assertArrayEquals(expected, str);
	}
	@Test
	@Disabled
	void isAnagramTest() {
		
		assertTrue(Strings.isAnagram(word, "loweyl")); 
		assertTrue(Strings.isAnagram(word, "elolyw")); 
		assertTrue(Strings.isAnagram(word, "wolley")); 
		assertTrue(Strings.isAnagram(word, "loleyw")); 
		assertTrue(Strings.isAnagram("yttttoooo", "ooootttty"));
		assertFalse(Strings.isAnagram(word,"")); 
		assertFalse(Strings.isAnagram(word, "yellob")); 
		assertFalse(Strings.isAnagram(word,"yello")); 
		assertFalse(Strings.isAnagram(word,"yelllo")) ;
		assertFalse(Strings.isAnagram(word, "wolkez"));
		assertFalse(Strings.isAnagram(word, "yeooow"));
		assertFalse(Strings.isAnagram("yttttoooo", "yoootttty"));
	}

@Test
void javaVariableTest() {
		assertTrue("java".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertTrue("$".matches(Strings.javaNameExp()));
		assertFalse("$ _".matches(Strings.javaNameExp()));
}

@Test
void ip4OcteTest() {
	assertTrue("000".matches(Strings.ip4Octe()));
	assertTrue("255".matches(Strings.ip4Octe()));
	assertFalse("256".matches(Strings.ip4Octe()));
	assertFalse("311".matches(Strings.ip4Octe()));
}

@Test
void ipV4() {
	assertTrue("000.168.001.000".matches(Strings.ipV4()));
	assertTrue("000.168.001.000".matches(Strings.ipV4()));
	assertFalse("256.168.001.000".matches(Strings.ipV4()));
	assertFalse("311.168.001.000".matches(Strings.ipV4()));
}

}


