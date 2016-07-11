package hello;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class OpsStrings {

	public static void main(String[] args) {
		System.out.println("Main");
		String str = "this is my place to yup!";
		
		//uniqueWords(str);
		//reverseStr(str);
		//reverseWord(str);
		//readFileReverseOutFile();
		//factorialUsingRecursion();
		//compareString();
		//addString();
		linkHashMapExample();
	}
	
	private static void uniqueWords(String aStr){
		String[] theStr = aStr.split("\\s+");
		
		Set<String> uniques = new TreeSet<String>();
		for(String s:theStr){
		uniques.add(s);
		}
		System.out.println("size:"+uniques.size());
		uniques.forEach(System.out :: println);
	}
	
	private static void reverseStr(String st){
		char[] ch = st.toCharArray();
		List<Character> aList = new LinkedList<>();
		for(Character c: ch){
			aList.add(c);
		}
		Collections.reverse(aList);
		
		Iterator<Character> theList = aList.iterator();
		while(theList.hasNext()){
			System.out.print(theList.next());
		}
	}
	
	private static List<String> reverseWord(String str){
		System.out.println("Reverse the words:");
		String[] theStr = str.split("\\s+");
		System.out.println("theStr: "+Arrays.toString(theStr));
		List<String> aStrList = Arrays.asList(theStr);
		Collections.reverse(aStrList);
		
		Iterator<String> wList = aStrList.iterator();
		while(wList.hasNext()){
				System.out.print(" "+wList.next());
		}
		return aStrList;
	}
	
	private static void readFileReverseOutFile(){
		final String FILE_NAME = "C:\\temp\\input.txt"; 
		final String OUT_FILE = "C:\\temp\\output.txt";
		final Charset ENCODING = StandardCharsets.UTF_8;
		
		Path path = Paths.get(FILE_NAME);
		List<String> aList = null;
		try {
			aList= Files.readAllLines(path,ENCODING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> bList = reverseWord(aList.toString());
		
		Path outpath = Paths.get(OUT_FILE);
		try {
			Files.write(outpath, bList, ENCODING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void factorialUsingRecursion(){
		System.out.println("factorialUsingRecursion - in");
		int n = 3;
		
		System.out.println(fact(n));
		
	}
	
	private static int fact(int x){
		if (x <= 1)
			return 1;
		else 
		return x * fact(x-1);
	}
	
	private static void compareString(){
		String a = "h1";
		String b = "h1";
		if (a == b){
			System.out.println("true: "+Integer.toHexString(System.identityHashCode(a))+" b:"+Integer.toHexString(System.identityHashCode(b)));
		} else System.out.println("false");
		
		if (a.equals(b)){
			System.out.println("true");
		} else System.out.println("false");
		
		if (a.equalsIgnoreCase(b)){
			System.out.println("true");
		} else System.out.println("false");
		
		
		OpsStrings op1 = new OpsStrings();
		OpsStrings op2 = new OpsStrings();
		
		System.out.println("object comparision");
		if (op1 == op2){
			System.out.println("true");
		} else {
			System.out.println("false: op1:"+Integer.toHexString(System.identityHashCode(op1))+" op2:"+Integer.toHexString(System.identityHashCode(op2)));
			
		}
		
		if (op1.equals(op2)){
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
	}
	
	private static void addString(){
		String[] a = {"3","7", "9"};
		int len = a.length;
		System.out.println("length: "+ a.length+ " Before: "+Arrays.toString(a));
		for (int i=len-1; i<=len; i--){
			System.out.println("a[i]:"+a[i]);
			if (Integer.parseInt(a[i]) < 9){
				int k = Integer.parseInt(a[i]);
				k++;
				a[i]= Integer.toString(k);
				break;
			} else {
				System.out.println("inside");
				System.out.println("a: "+a[0]+" a1: "+a[1]);
				int k = Integer.parseInt(a[i]);
				k++;
				k = k % 10;
				a[i]= Integer.toString(k);
			}
		}
		System.out.println("After:"+ Arrays.toString(a));
	}
	
	private static void linkHashMapExample(){
		System.out.println("linked HashMap");
		LinkedHashMap<String, String> lh = new LinkedHashMap<>();
		lh.put("key2", "B");
		lh.put("key1", "A");
		lh.put("key4", "E");
		lh.put("key3", "C");
		lh.put("key1", "D");
		
		HashMap<String, String> hm = new HashMap<>();
		hm.put("key3", "C");
		hm.put("key4", "E");
		hm.put("key1", "A");
		hm.put("key2", "B");
		hm.put("key3", "E");
		
		for(Map.Entry<String, String> entry: hm.entrySet()){
			System.out.println(entry.getValue());
		}
	}
}
