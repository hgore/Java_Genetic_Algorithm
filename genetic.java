package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.io.PrintStream;
import java.util.Random;
import feaheat;
public class genetic {
	public static void main(String argv[]) throws FileNotFoundException
	{
		 cost acost = new cost();	//takes in an independant and dependant variable and calculates the dependant variable
		 tournament atournament = new tournament();	//pairwise comparison to find smallest elements of a[] with respect to c[]
		 convertbinary aconvertbinary = new convertbinary(); //takes in the sorted array of ind. vars. and converts them into a binary matrix
		 rdmarray ardmarray = new rdmarray(); //randomizes the elements of y[][] and s[] the same way, and only the array elements between miny and maxy (ie elements 3-7, or 0-N)
		 mixing amixing = new mixing(); //Generates cildren of the first quarter elements, which were the best of the system.
		 mutate amutate = new mutate();	//swaps the first half of binarry's binary number with the second half of the next element's and vice versa. Creates the 3rd quarter of new imputs.
		 randquarter arandquarter = new randquarter();	//makes the 4th quarter of your new imputs random so that you always check the whole domain and don't get trapped in a local minimum.
		 debinary adebinary = new debinary();	//converts the binary array to a decimal array.
		int N = 64;					//size of gene pool
		int bitsize = 64;			//size of binary numbers (max is sizeof(double)
		int dimension = 2;
			//cout<<setprecision(8);
			//uniform_int_distribution<int> randoma(0,((N/4)-1));
			//uniform_real_distribution<double> random(.1,1);
		//	uniform_real_distribution<double> randomb(0,bitsize/4);
		long timestart;
		long timeend;
		double xy[][] = new double[N][dimension];	//xy[0][0] = x0, and xy[0][1] = y0
		double costs[] = new double[N];
		int binaryrep[][][] = new int[N][dimension][bitsize];
		timestart = System.currentTimeMillis();

		
		for(int i=0; i<N; i++)
			for(int j=0;j<dimension;j++)
			{
			Random randomx = new Random();
			Random randomy = new Random();
			double randx = 0.1 + randomx.nextDouble();
			double randy = 0.1 + randomy.nextDouble();
			xy[i][0] = randomx.nextDouble();
			xy[i][1] = randomy.nextDouble();
			System.out.printf("\nx:	%1f 	y %1f", xy[i][0], xy[i][1]);
			}
		for(int epoch=0;epoch<100000;epoch++)
		{
		acost.cost(N, bitsize, dimension, xy,costs);				//use this to sort r[] by comparison
		atournament.tournament(N, bitsize, dimension, xy,costs);		//finds the largest element and one of the second largest ones
		acost.cost(N, bitsize, dimension, xy,costs);				
		atournament.tournament(N, bitsize, dimension, xy,costs);		//you now have a population of winners in q1 of r[]
		acost.cost(N, bitsize, dimension, xy,costs);//you need the cost associated with q1 of r[] to be in 1st quarter too
		aconvertbinary.convertbinary(N, bitsize, dimension, xy,binaryrep,N);	//get your binary array. it has elements in its 1st quarter.
		ardmarray.rdmarray(N, bitsize, dimension, binaryrep,xy,0,(N/4));	//swap the elements in the 1st quarter of the binary array (the only elements there)
		amixing.mixing(N, bitsize, dimension, binaryrep);			//generate elements N/4 -> N/2 -- children of Q1, all are in Q2
		amutate.mutate(N, bitsize, dimension, binaryrep);			//mutate Q2 and put the mutants in Q3
		arandquarter.randquarter(N, bitsize, dimension, binaryrep);		//the 4th quarter is full of random binary numbers so that you continue to sample the whole domain.
		adebinary.debinary(N, bitsize, dimension, binaryrep,xy,N);	//convert the binary array to a decimal array and restart the program.
		}
		acost.cost(N, bitsize, dimension, xy,costs); //after some number of epochs you should have minimized the cost function
		for(int i=0;i<(Math.log(N)/Math.log(2));i++)	//log(n)/log(2) is log base 2 of N, which gives you a final array with 1 element in it, because the tournament function halves the size of the array each time.
		{	
			atournament.tournament(N, bitsize, dimension, xy,costs);	//get the element that minimizes the cost
			acost.cost(N, bitsize, dimension, xy,costs);			//you have to check the cost each time
		}

		//cout<<"x: "<<xy[0][0]<<"\ny: "<<xy[0][1]<<"\n"<<costs[0]<<" \n";	//outputs the position in angstroms and the value of energy in eV
		//System.out.printf("\nx:	%.0f", xy[0][0]);
		//System.out.printf("\ny:	%.0f",xy[0][1]);
		System.out.printf("\nx:	%1f 	y: %1f 	costs: %1f", xy[0][0], xy[0][1],costs[0]);
		//System.out.printf("\n\n%1f",costs[0]);
		System.out.printf("	\n\n");
		timeend = System.currentTimeMillis();
		//cout<<"\n"<<(timeend - timestart)/60<<"min, "<<(timeend - timestart)%60<<"sec"<<endl;
		System.out.printf("\n %d	min, %d sec",(timeend-timestart)/60, (timeend-timestart)%60);
		feaheat.HeatTransfer();
	}
}
