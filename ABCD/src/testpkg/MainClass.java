package testpkg;


public class MainClass {
	public static void main(String[] args) {

		TestingHibernate th = new TestingHibernate();
		th.persistData();
		System.out.println("hello world ");
	}

}
