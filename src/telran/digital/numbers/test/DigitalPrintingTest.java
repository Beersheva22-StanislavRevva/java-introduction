package telran.digital.numbers.test;

import org.junit.jupiter.api.*;
import static telran.digital.numbers.DigitalNumbersPrinting.*;

public class DigitalPrintingTest {
@Test
@Disabled
void lineTest() {
	System.out.println(line(30, 30));
}
@Test
@Disabled
void verticalLineTest () {
	displayStrings(verticalLineRight(30, 20, 5));
}
@Test
@Disabled
void twoVerticalLinesTest() {
	displayStrings(twoVerticalLines(30,10,5));
}
@Test
@Disabled
void zeroTest() {
	displayStrings(zero(30, 5, 4));
}
@Test
void displayDigitalNumberTest() {
	displayDigitalNumber(1234567890, 3, 10, 10);
	displayDigitalNumber(1234567890, 3, 2, 4);
}

}
