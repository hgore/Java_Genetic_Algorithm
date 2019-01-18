package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import feaheat;
public class mixing{    //Generates cildren of the first quarter elements, which were the best of the system.
void mixing(int N, int bitsize, int dimension, int binaryarray[][][]) //Generates cildren of the first quarter elements, which were the best of the system.
{
	for(int i=0;i<N/8;i++)
	{
		for(int j=0;j<dimension;j++)
		{
			for(int k=0;k<bitsize/2;k++)
			{
				binaryarray[2*i+N/4][j][k] = binaryarray[2*i][j][k];
				binaryarray[2*i+N/4][j][k+bitsize/2] = binaryarray[2*i+1][j][k+bitsize/2];

				binaryarray[2*i+N/4+1][j][k] = binaryarray[2*i+1][j][k];
				binaryarray[2*i+N/4+1][j][k+bitsize/2] = binaryarray[2*i][j][k+bitsize/2];
			}
		}
	}
	//return binaryarray[N][dimension][bitsize];
}
}