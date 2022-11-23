
public class Strings {
	
/*
 * @param str1;
 * @param str2;
 * @return true if str2 is an anagram of str1
 * complexity O[N], 2 passes
 * 1. the same length
 * 2. the same symbol just in different order
 */
	
public static boolean isAnagram(String str, String anagram) {
	boolean res = false;
	if (str.length() == anagram.length()) {
		int charRange = Byte.MAX_VALUE;
		int helper[] = new int [charRange];
		res = true;
		fillHelper(helper, str);
		int index = 0;
		int length = str.length();
		while(index < length && res) {
			int indSymb = (int)anagram.charAt(index);
			if (helper[indSymb] == 0) {
				res = false;
			} else {
				helper[indSymb]--;
				index++;
			}
				{
			}
		}
	}
	
	return res;
}

	private static void fillHelper(int[] helper,String str) {
	int length = str.length();
	for(int i = 0; i < length; i++) {
		int ind = str.charAt(i);
		helper[ind]++;
	}
}

/**
 * 
 * @param str - array of references to string objects,each string contains decimal presentation of a number from Byte.MIN_VALUE to Byte.MAX_VALUE
 * @return str - sorts input array on the place 
 */


public static String [] sortStringNumbers1(String[] str) {
	int numberRange = 256;
	byte helper[] = new byte [numberRange];
	int i = 0;
	int j = 0;
	for (i = 0; i < str.length; i++) {
		helper[Byte.parseByte(str[i])+128]++;
	}
	for (i = 0; i < helper.length; i++) {
		while (helper[i] > 0) {
	        str[j] = String.valueOf(i-128);
	        j++;
	        helper[i]--;
		}
	}
	return str;
}

/**
 * 
 * @param str - array of references to string objects,each string contains decimal presentation of a number from Byte.MIN_VALUE to Byte.MAX_VALUE
 * @return str - sorts input array on the place 
 */

public static void sortStringNumbers(String[] str) {
	int offset = Byte.MAX_VALUE + 1;
	int helper[] = new int[offset * 2];
	fillHelper(helper, str, offset);
	sortFromHelper(str,helper, offset);
}

private static void sortFromHelper(String[] str, int[] helper, int offset) {
	int arrayInd = 0;
	for(int i=0; i < helper.length; i++) {
		for(int j=0; j < helper[i]; j++) {
			str[arrayInd++] = getStringNumberFromIndex(i, offset);
		}
	}
}

private static String getStringNumberFromIndex(int index, int offset) {
	int number = index - offset;
	return Integer.toString(number);
}

private static void fillHelper(int[] helper, String[] str, int offset) {
	for(int i = 0; i < str.length; i++) {
		int index = getIndexFromStringNumber(str[i], offset);
		helper[index]++;
	}
	
}

private static int getIndexFromStringNumber(String str, int offset) {
	int number = Integer.parseInt(str);
	return 0;
}

public static String javaNameExp() {
	
	return "[a-zA-Z$][\\w$]*|_[\\w$]+";
}

public static String ip4Octe() {
	
	return "([0-1][0-9][0-9])|(2[0-5][0-5])";
}

public static String ipV4() {
	return "((([0-1]\\d{2})|(2[0-5]{2}))\\.){3}(([0-1]\\d{2})|(2[0-5]{2}))";
}


}
