import java.util.*;
import java.util.regex.*;
public class Main
{
    static int digits, words, tCases;
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		System.out.println("Enter the digits");
		digits = sc.nextInt();
		System.out.println("Enter the no of words");
		words = sc.nextInt();
		System.out.println("Enter the no of test cases");
		tCases = sc.nextInt();
		
		String [] l1 = new String[words], l2 = new String[tCases];
		for (int i = 0; i < words; i++){
		    System.out.println("Enter: " + i);
		    l1[i] = sc.next();
		}
		for (int i = 0; i < tCases; i++){
		    System.out.println("Enter " + i);
		    l2[i] = sc.next();
		}
		solve(l1,l2);
	}
	public static void solve(String[] l1, String[] l2){
	    int count = 0;
	    for (int i = 0; i < l2.length; i++){
	        for (int j = 0; j < l1.length; j++){
	            if(!l2[i].contains("(")){
	               if(compare(l2[i], l1[j])){
	                    count++;
	               } 
	            }
	            else{
	                System.out.println(l2[i]);
	                l2[i] = l2[i].replaceAll("\\(", "[");
	                l2[i] = l2[i].replaceAll("\\)", "]");
	                System.out.println(l2[i]);
	                String text = l1[j];
	                String patternString = l2[i];
	                Pattern pattern = Pattern.compile(patternString);
                    Matcher matcher = pattern.matcher(text);
	                while(matcher.find()) {
                        count++;
                    }
	            }
	        }
	    }
	    System.out.println(count + " instances found");
	}
	public static boolean compare(String s1, String s2){
	    char[] first = s1.toCharArray();
        char[] second = s2.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
	}
}
