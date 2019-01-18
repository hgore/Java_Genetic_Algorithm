package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import feaheat;
public class tournament{
void tournament(int N, int bitsize, int dimension, double a[][],double costs[])
{
	for(int i=0; i<(N/2);i++)
		for(int j=0;j<dimension;j++)
	{
		if(costs[2*i]<costs[2*i+1])
			a[i][j] = a[2*i][j];
		else
			a[i][j] = a[2*i+1][j];
	}
	for(int i=0; i<(N/2);i++)
		for(int j=0;j<dimension;j++)
			a[i+(N/2)][j]=0;
}
}