import java.math.BigInteger;

public class Matrix {

	public BigInteger[][] MultiplyXTimes(int Xtimes, BigInteger[][] a) {
		BigInteger[][] multipl = a;
		for (int i = 0; i < Xtimes - 1; i++) {

			multipl = Multiply(a, multipl);
			// SystemOut(multipl);
		}
		a = multipl;
		return a;
	}
	/////////  2
	public void Pol(BigInteger[][] a, int pol1, int pol2) {
 
		a[0][pol1 - 1] = BigInteger.valueOf(1);
		a[0][pol2 - 1] = BigInteger.valueOf(1);

		for (int x = 1; x < a.length; x++) {
			for (int y = 0; y < a.length; y++) {
				if (x - 1 == y) {
					a[x][y] = BigInteger.valueOf(1);
				}
			}

		}

	}
	/////////  3
	public void Pol(BigInteger[][] a, int pol1, int pol2, int pol3) {

		a[0][pol1 - 1] = BigInteger.valueOf(1);
		a[0][pol2 - 1] = BigInteger.valueOf(1);
		a[0][pol3 - 1] = BigInteger.valueOf(1);

		for (int x = 1; x < a.length; x++) {
			for (int y = 0; y < a.length; y++) {
				if (x - 1 == y) {
					a[x][y] = BigInteger.valueOf(1);
				}
			}

		}

	}
	/////////  4
	public void Pol(BigInteger[][] a, int pol1, int pol2, int pol3, int pol4 ) {

		a[0][pol1 - 1] = BigInteger.valueOf(1);
		a[0][pol2 - 1] = BigInteger.valueOf(1);
		a[0][pol3 - 1] = BigInteger.valueOf(1);
		a[0][pol4 - 1] = BigInteger.valueOf(1);
	 
		for (int x = 1; x < a.length; x++) {
			for (int y = 0; y < a.length; y++) {
				if (x - 1 == y) {
					a[x][y] = BigInteger.valueOf(1);
				}
			}

		}

	}
	////////// 5
	public void Pol(BigInteger[][] a, int pol1, int pol2, int pol3, int pol4, int pol5 ) {

		a[0][pol1 - 1] = BigInteger.valueOf(1);
		a[0][pol2 - 1] = BigInteger.valueOf(1);
		a[0][pol3 - 1] = BigInteger.valueOf(1);
		a[0][pol4 - 1] = BigInteger.valueOf(1);
		a[0][pol5 - 1] = BigInteger.valueOf(1);
 

		for (int x = 1; x < a.length; x++) {
			for (int y = 0; y < a.length; y++) {
				if (x - 1 == y) {
					a[x][y] = BigInteger.valueOf(1);
				}
			}

		}

	}
	////////// 6
	public void Pol(BigInteger[][] a, int pol1, int pol2, int pol3, int pol4, int pol5, int pol6) {

		a[0][pol1 - 1] = BigInteger.valueOf(1);
		a[0][pol2 - 1] = BigInteger.valueOf(1);
		a[0][pol3 - 1] = BigInteger.valueOf(1);
		a[0][pol4 - 1] = BigInteger.valueOf(1);
		a[0][pol5 - 1] = BigInteger.valueOf(1);
		a[0][pol6 - 1] = BigInteger.valueOf(1);

		for (int x = 1; x < a.length; x++) {
			for (int y = 0; y < a.length; y++) {
				if (x - 1 == y) {
					a[x][y] = BigInteger.valueOf(1);
				}
			}

		}

	} 
	
	
	
	
	public BigInteger[][] Multiply(BigInteger[][] a, BigInteger[][] b) {
		BigInteger[][] multipyed = new BigInteger[a.length][a.length];

		for (int i = 0; i < multipyed.length; i++) {
			for (int j = 0; j < multipyed.length; j++) {
				multipyed[i][j] = BigInteger.valueOf(0);
			}
		}

		BigInteger temp = BigInteger.valueOf(0);
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < a.length; y++) {
				for (int i = 0; i < a.length; i++) {
					temp = a[x][i].multiply(b[i][y]);
					multipyed[x][y] = multipyed[x][y].xor(temp);
				}
				multipyed[x][y] = multipyed[x][y].remainder(BigInteger.valueOf(2));
			}

		}
		return multipyed;
	}

	public int[][] MultipliedElements(BigInteger[][] a) {
		int x = a.length;
		int y = 0;
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i][j].equals(BigInteger.valueOf(1))) {
					y++;
					// System.out.println(y);
				}
			}
			if (y > max) {
				max = y;
			}
			y = 0;
		}
		int[][] a1 = new int[x][max];

		int j2 = 0;
		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < a.length; j++) {
				if (a[i][j].equals(BigInteger.valueOf(1))) {
					a1[i][j2] = j;
					j2++;

				}
			}
			j2 = 0;
		}
		return a1;

	}
}
