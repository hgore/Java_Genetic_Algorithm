package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import feaheat;
public class debinary{
void debinary(int N, int bitsize, int dimension, int binarry[][][], double b[][], int n)
{
	for(int i=0; i<n;i++)
	{	
		for(int j=0;j<dimension;j++)
			for(int k=0;k<bitsize;k++)
				b[i][j] += binarry[i][j][k]*Math.pow(2,-k);
	//	cout<<r[i]<<endl;
	}
}
}