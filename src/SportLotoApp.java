import java.util.concurrent.ThreadLocalRandom;

//ДЗ - нужно написать аппликацию, которая печатает случайные числа от 1 до 49 (6 неповторяющихся чисел) и их вывести на консоль.

public class SportLotoApp {

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive
	 * numbers can not be repeated in a sequence of 6 random numbers;
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print(" "+ 100 + " " + 200);
		for (int i=0; i < 6; i++) {
			
			int current = getRandomInt(1, 49) ^ getRandomInt(1, 49);
					
			
			System.out.print(current + " ");
			
			//System.out.print(getRandomInt(1, 49) + " ");
			//System.out.print(ThreadLocalRandom.current().nextInt(1,49) + " ");
		}
	}
	public static int getRandomInt(int min, int max) {
	return (int) (min + Math.random() * (max - min +1));
	}
	
	//public static int getRandomInt2(int min, int max) {
	//return (int) (min + Math.random() * (max - min -1));
	//}
}
	