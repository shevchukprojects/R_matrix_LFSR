import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Register {
	public static void SystemOut(BigInteger[][] rMatrix2) {

		for (BigInteger[] ls : rMatrix2) {
			System.out.println();
			for (BigInteger l : ls) {
				System.out.print(l);
			}
		}
		System.out.println();

	}

	public static void SystemOutRecord(int[][] intRMatrix2, int R, String PolinomName) throws IOException {
		OutputStream f1 = new FileOutputStream("d:\\Multiplayed_R=" + R + "_Polinom_" + PolinomName + ".txt" + "",
				true);
		OutputStreamWriter writer1 = new OutputStreamWriter(f1);
		BufferedWriter out1 = new BufferedWriter(writer1);

		int i = 0;

		for (int[] ls : intRMatrix2) {
			out1.newLine();
			if (i < 10) {
				out1.write("  " + i);
			} else if (i >= 10 & i < 100) {
				out1.write(" " + i);
			} else if (i >= 100 & i < 1000) {
				out1.write("" + i);
			}
			i++;
			for (int l : ls) {
				out1.write(" " + l);
			}
		}
		out1.flush();
		out1.close();

	}

	public static void SystemOutRecord(int[][] intRMatrix2, int R, String PolinomName, String ForMatrixJustAnyText)
			throws IOException {
		OutputStream f1 = new FileOutputStream("d:\\Multiplayed_R=" + R + "_Polinom_" + PolinomName + ".txt" + "",
				true);
		OutputStreamWriter writer1 = new OutputStreamWriter(f1);
		BufferedWriter out1 = new BufferedWriter(writer1);

		int i = 0;

		for (int[] ls : intRMatrix2) {
			out1.newLine();
			if (i < 10) {
				out1.write("  " + i + " ");
			} else if (i >= 10 & i < 100) {
				out1.write(" " + i + " ");
			} else if (i >= 100 & i < 1000) {
				out1.write("" + i + " ");
			}
			i++;
			for (int l : ls) {
				out1.write("" + l);
			}
		}
		out1.flush();
		out1.close();

	}

	private BigInteger A = BigInteger.valueOf(0), A0;
	private boolean[] x;/// = new boolean[pol1];

	private boolean[] z;// = new boolean[pol1];
	private long[] g;// = new long[pol1];
	private int CountInPOlinim;
	private int pol1;
	private int pol2;
	private int pol3;
	private int pol4;
	private int pol5;
	private int pol6;
	private int R;
	private BigInteger[][] rMatrix;
	private int[][] intRMatrix;
	boolean[][] BoolrMatrix;

	private boolean xq = false;
	private String PolName;
	long period = 0;

	public Register() {

	}

	public Register(int r, int pol1, int pol2) {
		CountInPOlinim = 2;
		R = r;
		this.pol1 = pol1;
		this.pol2 = pol2;
		PolName = "" + pol1 + "x+" + pol2 + "x";
		this.x = new boolean[pol1];
		this.z = new boolean[pol1];
		this.g = new long[pol1];

	}

	public Register(int r, int pol1, int pol2, int pol3) {
		CountInPOlinim = 3;
		R = r;
		this.pol1 = pol1;
		this.pol2 = pol2;
		this.pol3 = pol3;

		PolName = "" + pol1 + "x+" + pol2 + "x+" + pol3 + "x";
		this.x = new boolean[pol1];
		this.z = new boolean[pol1];
		this.g = new long[pol1];

	}

	public Register(int r, int pol1, int pol2, int pol3, int pol4) {
		CountInPOlinim = 4;
		R = r;
		this.pol1 = pol1;
		this.pol2 = pol2;
		this.pol3 = pol3;
		this.pol4 = pol4;

		PolName = "" + pol1 + "x+" + pol2 + "x+" + pol3 + "x+" + pol4 + "x";
		this.x = new boolean[pol1];
		this.z = new boolean[pol1];
		this.g = new long[pol1];

	}

	public Register(int r, int pol1, int pol2, int pol3, int pol4, int pol5) {
		CountInPOlinim = 5;
		R = r;
		this.pol1 = pol1;
		this.pol2 = pol2;
		this.pol3 = pol3;
		this.pol4 = pol4;
		this.pol5 = pol5;

		PolName = "" + pol1 + "x+" + pol2 + "x+" + pol3 + "x+" + pol4 + "x+" + pol5 + "x";
		this.x = new boolean[pol1];
		this.z = new boolean[pol1];
		this.g = new long[pol1];

	}

	public Register(int r, int pol1, int pol2, int pol3, int pol4, int pol5, int pol6) {
		CountInPOlinim = 6;
		R = r;
		this.pol1 = pol1;
		this.pol2 = pol2;
		this.pol3 = pol3;
		this.pol4 = pol4;
		this.pol5 = pol5;
		this.pol6 = pol6;
		PolName = "" + pol1 + "x+" + pol2 + "x+" + pol3 + "x+" + pol4 + "x+" + pol5 + "x+" + pol6 + "x";
		this.x = new boolean[pol1];
		this.z = new boolean[pol1];
		this.g = new long[pol1];

	}

	public int[][] BigIntToInt(BigInteger[][] Rmatr) {
		int[][] i = new int[Rmatr.length][Rmatr.length];
		for (int x = 0; x < Rmatr.length; x++) {
			for (int y = 0; y < Rmatr.length; y++) {
				if (Rmatr[x][y].equals(BigInteger.valueOf(1))) {
					i[x][y] = 1;
				} else {
					i[x][y] = 0;
				}

			}
		}

		return i;

	}

	public long[][] BoolToInt(boolean[][] Rmatr) {
		long[][] i = new long[Rmatr.length][Rmatr.length];
		for (int x = 0; x < Rmatr.length; x++) {
			for (int y = 0; y < Rmatr.length; y++) {
				if (Rmatr[x][y]) {
					i[x][y] = 1;
				} else {
					i[x][y] = 0;
				}

			}
		}

		return i;

	}

	public void CreateMatrixR(Register r) throws IOException {
		BigInteger[][] matrix = new BigInteger[pol1][pol1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = BigInteger.valueOf(0);
			}
		}
		Matrix matrix1 = new Matrix();
		switch (r.getCountInPOlinim()) {
		case 2:
			matrix1.Pol(matrix, r.getPol1(), r.getPol2());
			break;
		case 3:
			matrix1.Pol(matrix, r.getPol1(), r.getPol2(), r.getPol3());
			break;
		case 4:
			matrix1.Pol(matrix, r.getPol1(), r.getPol2(), r.getPol3(), r.getPol4());
			break;
		case 5:
			matrix1.Pol(matrix, r.getPol1(), r.getPol2(), r.getPol3(), r.getPol4(), r.getPol5());
			break;
		case 6:
			matrix1.Pol(matrix, r.getPol1(), r.getPol2(), r.getPol3(), r.getPol4(), r.getPol5(), r.getPol6());
			break;
		}

		matrix = matrix1.MultiplyXTimes(R, matrix);

		rMatrix = matrix;
		SystemOut(rMatrix);
		BoolrMatrix = IntToBool(rMatrix);
		intRMatrix = matrix1.MultipliedElements(rMatrix);
		SystemOut(intRMatrix);

		SystemOutRecord(intRMatrix, R, PolName);
		SystemOutRecord(BigIntToInt(rMatrix), R, "" + PolName + "_matr", "MATRIXS");
	}

	public void firstPart(Register r) {
		long[] g = r.getG();
		x = r.getX();
		A0 = BigInteger.valueOf(20);
		//aa = A0;

		for (int i = 0; i < g.length; i++) {
			g[i] = 1;
		}
		g[ g.length-1] = 0;
		// g[g.length-1]=0;

		// System.out.println(this.g.length);
		// for (int j = 0; j < this.g.length; j++) {
		//
		// this.g[j] =
		// aa.subtract((((aa.subtract(aa.remainder(BigInteger.valueOf(2)))).divide(BigInteger.valueOf(2)))
		// .multiply(BigInteger.valueOf(2))));
		// aa =
		// (aa.subtract(aa.remainder(BigInteger.valueOf(2)))).divide(BigInteger.valueOf(2));
		// }
		for (int q = 0; q < this.g.length; q++) {

			if (this.g[q] == 1) {
				this.x[q] = true;
			} else {
				this.x[q] = false;
			}
		}
		r.setG(this.g);
		r.setX(this.x);
	}

	public BigInteger getA() {
		return A;
	}

	public BigInteger getA0() {
		return A0;
	}

	public int getCountInPOlinim() {
		return CountInPOlinim;
	}

	public long[] getG() {
		return g;
	}

	public long getPeriod() {
		return period;
	}

	public int getPol1() {
		return pol1;
	}

	public int getPol2() {
		return pol2;
	}

	public int getPol3() {
		return pol3;
	}

	public int getPol4() {
		return pol4;
	}

	public int getPol5() {
		return pol5;
	}

	public int getPol6() {
		return pol6;
	}

	public String getPolName() {
		return PolName;
	}

	public int getR() {
		return R;
	}

	public BigInteger[][] getrMatrix() {
		return rMatrix;
	}

	public boolean[] getX() {
		return x;
	}

	public boolean[] getZ() {
		return z;
	}

	public boolean[][] IntToBool(BigInteger[][] rMatrix2) {
		boolean[][] i = new boolean[rMatrix2.length][rMatrix2.length];
		for (int x = 0; x < rMatrix2.length; x++) {
			for (int y = 0; y < rMatrix2.length; y++) {
				if (rMatrix2[x][y].equals(BigInteger.valueOf(1))) {
					i[x][y] = true;
				} else {
					i[x][y] = false;
				}

			}
		}

		return i;

	}

	public int outInFilePart(boolean XOR) {
		int i;
		if (XOR) {
			i = 1;
		} else {
			i = 0;
		}
		return i;

	}

	public boolean secondPart(Register r) {

		for (int w = 0; w < z.length; w++) {
			z[w] = x[w];
		}

		if (r.getR() == 1) {
			switch (r.getCountInPOlinim()) {

			case 2:
				x[0] = z[r.getPol1() - 1] ^ z[r.getPol2() - 1];

				break;
			case 3:
				x[0] = z[r.getPol1() - 1] ^ z[r.getPol2() - 1] ^ z[r.getPol3() - 1];

				break;
			case 4:
				x[0] = z[r.getPol1() - 1] ^ z[r.getPol2() - 1] ^ z[r.getPol3() - 1] ^ z[r.getPol4() - 1];
				break;
			case 5:
				x[0] = z[r.getPol1() - 1] ^ z[r.getPol2() - 1] ^ z[r.getPol3() - 1] ^ z[r.getPol4() - 1]
						^ z[r.getPol5() - 1];
				break;
			case 6:
				x[0] = z[r.getPol1() - 1] ^ z[r.getPol2() - 1] ^ z[r.getPol3() - 1] ^ z[r.getPol4() - 1]
						^ z[r.getPol5() - 1] ^ z[r.getPol6() - 1];

				break;

			}

			for (int j = 1; j < g.length; j++) {
				x[j] = z[j - 1];
			}

		} else {
			for (int x1 = 0; x1 < z.length; x1++) {

				for (int y = 0; y < intRMatrix[0].length; y++) {
					if (x1 < R) {
						xq ^= (z[intRMatrix[x1][y]]);
					} else {
						xq = z[intRMatrix[x1][0]];
					}
					// xq=false;
				}
				x[x1] = xq;
				xq = false;
			}
		}

		for (int j = 1; j < g.length; j++) {
			if (x[j]) {
				g[j] = 1;
			} else {
				g[j] = 0;
			}
		}

		// //// ÏÅÐ²ÎÄ
		// long y1 = 1;
		// BigInteger r = BigInteger.valueOf(0);
		// for (int j = 0; j < g.length; j++) {
		// r = BigInteger.valueOf( (g[j]*y1));
		// A = A.add(r);
		// y1 = y1*2;
		//
		// }

		// SYSTEM.OUT.PRINTLN(X.LENGTH);
		// SYSTEM.OUT.PRINTLN(POL1);
		boolean out = x[r.getPol1() - 1]; /////////////////////// Á²Ò ÄËß ÂÈÂÎÄÓ

		return out;

	}

	public void setA(BigInteger a) {
		A = a;
	}

	public void setA0(BigInteger a0) {
		A0 = a0;
	}

	public void setCountInPOlinim(int countInPOlinim) {
		CountInPOlinim = countInPOlinim;
	}

	public void setG(long[] g2) {
		this.g = g2;
	}

	public void setPeriod(long period) {
		this.period = period;
	}

	public void setPol1(int pol1) {
		this.pol1 = pol1;
	}

	public void setPol2(int pol2) {
		this.pol2 = pol2;
	}

	public void setPol3(int pol3) {
		this.pol3 = pol3;
	}

	public void setPol4(int pol4) {
		this.pol4 = pol4;
	}

	public void setPol5(int pol5) {
		this.pol5 = pol5;
	}

	public void setPol6(int pol6) {
		this.pol6 = pol6;
	}

	public void setPolName(String polName) {
		PolName = polName;
	}

	public void setR(int r) {
		R = r;
	}

	public void setX(boolean[] x) {
		this.x = x;
	}

	public void setZ(boolean[] z) {
		this.z = z;
	}

	public void SystemOut(boolean[][] c) {
		System.out.println();

		long[][] a = BoolToInt(c);
		for (long[] ls : a) {
			System.out.println();
			for (long l : ls) {
				System.out.print(l);
			}
		}
		System.out.println();

	}

	public void SystemOut(int[][] rMatrix2) {

		for (int[] ls : rMatrix2) {
			System.out.println();
			for (int l : ls) {
				System.out.print(l + " ");
			}
		}
		System.out.println();

	}

	@Override
	public String toString() {
		return "Register [R=" + R + ", PolName=" + PolName + "+1]";
	}

}
