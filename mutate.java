package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import feaheat;
public class mutate{
void mutate(int N, int bitsize, int dimension, int binarray[][][])
{
 convertbinary aconvertbinary = new convertbinary();
	double randelements[][] = new double[N/4][dimension];
	int randelementsarray[][][] = new int[N/4][dimension][bitsize];	//array with N/4 random binary strings
	for(int i=0;i<(N/4);i++)				//this array will give us mutants and rand at end.
	{
		for(int j=0;j<dimension;j++)
			randelements[i][j] = Math.random();
	}
	aconvertbinary.convertbinary(N, bitsize, dimension, randelements,randelementsarray,(N/4));
	for(int i=0; i<(N/4);i++)
	{
		for(int j=0;j<dimension;j++)
		{
			for(int k=0;k<bitsize;k++)
			{
				binarray[i+(N/2)][j][k] = -1*(binarray[i+(N/2)][j][k]-randelementsarray[i][j][k])%2;
			}
		}
	}
//return int binarray[][dimension][bitsize];
}
}