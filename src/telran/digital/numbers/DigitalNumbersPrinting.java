package telran.digital.numbers;

import static telran.digital.numbers.DigitalNumbersPrinting.line;

public class DigitalNumbersPrinting {

private static final String SYMBOL = "*";

public static void displayDigitalNumber(int number, int offset, int width, int height) {
int arrayDigits[] = getDigits(number);
String [] res = new String[height];
String [] current = new String[height];
if (width > 3 && height > 5 && offset > 0) {
res = digitToImage (arrayDigits[0], offset, width, height);
	for (int i = 1; i < arrayDigits.length; i++) {
		current = digitToImage (arrayDigits[i], offset, width, height);
		for (int j = 0; j < height; j++) {
			res [j] = res [j] + current [j]; 
		}
	}
}
else res = new String [] {"n/a"};
displayStrings (res);
}



public static String[] digitToImage (int digit, int offset, int width, int height) {
	String [] res = new String[height];
	switch(digit) {
	case 0: res = zero(offset, width, height);break;
	case 1: res = one(offset, width, height);break;
	case 2: res = two(offset, width, height);break;
	case 3: res = three(offset, width, height);break;
	case 4: res = four(offset, width, height);break;
	case 5: res = five(offset, width, height);break;
	case 6: res = six(offset, width, height);break;
	case 7: res = seven(offset, width, height);break;
	case 8: res = eight(offset, width, height);break;
	case 9: res = nine(offset, width, height);break;
	}
	return res;
}

public static String line (int offset, int length) {
		return " ".repeat(offset) + SYMBOL.repeat(length);
}

public static String[] verticalLineRight (int offset, int width, int height) {
	String [] res = new String[height];
	for(int i = 0; i < res.length; i++) {
		res[i] = " ".repeat(offset + (width - 1)) + SYMBOL;	
	}
	return res;
}

public static String[] verticalLineLeft (int offset,  int width, int height) {
	String [] res = new String[height];
	for(int i = 0; i < res.length; i++) {
		res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 1);	
	}
	return res;
}

public static String[] twoVerticalLines (int offset, int width, int height) {
	String [] res = new String[height];
	for (int i = 0; i < res.length; i++) {
		res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
	}
	return res;
}

public static String[] zero(int offset, int width, int height) {
	String [] res = new String[height];
	res[0] = line(offset, width);
	String [] lines = twoVerticalLines(offset, width, height -2);
	System.arraycopy(lines, 0, res, 1, lines.length);
	res[height - 1] = line(offset, width);
	return res;
}

public static String[] one(int offset, int width, int height) {
	return verticalLineRight(offset, height, width); 
}

public static String[] two(int offset, int width, int height) {
	String [] res = new String[height];
	res[0] = line(offset, width);
	String [] lines = verticalLineRight(offset, width, ((height-2) / 2) );
	System.arraycopy(lines, 0, res, 1, lines.length);
	res[lines.length + 1] = line(offset, width);
	String [] lines1 = verticalLineLeft(offset, width, ((height-3) / 2));
	System.arraycopy(lines1, 0, res, (lines.length + 2), lines1.length);
	res[height - 1] = line(offset, width);
	return res;
}

public static String[] three(int offset, int width, int height) {
	String [] res = new String[height];
	res[0] = line(offset, width);
	String [] lines = verticalLineRight(offset, width, ((height-2) / 2));
	System.arraycopy(lines, 0, res, 1, lines.length);
	res[lines.length + 1] = line(offset, width);
	String [] lines1 = verticalLineRight(offset, width, ((height-3) / 2));
	System.arraycopy(lines1, 0, res, (lines.length + 2), lines1.length);
	res[height - 1] = line(offset, width);
	return res;
}

public static String[] four(int offset, int width, int height) {
	String [] res = new String[height];
	String [] lines = twoVerticalLines(offset, width, ((height-2) / 2 + 1));
	System.arraycopy(lines, 0, res, 0, lines.length);
	res[lines.length] = line(offset, width);
	String [] lines1 = verticalLineRight(offset, width, ((height-3) / 2 + 1));
	System.arraycopy(lines1, 0, res, (lines.length + 1), lines1.length);
	return res;
}

public static String[] five(int offset, int width, int height) {
	String [] res = new String[height];
	res[0] = line(offset, width);
	String [] lines = verticalLineLeft(offset, width, ((height-2) / 2));
	System.arraycopy(lines, 0, res, 1, lines.length);
	res[lines.length + 1] = line(offset, width);
	String [] lines1 = verticalLineRight(offset, width, ((height-3) / 2));
	System.arraycopy(lines1, 0, res, (lines.length + 2), lines1.length);
	res[height - 1] = line(offset, width);
	return res;
}

public static String[] six(int offset, int width, int height) {
	String [] res = new String[height];
	res[0] = line(offset, width);
	String [] lines = verticalLineLeft(offset, width, ((height-2) / 2));
	System.arraycopy(lines, 0, res, 1, lines.length);
	res[lines.length + 1] = line(offset, width);
	String [] lines1 = twoVerticalLines(offset, width, ((height-3) / 2));
	System.arraycopy(lines1, 0, res, (lines.length + 2), lines1.length);
	res[height - 1] = line(offset, width);
	return res;
}

public static String[] seven(int offset, int width, int height) {
	String [] res = new String[height];
	res[0] = line(offset, width);
	String [] lines = verticalLineRight(offset, width, height-1);
	System.arraycopy(lines, 0, res, 1, lines.length);
	res[0] = line(offset, width);
	return res;
}

public static String[] eight(int offset, int width, int height) {
	String [] res = new String[height];
	res[0] = line(offset, width);
	String [] lines = twoVerticalLines(offset, width, ((height-2) / 2) );
	System.arraycopy(lines, 0, res, 1, lines.length);
	res[lines.length + 1] = line(offset, width);
	String [] lines1 = twoVerticalLines(offset, width, (height-3) / 2 );
	System.arraycopy(lines1, 0, res, (lines.length + 2), lines1.length);
	res[height - 1] = line(offset, width);
	return res;
}

public static String[] nine(int offset, int width, int height) {
	String [] res = new String[height];
	res[0] = line(offset, width);
	String [] lines = twoVerticalLines(offset, width, ((height-2) / 2) );
	System.arraycopy(lines, 0, res, 1, lines.length);
	res[lines.length + 1] = line(offset, width);
	String [] lines1 = verticalLineRight(offset, width,  (height-3) / 2 );
	System.arraycopy(lines1, 0, res, (lines.length + 2), lines1.length);
	res[height - 1] = line(offset, width);
	return res;
}

static public int getNdigits(long number) {
	int res = 0;
	do {
		number /= 10;
		res++;
	} while(number !=0);
	return res;
}

public static int[] getDigits(int number) {
	int res[] = new int[getNdigits(number)];
	for(int i = res.length - 1; i >= 0; i--) {
		res[i] = number %10;
		number /=10;
	}
	return res;
}

public static void displayStrings(String[] strings) {
	for(int i = 0; i < strings.length; i++) {
		System.out.println(strings[i]);
	}
}
}
