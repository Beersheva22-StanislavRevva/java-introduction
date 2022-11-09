
public class Numbers {

private static int N_HAPPY_NUMBER_DIGITS = 6;
	
static public int getNdigits(long number) {
	int res = 0;
	do {
		number /= 10;
		res++;
	} while(number !=0);
	return res;
}

/**
 * 
 * @param number
 * @return true only if number comprises of 6 digits
 * and sum of first three digits equals the sum of last three digits
 * check by the test;
 */


static public boolean isHappyNumber(long number) {
	// if (number >= 100000 ||  number <= 999999) {
	if (getNdigits(number) == N_HAPPY_NUMBER_DIGITS) {
		
		
		
		
			int resRight = 0;
			for (int i = 0; i < (N_HAPPY_NUMBER_DIGITS / 2); i++) {
			resRight += (number % 10);
			number /= 10;
			}
			int resLeft = 0;
			for (int i = (N_HAPPY_NUMBER_DIGITS / 2); i < (N_HAPPY_NUMBER_DIGITS); i++) {
				resLeft += (number % 10);
				number /= 10;
				}
			if (resRight == resLeft)
			return true;
		
			else return false;
	}
	else return false;
	}

	public static int[] getDigits(int number) {
		int res[] = new int[getNdigits(number)];
		for(int i = res.length - 1; i >= 0; i--) {
			res[i] = number %10;
			number /=10;
		}
		return res;
	}

	public static int getNumberFromDigits(int[] digits) {
	int res = 0;
	for(int i=0; i < digits.length; i++) {
		res = res * 10 + digits[i];
	}
		
		return res;
	}
}


//ДЗ - Счастливый билет - возвращается true если номер 6ти значный и сумма 3х первых цифр равна сумме 3х последних
//без коллекций и массивов

//ДЗ - 
