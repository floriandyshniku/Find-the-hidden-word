
import java.util.Scanner;

public class FindTheHiddenWord {
	public static String perzgjidhFjalen(String[] fjalet) {
		return fjalet[(int) (Math.random() * fjalet.length)];
	}

	public static String fshihFjalen(String fjala) {
		if (fjala == null) {
			return null;
		}
		String rez = fjala.charAt(0) + "";
		for (int i = 0; i < fjala.length() - 1; i++) {
			rez = rez + "*";
		}
		return rez;
	}

	public static String zbuloFjalen(String fjala, char x, String fjalaEFshehur) {

		String str1 = "";
		if (!fjala.contains(x + "")) {
			return fjalaEFshehur;
		}
		x = Character.toLowerCase(x);
		for (int i = 0; i < fjala.length(); i++) {
			if (x == fjala.charAt(i) && !fjalaEFshehur.contains(x + "")) {
				fjalaEFshehur = fjalaEFshehur.substring(0, i) + x + fjalaEFshehur.substring(i + 1);

				return fjalaEFshehur;
			}
			if (x == fjala.charAt(i) && fjalaEFshehur.contains(x + "")) {
				str1 = fjalaEFshehur.substring(0, i) + x + fjalaEFshehur.substring(i + 1);

			}
		}
		return str1;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean lose = false;
		int numriIProvave = 1;
		String fjalet[] = { "Berat", "Durres", "Qeni", "Macja",
				"Libri","Lapsi","Soba"};
		String fjalaEPerzgjedhur = perzgjidhFjalen(fjalet);
//		System.out.println(fjalaEPerzgjedhur);
		String fjalaEFshehur = fshihFjalen(fjalaEPerzgjedhur);
		System.out.println(fjalaEFshehur);
		System.out.println("Jep char: ");
		String a = input.nextLine().trim();
		System.out.println("Numri qe keni provuar: " + numriIProvave);
		while (a.isEmpty()) {
			a = input.nextLine().trim();
		}
		char x = a.charAt(0);
		fjalaEFshehur = zbuloFjalen(fjalaEPerzgjedhur, x, fjalaEFshehur);
		System.out.println(fjalaEFshehur);
		while (!fjalaEPerzgjedhur.equals(fjalaEFshehur)) {
			System.out.println("Jep char: ");
			x = input.next().charAt(0);
			System.out.println("Numri qe keni provuar: " + numriIProvave);
			fjalaEFshehur = zbuloFjalen(fjalaEPerzgjedhur, x, fjalaEFshehur);
			numriIProvave ++;
			if (numriIProvave > 10) {
				System.out.println("Ju tejkaluat numrin e provave.");
				lose = true;
				break;
			}
			System.out.println(fjalaEFshehur);
		}
		if (lose == true) {
			System.out.println("Me vjen keq ju humbet!");
		}
		else {
			System.out.println("Urime ju fituat!");
		}
		
	}
}
