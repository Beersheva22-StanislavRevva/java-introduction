import java.util.concurrent.ThreadLocalRandom;

//ДЗ - нужно написать аппликацию, которая печатает случайные числа от 1 до 49 (6 неповторяющихся чисел) и их вывести на консоль.

public class SportLotoApp {

	public static long mask = 0;
	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive
	 * numbers can not be repeated in a sequence of 6 random numbers;
	 */
	
	public static void main(String[] args) {
	//TODO Auto-generated method stub

	for (int i=0; i < 6; i++) {
			
	System.out.print(getUniqueRandomInt(1, 9) + " ");
			
	}
	}
public static int getUniqueRandomInt(int min, int max) {
	int res = 0;
	do {
		res = (int) (min + Math.random() * (max - min -1));
	} while (BitOperations.getBitValue(mask, res) == 1);
	mask = BitOperations.setBitValue(mask, res, true);	
	return res;
	}
	
}
	