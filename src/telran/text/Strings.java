package telran.text;

import java.util.Arrays;

public class Strings {
	
/*
 * @param str;
 * @param anagram;
 * 
 * @return true if anagram is an anagram of str
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
	
	return "([0-1][0-9][0-9])|(2[0-4][0-5])";
}

public static String ipV4Octet() {
	
	return "([01]?\\d\\d?|2([0-4]\\d|5[0-5]))";
}

public static String ipV4_1() {
	return "((([0-1]\\d{2})|(2[0-5]{2}))\\.){3}(([0-1]\\d{2})|(2[0-5]{2}))";
}

public static String ipV4() {
	String octetExp = ipV4Octet();
	return String.format("(%1$s\\.){3}%1$s", octetExp);
}

public static String arithmeticExpression() {
	String operatorExp = operator();
	String operandExp = operand();

	
	return String.format("\\(*%1$s(%2$s\\(*%1$s\\)*)*", operandExp, operatorExp);
}

private static String operand() {
	String numberExp = numberExp();
	String variableExp = javaNameExp();
	return String.format("(\\(*(%s|%s)\\)*)", numberExp, variableExp);
}

private static String numberExp() {
	return "(\\d+\\.?\\d*|\\.\\d+)";
}

public static boolean isArithmeticExpression(String expression) {
	expression = expression.replaceAll("\\s+", "");
	return expression.matches(arithmeticExpression());
}

private static String operator() {
	return "([-+/*%])";
}


/**
 * 
 * @param expression
 * @param values
 * @param names - variable names sorted
 * @return
 */

public static double computeArithmeticExpression(String expression, double values[], String names[]) {
	// 10 (* 2)
	// 10 * 2 (())
	Double res = Double.NaN;
	names = getUpdatedNames(names);
	values = getUpdatedValues(values, names);
	int valuesIndex = 0;
	if (isArithmeticExpression(expression) && checkBraces(expression)) {
		expression = expression.replaceAll("[\\s()]+", "");
		String operands[] = expression.split(operator());
		String operators[] = expression.split(operand());
		res = getOperandValue(operands[0], values, names, valuesIndex);
		int index = 1;
		while ( index < operands.length && !res.isNaN()) {
			double operandValue = getOperandValue(operands[index], values, names, valuesIndex);
			if (operands[index].matches("[a-zA-Z$][\\\\w$]*|_[\\\\w$]+")) {
				valuesIndex++;
			}
			res = computeOperation(res, operandValue, operators[index]);
			index++;
			
		}
	}
	
	return res;
}

private static double[] getUpdatedValues(double[] values, String[] names) {
	if (values == null) {
		values = new double[0];
	}
	if (values.length != names.length) {
		values = Arrays.copyOf(values, names.length); 
	}
	return values;
}

private static String[] getUpdatedNames(String[] names) {
	
	return names == null ? new String [0] : names;
}

private static Double getOperandValue(String operand, double[] values, String[] names, int valuesIndex) {
	Double res = Double.NaN;
	if(operand.matches(numberExp())) {
		res = Double.parseDouble(operand);
	} else {
		int index = Arrays.binarySearch(names, operand);
		if (index > -1) {
			res = values[index];
		}
	}
	return res;
}

private static Double computeOperation(double operand1, double operand2, String operator) {
	Double res = Double.NaN;
	if(!Double.isNaN(operand2)) {
		switch(operator) {
		case "+": res = operand1 + operand2; break;
		case "-": res = operand1 - operand2; break;
		case "*": res = operand1 * operand2; break;
		case "/": res = operand1 / operand2; break;
		default: res = Double.NaN;
		}
	}
	return res;
}


private static boolean checkBraces(String expression) {	
	int count = 0;
	int index = 0;
	int length = expression.length();
	while(index < length && count > -1) {
		char symb = expression.charAt(index);
		if (symb == '(') {
			count++;
		} else if (symb == ')') {
			count--;
			}
		index++;
	}
	return count == 0;	
}	
}


