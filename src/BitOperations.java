
/**
 * right nBit value [0 - 63]
 * All methods will return -1 in the case of wrong nBit value
 *
 */

public class BitOperations {
	
/**	
*	
* @param number - any number	
* @param nBit - number of bit
* @return value of bit with number nBit
*/

private static boolean checkNbit (int nBit) {

return nBit < 64 && nBit > -1;
}
	
	
static public int getBitValue(long number, int nBit) {

int res = -1;
	if (checkNbit (nBit)) {
	long mask = 1 << nBit; //all bits are 0, exept bit with number n Bit
	if ((number & mask) == 0) {
		res = 0;
}	else {res = 1;
}
}
return res;
}


/**	
*	
* @param number - any number	
* @param nBit - bit number
* @return value - true for 1, false for 0
* @return number in witch value of nBit'h bit will have a given value
*/


static public long setBitValue(long number, int nBit, boolean value) {
	//TODO
	
long res = -1;
	if (checkNbit (nBit)) {
		if (value == false) {
			long mask = 1 << nBit; //all bits are 0, exept bit with number n Bit
			res = number ^ mask; //
		}
		else {res = number;
		}
	}
	return res;
}
			
	




/**	
*	
* @param number - any number	
* @param nBit - bit number
* @return new number in which nBit'h will be reverted (old value - 1, new value - 0)
*/

static public long revertBitValue(long number, int nBit)
{
	
	//TODO	
	
	long res = number;
	if (checkNbit (nBit)) {
	long mask = 1 << nBit; //all bits are 0, exept bit with number n Bit
	res = number ^ mask; //revert n Bit
}	
return res;
}
	
}
