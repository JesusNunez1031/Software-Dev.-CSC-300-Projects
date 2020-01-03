
public class AckermannDemo {
	
	public static int ackermann(int m, int n) {
		if(m == 0) {
			return n + 1;
		}
		
		if(n == 0) {
			return ackermann(m - 1, 1);
		}
		else {
			return ackermann(m - 1, ackermann(m, n - 1));
		}
	}

	public static void main(String[] args) {
		System.out.printf("ackermann(0,0) = %d\n", ackermann(0, 0));
		System.out.printf("ackermann(0,1) = %d\n", ackermann(0, 1));
		System.out.printf("ackermann(1,1) = %d\n", ackermann(1, 1));
		System.out.printf("ackermann(1,2) = %d\n", ackermann(1, 2));
		System.out.printf("ackermann(1,3) = %d\n", ackermann(1, 3));
		System.out.printf("ackermann(2,2) = %d\n", ackermann(2, 2));
		System.out.printf("ackermann(3,2) = %d\n", ackermann(3, 2));

	}

}
