package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import feaheat;
public class convertbinary{
void convertbinary(int N, int bitsize, int dimension, double sortedind[][], int binaryno[][][],int n) //converts a decimal in (0,1) to binary w/ 16 digit accuracy
{
	double b = 0;
	for(int i=0; i<n;i++)
	{
		for(int j=0; j<dimension;j++)
		{
			for(int k=0; k<bitsize; k++)
			{
				b = sortedind[i][j] - Math.pow(2,-k);
				if(b>0)
				{
					binaryno[i][j][k]=1;
					sortedind[i][j] = b;
				}
				else if(b<0)
				binaryno[i][j][k]=0;
			}
			//cout<<i<<"	"<<j<<"	"<<binaryno[i][j]<<endl;
		}
	//cout<<sortedind[i]<<endl;
	}
}
}