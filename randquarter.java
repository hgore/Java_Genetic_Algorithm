package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import feaheat;
public class randquarter{
void randquarter(int N, int bitsize, int dimension, int binar[][][])
{
	convertbinary aconvertbinary = new convertbinary();
	double randelementsquarter[][] = new double[N/4][dimension];
	int randelementsarrayquarter[][][] = new int[N/4][dimension][bitsize];	//array with N/4 random binary strings
	for(int i=0;i<(N/4);i++)				//this array will give us mutants and rand at end.
	{
		for(int j=0;j<dimension;j++)
			randelementsquarter[i][j] =  Math.random();
	}
	aconvertbinary.convertbinary(N, bitsize, dimension, randelementsquarter,randelementsarrayquarter,(N/4));
	for(int i=0; i<(N/4);i++)
	{
		for(int j=0;j<dimension;j++)
		{
			for(int k=0;k<bitsize;k++)
			{
			binar[i+((3*N)/4)][j][k] = randelementsarrayquarter[i][j][k];
	//cout<<randelementsarrayquarter[i][j];
			}
		}
	}
}
}