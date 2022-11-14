import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


class PrimitivesTest {

	
	
	@Test
	@Disabled
	void DataTypetest() {
		int b = 10;
		short a = 20000;
		char c = 'd';
		long l = (long)10.1;
		byte b1 = (byte) 1000;
		a = (short) l;
		float f = 10.2f;
		int b2 = 0xfffffff1;
		
		assertEquals(-15, b2);
	}
		
	@Test
	@Disabled
	void operatorstest() {
		int a=10;
		assertEquals(13, a+3);
		assertEquals(1, a % 3);
		int number = 123;
		assertEquals(3, getThirdDigit(number));
		assertEquals(2, getSecondDigit(number));
		assertEquals(1, getFirstDigit(number));
	}
	
// Assumption: all three methods take number containing of three
	private int getFirstDigit(int number) {
		
		return number / 100 %10;
		
	}
	private int getSecondDigit(int number) {
		
		return number / 10 %10;
		
	}
	private int getThirdDigit(int number) {
		
		return number %10;
	}
	
	@Test
	@Disabled
	void getBitValueTest() {
		long number = 0xab7f5; //001110101011011111_1_10101
		assertEquals(1, BitOperations.getBitValue(number, 5));
		assertEquals(0, BitOperations.getBitValue(number, 11));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 2));
		assertEquals(-1, BitOperations.getBitValue(number, -2));
	}
	
	@Test
	@Disabled
	void setBitValueTest() {
		long number = 0xab7f5; //001110101011011111_1_10101
		assertEquals(0xab7d5, BitOperations.setBitValue(number, 5, false));
		assertEquals(0xab7f5, BitOperations.setBitValue(number, 5, true));
		
	}
	
	@Test
	@Disabled
	void revertBitValueTest() {
		long number = 0xab7f5; //001110101011011111_1_10101
		assertEquals(0xab7d5, BitOperations.invertBitValue(number, 5));
		assertEquals(0xab7f4, BitOperations.invertBitValue(number, 0));
	}
	
	@Test
	@Disabled
	void checkNumber() {
		long number = -1;
		assertEquals(1, BitOperations.getBitValue(number, 63));
		number = BitOperations.invertBitValue(number, 63);
		assertEquals(0, BitOperations.getBitValue(number, 63));
	}

	//ДЗ - написать 3 теста по функциям из Numbers.java + апликация Спортлото
	
	@Test
	@Disabled
	void digitsNumberTest () {
	long number = 0xab7f5;
	assertEquals(14, BitOperations.onesInNumber(number));
	number = 0x1;
	assertEquals(1, BitOperations.onesInNumber(number));
	}	
		
	@Test
	@Disabled
	void leadingZerosTest () {
	long number = 0xab7f5;
	assertEquals(44, BitOperations.leadingZeros(number));
	number = 0x1;
	assertEquals(63, BitOperations.leadingZeros(number));
	}
	
	@Test
	@Disabled
	void isHappyNumberTest() {
	int number = 111111;
	assertTrue(Numbers.isHappyNumber(number));
	number = 560803;
	assertTrue(Numbers.isHappyNumber(number));
	number = 111801;
	assertFalse(Numbers.isHappyNumber(number));
	}
	
	@Test
	@Disabled
	void getDigitsTest() {
		int expected[] = {1, 2, 3, 4};
		assertArrayEquals(expected,Numbers.getDigits(1234));
	}
	@Test
	@Disabled
	void getNumberFromDigitsTest() {
		int expectedNumber = 1234;
		
		assertEquals(expectedNumber, Numbers.getNumberFromDigits(new int[]{1, 2, 3, 4}));
	}
	
	@Test
	@Disabled
	void VerifyNumberTest() {
	int id = 134572684;
	assertTrue(IsraelIdentity.verify(id));
	id = 123456783;
	assertFalse(IsraelIdentity.verify(id));
	id = 12344;
	assertFalse(IsraelIdentity.verify(id));
	}
	
	@Test
	@Disabled
	void generateRandomIdTest() {
	int id = IsraelIdentity.generateRandomId();
	assertTrue(IsraelIdentity.verify(id));
	}
	
	@Test
	void binarySearchRepeatedNumberTest() {
	int	 ar1[] = { 1, 1, 1 };
	int	 ar2[] = { 1, 2, 3, 4, 5, 6, 7, 10, 10, 10, 10 };
	int number = 1;
	int expectedIndex = 0;
	assertEquals(expectedIndex, MyArrays.binarySearchRepeatedNumber(ar1, number));
	number = 10;
	expectedIndex = 7;
	assertEquals(expectedIndex, MyArrays.binarySearchRepeatedNumber(ar2, number));
	}
	
	@Test
	void isOneSwapTestFalse() {
	int ar1[] = { 1, 2, 3, 10, 1, 5, 6 };
	int ar2[] = { 1, 2, 3, 4, 5, 10 };
	int ar3[] = { 5, 1, 2, 4, 6, 10 };
	int ar4[] = { 1, 5, 2, 4, 3, 10 };
	int ar5[] = { 1, 3, 2, 5, 4, 10, 8 };
	int ar6[] = {1, 3, 20, 4, 5, 6, 10};
	int ar7[] = {1, 3, 20, 4, 5, 11, 2};
	assertFalse(MyArrays.isOneSwapForSorted(ar1));
	assertFalse(MyArrays.isOneSwapForSorted(ar2));
	assertFalse(MyArrays.isOneSwapForSorted(ar3));
	assertFalse(MyArrays.isOneSwapForSorted(ar4));
	assertFalse(MyArrays.isOneSwapForSorted(ar5));
	assertFalse(MyArrays.isOneSwapForSorted(ar6));
	assertFalse(MyArrays.isOneSwapForSorted(ar7));

	}

	@Test
	void isOneSwapTestTrue() {
	int ar1[] = { 10, 2, 3, 4, 1 };
	int ar2[] = { 1, 2, 4, 3, 5, 10 };
	int ar3[] = { 1, 2, 3, 10, 5, 4 };
	int ar4[] = { 1, 5, 3, 4, 2, 10 };
	int ar5[] = { 1, 2, 3, 4, 10, 5 };
	int ar6[] = { 2, 1, -3, 4, 5, 10 };
	int ar7[] = { 3, 2, 1, 4, 5, 6 };
	assertTrue(MyArrays.isOneSwapForSorted(ar1));
	assertTrue(MyArrays.isOneSwapForSorted(ar2));
	assertTrue(MyArrays.isOneSwapForSorted(ar3));
	assertTrue(MyArrays.isOneSwapForSorted(ar4));
	assertTrue(MyArrays.isOneSwapForSorted(ar5));
	assertTrue(MyArrays.isOneSwapForSorted(ar6));
	assertTrue(MyArrays.isOneSwapForSorted(ar7));

	}
	
	@Test
	void bubbleSortTest() {
	
	int ar1[] = { 10, 2, 3, 4, 1 };
	int ar2[] = { 1, 2, 3, 4, 10 };
	
	assertArrayEquals(ar2, MyArrays.bubbleSort(ar1));
	}
	
}	

	
