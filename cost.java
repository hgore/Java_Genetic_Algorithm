package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import feaheat.HeatTransfer;
public class cost{
void cost(int N, int bitsize, int dimension, double ind[][], double V[])	//is being evaluated on the interval [-1,1]
{
	double pi = 3.14159265359;
for(int i=0; i<N; i++)
			V[i] = ind[i][1]*Math.sin(4*pi*ind[i][0])+ 2*ind[i][0]*Math.cos(8*pi*ind[i][1]);
}
}