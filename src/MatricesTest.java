import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MatricesTest {
@ Test
void transpTest() {
	int matrix[][] = {
			{1, 2},
			{3, 4},
			{4, 5}
	};
	int expected[][] = {
			{1,3,4},
			{2,4,5}
	};
	assertArrayEquals(expected, Matrices.transp(matrix));
}


@Test
void isSum2Test() {
short array[] = {1000,8,32767,1,14235};
short sum = 1001;
assertTrue(MyArrays.isSum2(array,sum));
sum = 1002;
assertFalse(MyArrays.isSum2(array,sum));
}

}