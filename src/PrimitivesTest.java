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
	void digitsNumberTest () {
	long number = 0xab7f5;
	assertEquals(14, BitOperations.onesInNumber(number));
	number = 0x1;
	assertEquals(1, BitOperations.onesInNumber(number));
	}	
		
	@Test
	void leadingZerosTest () {
	long number = 0xab7f5;
	assertEquals(44, BitOperations.leadingZeros(number));
	number = 0x1;
	assertEquals(63, BitOperations.leadingZeros(number));
	}
	
	@Test
	void isHappyNumberTest() {
	int number = 111111;
	assertEquals(true, Numbers.isHappyNumber(number));
	number = 560803;
	assertEquals(true, Numbers.isHappyNumber(number));
	number = 111801;
	assertEquals(false, Numbers.isHappyNumber(number));
	}
	
}
	
