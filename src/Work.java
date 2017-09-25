import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Work {

	public Work() {

	}

	long[][] Rmatrix;

	public void WorkAll(Register r1 ) throws IOException {
		OutputStream f1 = new FileOutputStream
	(String.format("d:\\R_matrix_Polinom_R=%d_Polinom_%s+1.txt",r1.getR(), r1.getPolName()), true);
		OutputStreamWriter writer1 = new OutputStreamWriter(f1);
		BufferedWriter out1 = new BufferedWriter(writer1);
		//int period1 = 0;

		OutputStream f11 = new FileOutputStream(String.format("d:\\period_R_matrix_Polinom_R=%sx+1.txt", r1.getPolName()), true);
		OutputStreamWriter writer11 = new OutputStreamWriter(f11);
		BufferedWriter out_period = new BufferedWriter(writer11);

		int j_out;
		String s = null;
		int period_out;
		String sPeriod = "період = ";
		int period = 0;

		r1.firstPart(r1);
		boolean xor1;
		System.out.println(r1);

 ///// степінь матриці
		if (r1.getR() >1) {
			r1.CreateMatrixR(r1); 
		}
		 

		for (int i = 1; i <= 1000000000; i++) {

			xor1 = r1.secondPart(r1);  
			 

			 
				j_out = r1.outInFilePart(xor1);
				s =String.format("%d",  j_out);
				out1.write(s);
				 
			

			if (/* (period == 0) && */ (r1.getA() == r1.getA0()) ) {
				period = i;

				period_out = period;
				 
				sPeriod = String.format("період = %d", period_out) ;
				out_period.newLine();
				out_period.write(sPeriod);
				/// r3.setA0(r3.getA());
			}

			if ((i) % 10000000 == 0) {
				System.out.print(String.format("%d         %d         %d       %d%n", i,r1.getA(), r1.getA0(),period ));
			}
			 r1.setA(BigInteger.valueOf(0));   
		}
		out1.flush();
		out1.close();
		out_period.flush();
		out_period.close();

	}

	public long[][] getRmatrix() {
		return Rmatrix;
	}

	public void setRmatrix(long[][] rmatrix) {
		Rmatrix = rmatrix;
	}

}
