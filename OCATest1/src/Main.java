
public class Main {

	public static void main(String[] args) {
		question1();
		// Puma puma = new Puma();
		// System.out.println(puma.getTailLength());

	}

	public static void question1() {
		String s1 = "Java";
		String s2 = "Java";
		StringBuilder sb1 = new StringBuilder();
		sb1.append("Ja").append("va");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(sb1.toString() == s1);
		System.out.println(sb1.toString().equals(s1));
	}

}
