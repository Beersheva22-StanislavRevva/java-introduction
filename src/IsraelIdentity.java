
public class IsraelIdentity {

private static int idNumberDigits = 9;
	
/**
 * 	
 * @param id
 * @return true for right id otherwise false
 * control sum should be multiple of 10 (dividing for 10 with no remainder sum %10 == 0) )
 * for even indexes (0, 2, 4, 6, 8) digits as is 
 * for odd indexes (1, 3, 5, 9) digit = digit * 2, if > 9 then sum of inner digits is taken
 * example, 123456782 => 1 + 4 + 3 + 8 + 5 + 3 (6*2=12, 1+2 = 3) + 7 + 7 (8*2=16, 1+6 = 7) + 2 = 40 true
 */
	
	
public static boolean verify(int id) {
	//TODO
	int res1[];
	int sum = 0;
	if (Numbers.getNdigits(id) == idNumberDigits) {
		res1 = Numbers.getDigits(id);
		for(int i = 0; i < idNumberDigits; i++) {
			if (i % 2 > 0) {
				if (res1[i] > 4)
					{
					res1[i] = ((res1[i] * 2) % 10 + 1);
					}
				else res1[i] = res1[i] * 2;
		 	}
		 sum += res1[i];
		 }
			
		if (sum %10 == 0) 
			return true;
		
		else return false;
	}
	else return false;
}


/**
 * 
 * @return random number of 9 digits matching right Israel id
 * cycle not more than 9 iterations
 * 
 */


public static int generateRandomId() {
	
return 0;
}
	
}
