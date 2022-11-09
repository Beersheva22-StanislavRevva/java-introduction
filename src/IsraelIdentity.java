import java.util.Arrays;

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
	int separatedId[];
	int sum = 0;
	if (Numbers.getNdigits(id) == idNumberDigits) {
		separatedId = Numbers.getDigits(id);
		for(int i = 0; i < idNumberDigits; i++) {
			if (i % 2 > 0) {
				if (separatedId[i] > 4)
					{
					sum += ((separatedId[i] * 2) % 10 + 1);
					}
				else sum += separatedId[i] * 2;
		 	}
			else sum += separatedId[i];
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
int separatedIdRandom [] = new int [1];
int sum = 0;
int id = 0;
int random = 0;
int minDigit = 0;
int maxDigit = 9;

for(int i = 0; i < (idNumberDigits - 1); i++) {
random = (int) ((minDigit + Math.random() * (maxDigit - minDigit -1)));
separatedIdRandom [separatedIdRandom.length - 1] = random;
separatedIdRandom = Arrays.copyOf(separatedIdRandom, (separatedIdRandom.length + 1));
}

while (separatedIdRandom[0] == 0) {
	random = SportLotoApp.getUniqueRandomInt(0,10);
	separatedIdRandom[0] = random;
}

for(int i = 0; i < (idNumberDigits - 1); i++) {
	if (i % 2 > 0) {
		if (separatedIdRandom[i] > 4)
			sum += ((separatedIdRandom[i] * 2) % 10 + 1);
			
		else sum += separatedIdRandom[i] * 2;
	}	
	else sum += separatedIdRandom[i];
	}

if ((sum % 10) > 0)
	separatedIdRandom[(idNumberDigits - 1)] =(10 - (sum % 10));

id = Numbers.getNumberFromDigits(separatedIdRandom);

/*for(int i=0; i < (idNumberDigits); i++) {
	id = (id * 10 + separatedIdRandom[i]);
}
*/	
return id;
}
	
}
