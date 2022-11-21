
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
	char[] strAr = str.toCharArray();
	char[] anagramAr = anagram.toCharArray();
	int charRange = 256;
	boolean helper[] = new boolean [charRange];
	int count = 0;
	boolean res = false;
	if (strAr.length == anagramAr.length) {
		for (int i = 0; i < strAr.length; i++) {
			helper[(byte)strAr[i]] = !helper[(byte)strAr[i]];
			helper[(byte)anagramAr[i]] = !helper[(byte)anagramAr[i]];
			
		}
		for (int i = 0; i < strAr.length; i++) {
			if (helper[(byte)anagramAr[i]] == true) {
				count++;	
			}
		}
		if (count == 0) {
			res = true;
		}
		
	}
	return res;
}

/**
 * 
 * @param str - array of references to string objects,each string contains decimal presentation of a number from Byte.MIN_VALUE to Byte.MAX_VALUE
 * @return str - sorts input array on the place 
 */


public static String [] sortStringNumbers(String[] str) {
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

}
