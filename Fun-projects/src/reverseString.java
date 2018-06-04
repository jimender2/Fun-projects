import java.util.Scanner;

public class reverseString {

	public static void main(String[] args) {
		String needToReverse;
		String[] working;
		
		int words;
		int characters;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the string that you want work on");
		needToReverse = scan.nextLine();
		needToReverse = needToReverse.toLowerCase();
		
		System.out.println("Reverse all words in string");
		
		working = needToReverse.split(" ");
		
		words = working.length - 1;
		
		while (words >= 0) {
			System.out.print(working[words] + " ");
			words --;
		}
		
		System.out.println("");
		System.out.println("Reverse all letters in string");
		
		System.out.println("");
		characters = needToReverse.length() - 1;
		
		while (characters >= 0) {
			System.out.print(needToReverse.charAt(characters));
			characters --;
		}
		
		System.out.println("");
		System.out.println("See if palendrome");
		
		int r = needToReverse.length() - 1;
		int k = 0;
		boolean pal = true;
		
		while (r > k) {
			if (needToReverse.charAt(r) == needToReverse.charAt(k)) {
				
			} else {
				pal = false;
			}
			r --;
			k ++;
		}
		
		if (pal == true) {
			System.out.println("The String is a palendrome");
		} else {
			System.out.println("The String is not a palendrome");
		}
		
		System.out.println("Count how many vowels are in the string");
		
		k = 0;
		r = needToReverse.length() - 1;
		char c;
		int a = 0,
			e = 0,
			i = 0,
			o = 0,
			u = 0,
			total;
		
		while (k <= r) {
			c = needToReverse.charAt(k);
			if (c == 'a') {
				a ++;
			} else if (c == 'e') {
				e ++;
			} else if (c == 'i') {
				i ++;
			} else if (c == 'o') {
				o ++;
			} else if (c == 'u') {
				u ++;
			}
			
			k ++;
		}
		
		total =  a + e + i + o + u;
		
		System.out.println("There are " + a + " a's, " + e + " e's, " + i
				+ " i's " + o + " o's " + u + " u's in the string for a "
						+ "total of " + total + " vowels." );
		
		scan.close();
		
	}

}
