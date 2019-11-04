package com.teamoctopus.practice;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class NumberValuePrinter {

	public static final Map<Integer, String> map1 = new HashMap<Integer, String>();
	public static final Map<Integer, String> map2 = new HashMap<Integer, String>();
	public static final Map<Integer, String> map3 = new HashMap<Integer, String>();

	public static void main(String[] args) throws Throwable {
		init();

		StringBuffer printer = null;
		List<Integer> keys = new ArrayList<Integer>(new TreeSet<Integer>(map3.keySet()));
		for (int i = 999999999; i <= 2147483647; i++) {
			printer = new StringBuffer();
			printer.append(i + " - ");
			processNumber(i, map3, keys, printer);
			WriteToTextFile(printer.toString().replace("  ", " "));
		}
	}

	public static void WriteToTextFile(String numberValue) throws Throwable {
		String filepath = "C:/Shiftselect/numbertoText.txt";
		FileWriter fw = new FileWriter(filepath, true);
		PrintWriter pr = new PrintWriter(fw);
		pr.println(numberValue);
		pr.flush();
	}

	private static void init() {

		map1.put(1, "ONE");
		map1.put(2, "TWO");
		map1.put(3, "THREE");
		map1.put(4, "FOUR");
		map1.put(5, "FIVE");
		map1.put(6, "SIX");
		map1.put(7, "SEVEN");
		map1.put(8, "EIGHT");
		map1.put(9, "NINE");
		map1.put(10, "TEN");
		map1.put(11, "ELEVEN");
		map1.put(12, "TWELVE");
		map1.put(13, "THIRTEEN");
		map1.put(14, "FOURTEEN");
		map1.put(15, "FIFTEEN");
		map1.put(16, "SIXTEEN");
		map1.put(17, "SEVENTEEN");
		map1.put(18, "EIGHTEEN");
		map1.put(19, "NINETEEN");
		map1.put(20, "TWENTY");
		map1.put(30, "THIRTY");
		map1.put(40, "FORTY");
		map1.put(50, "FIFTY");
		map1.put(60, "SIXTY");
		map1.put(70, "SEVENTY");
		map1.put(80, "EIGHTY");
		map1.put(90, "NINTY");
		map1.put(100, "HUNDRED");

		map2.put(1000, "THOUSAND");
		map2.put(100000, "LAC");
		map2.put(10000000, "CRORE");
		map2.put(2147483647, "MAX");

		map3.put(1000, "THOUSAND");
		map3.put(1000000, "MILLION");
		map3.put(1000000000, "BILLION");
		map3.put(2147483647, "MAX");
	}

	private static void processNumber(int number, Map<Integer, String> processor, List<Integer> keys,
			StringBuffer printer) {

		for (int i = keys.size() - 1; i > 0; i--) {
			int maxValue = keys.get(i);
			int minValue = keys.get(i - 1);
			if (number >= minValue && number < maxValue) {
				int quo = (int) (number / minValue);
				number = number % minValue;
				if (quo != 0) {
					printNumber(quo, printer);
					printer.append(" ");
					printer.append(processor.get(minValue));
					if (quo > 1) {
						printer.append("S");
					}
					printer.append(" ");
				}
			}
		}

		if (number > 0) {
			printNumber(number, printer);
		}

	}

	private static void printNumber(int num, StringBuffer printer) {
		int quo, rem;
		if (num >= 100 && num <= 999) {
			rem = num % 100;
			quo = num / 100;

			printer.append(map1.get(quo));
			printer.append(" ");
			printer.append(map1.get(100));
			printer.append(" ");
			if (rem != 0) {
				printNumber(rem, printer);
			}
		} else if (num >= 20 && num <= 99) {
			rem = num % 10;
			quo = num / 10;

			printer.append(map1.get(quo * 10));
			printer.append(" ");
			if (rem != 0) {
				printNumber(rem, printer);
			}
		} else if (num >= 1 && num <= 19) {
			printer.append(map1.get(num));
		}
	}

}
