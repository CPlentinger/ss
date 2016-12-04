package ss.week1;
public class CheckGrade {

	public static void main(String[] args) {
		compare test = new compare();
		test.checkgrade();
	}

}
class compare {
	public boolean checkgrade() {
		int grade = 50;
		boolean check;
		check = grade >= 70;
		System.out.println(check);
		return check;
	}
}