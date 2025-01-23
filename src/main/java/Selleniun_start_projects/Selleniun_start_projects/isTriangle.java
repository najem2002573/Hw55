package Selleniun_start_projects.Selleniun_start_projects;

public class isTriangle {
	public boolean test(int a, int b, int c) {
        // A triangle is valid if the sum of any two sides is greater than the third
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
