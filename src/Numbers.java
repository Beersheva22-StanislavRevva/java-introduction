
public class Numbers {

private static int numberComprises = 6;
	
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
	if (getNdigits(number) == numberComprises) {
			int resRight = 0;
			for (int i = 0; i < (numberComprises / 2); i++) {
			resRight += (number % 10);
			number /= 10;
			}
			int resLeft = 0;
			for (int i = (numberComprises / 2); i < (numberComprises); i++) {
				resLeft += (number % 10);
				number /= 10;
				}
			if (resRight == resLeft)
			return true;
		
			else return false;
	}
	else return false;
}

}

//ДЗ - Счастливый билет - возвращается true если номер 6ти значный и сумма 3х первых цифр равна сумме 3х последних
//без коллекций и массивов
