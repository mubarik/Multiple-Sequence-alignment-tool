import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Evolution {
	
	public Evolution()
	{
		
	}
	
	public void IntraClusterEvoultion(ArrayList<Chromosome> ChromosomeClust1 ,ArrayList<Chromosome> ChromosomeClust2 , ArrayList<Chromosome> ChromosomeClust3 , ArrayList<Chromosome> ChromosomeClust4 )
	{
		this.SingleClusterEvolution(ChromosomeClust1);
		this.SingleClusterEvolution(ChromosomeClust2);
		this.SingleClusterEvolution(ChromosomeClust3);
		this.SingleClusterEvolution(ChromosomeClust4);
	}
	
	public void InterClusterEvolution(ArrayList<Chromosome> ChromosomeClust1 ,ArrayList<Chromosome> ChromosomeClust2 , ArrayList<Chromosome> ChromosomeClust3 , ArrayList<Chromosome> ChromosomeClust4 , Chromosome Chromosomes[])
	{
//		int maincounter = 0 ;
		
//		for(int k = 0 ; k < ChromosomeClust1.size() ; k++)
//		{
//			Chromosomes[maincounter] = ChromosomeClust1.get(k);
//			maincounter++;
//		}
//		
//		for(int h = 0 ; h < ChromosomeClust2.size() ; h++)
//		{
//			Chromosomes[maincounter] = ChromosomeClust2.get(h);
//			maincounter++;
//		}
//		
//		for(int g = 0 ; g < ChromosomeClust3.size() ; g++)
//		{
//			Chromosomes[maincounter] = ChromosomeClust3.get(g);
//			maincounter++;
//		}
//		
//		for(int d = 0 ; d < ChromosomeClust4.size() ; d++)
//		{
//			Chromosomes[maincounter] = ChromosomeClust4.get(d);
//			maincounter++;
//		}
		
		int size = ChromosomeClust1.size();	      
		for(int q = 0 ; q < size ; q++)
		{
			for(int h =0 ; h < size-1 ; h++)
	    	{
				if(ChromosomeClust1.get(h).getscore() < ChromosomeClust1.get(h+1).getscore())
				{
					Collections.swap(ChromosomeClust1, h, h+1);
				}
	    	}
		}
		
		size = ChromosomeClust2.size();	      
		for(int q = 0 ; q < size ; q++)
		{
			for(int h =0 ; h < size-1 ; h++)
	    	{
				if(ChromosomeClust2.get(h).getscore() < ChromosomeClust2.get(h+1).getscore())
				{
					Collections.swap(ChromosomeClust2, h, h+1);
				}
	    	}
		}
		
		size = ChromosomeClust3.size();	      
		for(int q = 0 ; q < size ; q++)
		{
			for(int h =0 ; h < size-1 ; h++)
	    	{
				if(ChromosomeClust3.get(h).getscore() < ChromosomeClust3.get(h+1).getscore())
				{
					Collections.swap(ChromosomeClust3, h, h+1);
				}
	    	}
		}
		
		size = ChromosomeClust4.size();	      
		for(int q = 0 ; q < size ; q++)
		{
			for(int h =0 ; h < size-1 ; h++)
	    	{
				if(ChromosomeClust4.get(h).getscore() < ChromosomeClust4.get(h+1).getscore())
				{
					Collections.swap(ChromosomeClust4, h, h+1);
				}
	    	}
		}
		
		
		int clust1upperhalf = ChromosomeClust1.size();
		int clust2upperhalf = ChromosomeClust2.size();
		int clust3upperhalf = ChromosomeClust3.size();
		int clust4upperhalf = ChromosomeClust4.size();
		
		
		int chromcounter = 0;
		
		for(int g = 1 ; g < clust1upperhalf ; g++)
		{
			Chromosomes[chromcounter] = ChromosomeClust1.get(g);
			chromcounter++;
		}
		
		for(int f = 1 ; f < clust2upperhalf ; f++)
		{
			Chromosomes[chromcounter] = ChromosomeClust2.get(f);
			chromcounter++;
		}
		
		for(int d = 1 ; d < clust3upperhalf ; d++)
		{
			Chromosomes[chromcounter] = ChromosomeClust3.get(d);
			chromcounter++;
		}
		
		for(int y = 1 ; y < clust4upperhalf ; y++)
		{
			Chromosomes[chromcounter] = ChromosomeClust4.get(y);
			chromcounter++;
		}
		
		int upperhalf = Chromosomes.length-4;
		
		int lowerhalf = Chromosomes.length-upperhalf;
		int[] randomSequenceupper = new int[upperhalf];
		Random randomNumbersupper = new Random();
		for (int q = 0; q < randomSequenceupper.length; q++ ) 
		{
			if (q == 0) 
			{ // seed first entry in array with item 0
				randomSequenceupper[q] = 0; 
			} 
			else 
			{
				int pointer = randomNumbersupper.nextInt(q + 1);
				randomSequenceupper[q] = randomSequenceupper[pointer]; 
				randomSequenceupper[pointer] = q;
			} 
		}
		
		
		int[] randomSequencelower = new int[lowerhalf];
		Random randomNumberslower = new Random();
		for (int q = 0; q < randomSequencelower.length; q++ ) 
		{
			if (q == 0) 
			{ // seed first entry in array with item 0
				randomSequenceupper[q] = 0; 
			} 
			else 
			{
				int pointer = randomNumberslower.nextInt(q + 1);
				randomSequencelower[q] = randomSequencelower[pointer]; 
				randomSequencelower[pointer] = q;
			} 
		}
		
		for(int h = 0 ; h < randomSequencelower.length ; h++)
		{
			randomSequencelower[h] = randomSequencelower[h] + 96;
		}
		
		ArrayList<Chromosome> Childs = new ArrayList<Chromosome>();
		
		
	
		Chromosome childarray[] = new Chromosome[2];
		int p1score = ChromosomeClust1.get(0).calculateScore();
		int p2score = ChromosomeClust3.get(0).calculateScore();
		if(p1score >= p2score)
		{
			Random rand=new Random(); 
			int x=rand.nextInt(2);
			if(x==0)
			{
				this.SinglePointcrossOver(ChromosomeClust1.get(0),ChromosomeClust3.get(0),childarray);
				Childs.add(childarray[0]);
				Childs.add(childarray[1]);
			}
			else
			{
				this.MultiplePointcrossOver(ChromosomeClust1.get(0),ChromosomeClust3.get(0),childarray);
				Childs.add(childarray[0]);
				Childs.add(childarray[1]);
			}
		}
		else
		{
			Random rand=new Random(); 
			int x=rand.nextInt(2);
			if(x==0)
			{
				this.SinglePointcrossOver(ChromosomeClust3.get(0),ChromosomeClust1.get(0),childarray);
				Childs.add(childarray[0]);
				Childs.add(childarray[1]);
			}
			else
			{
				this.MultiplePointcrossOver(ChromosomeClust3.get(0),ChromosomeClust1.get(0),childarray);
				Childs.add(childarray[0]);
				Childs.add(childarray[1]);
			}
		}
		
		Childs.add(ChromosomeClust1.get(0));
		Childs.add(ChromosomeClust2.get(0));
		Childs.add(ChromosomeClust3.get(0));
		Childs.add(ChromosomeClust4.get(0));
		
		
		int length = Childs.size();	      
		for(int q = 0 ; q < length ; q++)
		{
			for(int h =0 ; h < length-1 ; h++)
	    	{
				if(Childs.get(h).getscore() < Childs.get(h+1).getscore())
				{
					Collections.swap(Childs, h, h+1);
				}
	    	}
		}
		
		int h = (ChromosomeClust1.size()-1) + (ChromosomeClust2.size()-1) + (ChromosomeClust3.size()-1) + (ChromosomeClust4.size()-1);
		int i = 0 ;
		while(h< Chromosomes.length)
		{
			Chromosomes[h] = Childs.get(i);
			i++;
			h++;
		}
		
//		int y = 0; 
//		int g = (lowerhalf-Childs.size());
//		while(y< g)  // generating childs by using mutation
//		{
//			Chromosome child = new Chromosome(); 
//			child = this.Mutation(Chromosomes[randomSequencelower[y]]);
//			Childs.add(child);
//			y++;
//		}
		
		
//		System.out.println("In Class Evolution: Function Inter Cluster Evolution");
//		
//		System.out.println("Printing After adding childs in Chromsosmes in inter cluster evoltion");
//		
//		
//		for(int e = 0 ; e < Chromosomes.length ; e++)
//		{
//			Chromosomes[e].printing();
//			System.out.println("");
//		}
		
		
		
	}
	
	private void SingleClusterEvolution(ArrayList<Chromosome> ChromosomeClust)
	{
		//System.out.println("*************In Class Evolution : Method SingleClusterEvolution***************");		
		int size = ChromosomeClust.size();	      
		for(int q = 0 ; q < size ; q++)
		{
			for(int h =0 ; h < size-1 ; h++)
	    	{
				if(ChromosomeClust.get(h).getscore() < ChromosomeClust.get(h+1).getscore())
				{
					Collections.swap(ChromosomeClust, h, h+1);
				}
	    	}
		}
		
//		for(int u = 0 ; u<25 ; u++)
//		{
//			System.out.println();
//			ChromosomeClust.get(u).printing();
//			System.out.print(ChromosomeClust.get(u).getscore());
//		}
		
		double topseventy = size * 0.7;
		int upperhalf = (int)topseventy;
		int lowerhalf = size-upperhalf;
		int[] randomSequenceupper = new int[upperhalf];
		Random randomNumbersupper = new Random();
		for (int q = 0; q < randomSequenceupper.length; q++ ) 
		{
			if (q == 0) 
			{ // seed first entry in array with item 0
				randomSequenceupper[q] = 0; 
			} 
			else 
			{
				int pointer = randomNumbersupper.nextInt(q + 1);
				randomSequenceupper[q] = randomSequenceupper[pointer]; 
				randomSequenceupper[pointer] = q;
			} 
		}
		
		
		int[] randomSequencelower = new int[lowerhalf];
		Random randomNumberslower = new Random();
		for (int q = 0; q < randomSequencelower.length; q++ ) 
		{
			if (q == 0) 
			{ // seed first entry in array with item 0
				randomSequenceupper[q] = 0; 
			} 
			else 
			{
				int pointer = randomNumberslower.nextInt(q + 1);
				randomSequencelower[q] = randomSequencelower[pointer]; 
				randomSequencelower[pointer] = q;
			} 
		}
		
		for(int h = 0 ; h < randomSequencelower.length ; h++)
		{
			randomSequencelower[h] = randomSequencelower[h] + upperhalf;
		}
         

		ArrayList<Chromosome> Childs = new ArrayList<Chromosome>();
		
		int k = 0;
		int q = upperhalf-1;
		while(k <= q) // generating childs by using crossover operators
		{
			if(k==q)
			{
				Childs.add(ChromosomeClust.get(randomSequenceupper[k]));
			}
			Chromosome childarray[] = new Chromosome[2];

			int p1score = ChromosomeClust.get(randomSequenceupper[k]).calculateScore();
			int p2score = ChromosomeClust.get(randomSequenceupper[q]).calculateScore();
			if(p1score >= p2score)
			{
				Random rand=new Random(); 
				int x=rand.nextInt(2);
				if(x==0)
				{
					this.SinglePointcrossOver(ChromosomeClust.get(randomSequenceupper[k]),ChromosomeClust.get(randomSequenceupper[q]),childarray);
				}
				else
				{
					this.MultiplePointcrossOver(ChromosomeClust.get(randomSequenceupper[k]),ChromosomeClust.get(randomSequenceupper[q]),childarray);
				}
				Childs.add(childarray[0]);
				Childs.add(childarray[1]);
				k++;
				q--;
			}
			else
			{
				Random rand=new Random(); 
				int x=rand.nextInt(2);
				if(x==0)
				{
					this.SinglePointcrossOver(ChromosomeClust.get(randomSequenceupper[q]),ChromosomeClust.get(randomSequenceupper[k]),childarray);
				}
				else
				{
					this.MultiplePointcrossOver(ChromosomeClust.get(randomSequenceupper[q]),ChromosomeClust.get(randomSequenceupper[k]),childarray);
				}
				Childs.add(childarray[0]);
				Childs.add(childarray[1]);

				k++;
				q--;
			}
		}
		
//		int y = 0; 
//		int g = (lowerhalf-Childs.size());
//		while(y< g)  // generating childs by using mutation
//		{
//			Chromosome child = new Chromosome(); 
//			child = this.Mutation(ChromosomeClust.get(randomSequencelower[y]));
//			Childs.add(child);
//			y++;
//		}
		
//		System.out.println("Printing Childs");
//		for(int h = 0 ; h < Childs.size() ; h++)
//		{
//			Childs.get(h).printing();
//			System.out.println("");
//		}
		
		double mutationtemp = size*0.1;  
		int mutationcounter = (int) mutationtemp;
		
		for(int m = 0 ; m < mutationcounter ; m++)
		{
			Chromosome childmutated = new Chromosome();
			
			childmutated = this.Mutation(Childs.get(m));
			Childs.set(m, childmutated);
		}
		
		int childscounter = 0;
		int clustcounter = 0;
		
		while(clustcounter < upperhalf)
		{
			ChromosomeClust.set(clustcounter, Childs.get(childscounter));
			clustcounter++;
			childscounter++;
		}
		
//		System.out.println("Printing Cluster after adding Childs");
//		for(int h = 0 ; h < ChromosomeClust.size() ; h++)
//		{
//			ChromosomeClust.get(h).printing();
//			System.out.println("");
//
//		}
		
//		this.SinglePointcrossOver(ChromosomeClust.get(0), ChromosomeClust.get(upperhalf),upperhalf);
		
//		this.MultiplePointcrossOver(ChromosomeClust.get(0), ChromosomeClust.get(upperhalf));
		
//		System.out.println("*************In Class Evolution : Method SingleClusterEvolution***************");
//		Chromosome child = new Chromosome(); 
//		child = this.Mutation(ChromosomeClust.get(24));
		
		
		
//		char [][] tempmatrix ={{'C' , 'P' , 'A'} , {'A' , 'A' , 'A'}, {'P' , 'P' , 'P'}};
		
//		tempmatrix = ChromosomeClust.get(0).getMatrix();
		
//		for(int i=0 ; i< ChromosomeClust.get(0).getRows() ; i++)
//		{
//			for(int j =0 ; j < ChromosomeClust.get(0).getColumns() ; j++)
//			{
//				if(tempmatrix[i][j] == '2')
//				{
//					System.out.print("-");
//					System.out.print(" ");
//				}
//				else
//				{
//					System.out.print(tempmatrix[i][j]);
//					System.out.print(" ");
//				}
//			}
//			
//			System.out.println();
//		}
		
//		Chromosome temp = new Chromosome(3,3);
//		
//		temp.setMatrix(tempmatrix);
//
//		temp.printing();
	}
	
	
	private void SinglePointcrossOver(Chromosome p1 , Chromosome p2 , Chromosome childarray[])
	{
		System.out.println("*************In Class Evolution : Method Single Point Crossover***************");
		char [][] matrixc1;
		char [][] matrixc2;
		char [][] matrixp1;
		char [][] matrixp2;
		
		matrixp1 = p1.getMatrix();
		matrixp2 = p2.getMatrix();
					
		char [][] matrixA1;
		char [][] matrixA2;
		char [][] matrixB1;
		char [][] matrixB2;
		
		int p1score = p1.getscore();
		int p2score = p2.getscore();		
		
		Random r = new Random();

		int A1columnsize = 0;
		int A2columnsize = 0;
		
			int randompoint = r.nextInt((p1.getColumns()/2+2) - 3) + 3;
			A1columnsize = randompoint;
			A2columnsize = p1.getColumns() - randompoint;
			matrixA1 = new char[p1.getRows()][A1columnsize];
			matrixA2 = new char[p1.getRows()][A2columnsize];
			for(int i = 0 ; i < p1.getRows();i++) // Making matrix A1
			{
				for(int j = 0 ; j < randompoint ; j++)
				{
					matrixA1[i][j] = p1.Matrix[i][j];
				}
			}
			
			for(int y = 0 ; y < p1.getRows() ; y++) // Making matrix A2
			{
				int a1counter = 0;
				for(int a = randompoint ; a < p1.getColumns() ; a++)
				{
					matrixA2[y][a1counter] = p1.Matrix[y][a];
					a1counter++;
				}
			}
						
			int [] A1rowssizes = new int [p1.getRows()]; 
			for(int h = 0 ; h < p1.getRows() ; h++)   // Calculating A1 row sizes
			{
				for(int q = 0 ; q < randompoint ; q++)
				{
					if(p1.Matrix[h][q] != '2')
					{
						A1rowssizes[h]++;
					}
				}				
			}
			int [] B1rowssizes = new int[p2.getRows()];
			for(int f = 0 ; f < A1rowssizes.length ; f++)  // Calculating B1 Row Sizes 
			{
				int w = 0;
				int counterp2 = 0;
				while(w < A1rowssizes[f])
				{
					if(p2.Matrix[f][counterp2] != '2')
					{
						w++;
					}
					counterp2++;
					B1rowssizes[f]++;
				}
			}
			int B1colsize = 0;
			for(int g = 0 ; g < B1rowssizes.length ; g++)  // Calculating column sizes for B1
			{
				if(B1colsize < B1rowssizes[g])
				{
					B1colsize = B1rowssizes[g];
				}
			}
			matrixB1 = new char [p2.getRows()][B1colsize];
			
			int B2columnsize = 0;
			for(int z = 0 ; z < B1rowssizes.length ; z++)  // Calculating column size for B2
			{
				if(p2.Matrix[z][B1rowssizes[z]] !='2')
				{
					int size = p2.getColumns() - B1rowssizes[z];
					if(B2columnsize < size)
					{
						B2columnsize = size;
					}
				}
				else
				{
					int size = p2.getColumns() - B1rowssizes[z];
					int q = B1rowssizes[z];
					int g = 0;
					while(p2.Matrix[z][q] == '2')
					{
						q++;
						g++;
					}
					size = size - g;
					if(B2columnsize < size)
					{
						B2columnsize = size;
					}
				}
			}
			
			matrixB2 = new char [p2.getRows()][B2columnsize];
			
			for(int n = 0 ; n < p2.getRows() ; n ++) 
			{
				for(int m =0 ; m< B2columnsize ; m++)
				{
					matrixB2[n][m] = '2';
				}
			}
			
			
			for(int x = 0 ; x < p2.getRows() ; x++)   // Making matrix B1 
			{
				int h = 0;
				while(h < B1rowssizes[x])
				{
					matrixB1[x][h] = p2.Matrix[x][h];
					h++;
				}
				while(h < B1colsize)
				{
					matrixB1[x][h] = '2';
					h++;
				}
			}
			
			for(int p = 0 ; p < p2.getRows() ; p++)          // Making matrix B2 
			{
				int B2rowlength = p2.getColumns()- B1rowssizes[p];
				int counter = 0;
				if(B2columnsize > B2rowlength)
				{
					int gap = B2columnsize - B2rowlength;
					while(counter < gap)
					{
						matrixB2[p][counter] = '2';
						counter++;
					}
					int pointerB2Array = B1rowssizes[p];
					while(pointerB2Array < p2.getColumns())
					{
						matrixB2[p][counter] = p2.Matrix[p][pointerB2Array];
						pointerB2Array++;
						counter++;
					}				
				}
				else if( B2columnsize < B2rowlength)
				{
					int gap = B2rowlength - B2columnsize;
					int pointerB2Array = B1rowssizes[p];
					int j = 0;
					while(j<gap)
					{
						pointerB2Array++;
						j++;
					}
					while(pointerB2Array < p2.getColumns())
					{
						matrixB2[p][counter] = p2.Matrix[p][pointerB2Array];
						pointerB2Array++;
						counter++;
					}
					
				}
				else
				{
					int pointerB2Array = B1rowssizes[p];
					while(pointerB2Array < p2.getColumns())
					{
						matrixB2[p][counter] = p2.Matrix[p][pointerB2Array];
						pointerB2Array++;
						counter++;
					}
				}
			}
			
		
		matrixc1 = new char[p1.getRows()][B2columnsize+A1columnsize];
		matrixc2 = new char[p2.getRows()][A2columnsize+B1colsize];
		
		for(int rowc1 = 0 ; rowc1< p1.getRows() ; rowc1++)
		{
			int a1counter = 0;
			int c1counter = 0;
			while(a1counter < A1columnsize)
			{
				matrixc1[rowc1][c1counter] = matrixA1[rowc1][a1counter];
				a1counter++;
				c1counter++;
			}
			int b2counter = 0;
			while(b2counter < B2columnsize)
			{
				matrixc1[rowc1][c1counter] = matrixB2[rowc1][b2counter];
				b2counter++;
				c1counter++;
			}
		}
		
		for(int rowc2 = 0 ; rowc2< p2.getRows() ; rowc2++)
		{
			int b1counter = 0;
			int c2counter = 0;
			while(b1counter < B1colsize)
			{
				matrixc2[rowc2][c2counter] = matrixB1[rowc2][c2counter];
				b1counter++;
				c2counter++;
			}
			int a2counter = 0;
			while(a2counter < A2columnsize)
			{
				matrixc2[rowc2][c2counter] = matrixA2[rowc2][a2counter];
				a2counter++;
				c2counter++;
			}
		}
		
		Chromosome c1 = new Chromosome(p1.getRows() , B2columnsize+A1columnsize);
		c1.setMatrix(matrixc1);
		Chromosome c2 = new Chromosome(p2.getRows() , A2columnsize+B1colsize);
		c2.setMatrix(matrixc2);
		
		childarray[0]=c1;
		childarray[1]=c2;
	}
	
	
	private void MultiplePointcrossOver(Chromosome p1 , Chromosome p2 , Chromosome [] childarray)
	{
		System.out.println("In Class Evolution : Function: MultiplePointCrossOver");
		
		double tempp1 = p1.getColumns();
		double tempp2 = p2.getColumns();
		
		double p1point = (25*tempp1)/100;
		double p2point = (25*tempp2)/100;
		
		p1point = Math.ceil(p1point);
		p2point = Math.ceil(p2point);
		
				
		int p1cutpoint = (int)p1point;
		int p2cutpoint = (int)p2point;
		
		char [][] tempMatrixp1 = new char [p1.getRows()][p1cutpoint];
		char [][] tempMatrixp2 = new char [p2.getRows()][p2cutpoint];
		BlossumMatrix obj = new BlossumMatrix();
		
		for(int x = 0 ; x< p1.getRows() ; x++)
		{
			for(int y = 0 ; y < p1cutpoint ; y++)
			{
				tempMatrixp1[x][y] = p1.Matrix[x][y];
			}
		}
		

		for(int x = 0 ; x< p2.getRows() ; x++)
		{
			for(int y = 0 ; y < p2cutpoint ; y++)
			{
				tempMatrixp2[x][y] = p2.Matrix[x][y];
			}
		}
		
		
		int scoretempMatrixp1 = obj.CalculateMatrixScore(tempMatrixp1, p1.getRows(), p1cutpoint);
		int scoretempMatrixp2 = obj.CalculateMatrixScore(tempMatrixp2, p2.getRows(), p2cutpoint);
		
		Chromosome child = new Chromosome();
		
		if(scoretempMatrixp1 >= scoretempMatrixp2)
		{
			this.SplitMatrices(p1, p2, p1cutpoint,childarray);
		}
		else
		{
			 this.SplitMatrices(p2, p1, p2cutpoint,childarray);
		}
//		for(int h = 0 ; h <p1.getRows(); h++)
//		{
//			for(int u =0 ; u< p2cutpoint ; u++)
//			{
//				if(tempMatrixp2[h][u] == '2')
//				{
//					System.out.print("-");
//					System.out.print(" ");
//				}
//				else
//				{
//					System.out.print(tempMatrixp2[h][u]);
//					System.out.print(" ");
//				}
//
//			}
//			System.out.println();
			
//		}
		

		
		
	}
	
private Chromosome Mutation(Chromosome p)
{
	System.out.println("In class evolution : Mutation: Chromsome printing before mutation");
	
	
	
	char tempMatrix[][] = p.getMatrix();	
	for(int i = 0 ; i < p.getRows() ; i++)
	{
		int j = 0;
		while(tempMatrix[i][j] !='2' && j < p.getColumns())
		{
			j++;
			if(j == p.getColumns())
			{
				break;
			}
		}
		if(j== p.getColumns())
		{
			continue;
		}
		int k=j+1;
		while(tempMatrix[i][k-1] =='2' && k < p.getColumns())
		{
			k++;
		}
		
		char tempchar = tempMatrix[i][j];
		tempMatrix[i][j] = tempMatrix[i][k-1];
		tempMatrix[i][k-1] = tempchar;		
	}	
	p.setMatrix(tempMatrix);
	
	return p;
}


private void SplitMatrices(Chromosome  p1 , Chromosome p2 , int cutpoint,Chromosome childarray[] )
{
	char [][] matrixc1;
	char [][] matrixc2;
	char [][] matrixp1;
	char [][] matrixp2;
	
	matrixp1 = p1.getMatrix();
	matrixp2 = p2.getMatrix();
				
	char [][] matrixA1;
	char [][] matrixA2;
	char [][] matrixB1;
	char [][] matrixB2;
	
	int p1score = p1.getscore();
	int p2score = p2.getscore();		
	
	Random r = new Random();

	int A1columnsize = 0;
	int A2columnsize = 0;
	
		int randompoint = r.nextInt((p1.getColumns()/2+2) - 3) + 3;
		A1columnsize = randompoint;
		A2columnsize = p1.getColumns() - randompoint;
		matrixA1 = new char[p1.getRows()][A1columnsize];
		matrixA2 = new char[p1.getRows()][A2columnsize];
		for(int i = 0 ; i < p1.getRows();i++) // Making matrix A1
		{
			for(int j = 0 ; j < randompoint ; j++)
			{
				matrixA1[i][j] = p1.Matrix[i][j];
			}
		}
		
		for(int y = 0 ; y < p1.getRows() ; y++) //Making matrix A2
		{
			int a1counter = 0;
			for(int a = randompoint ; a < p1.getColumns() ; a++)
			{
				matrixA2[y][a1counter] = p1.Matrix[y][a];
				a1counter++;
			}
		}
					
		int [] A1rowssizes = new int [p1.getRows()]; 
		for(int h = 0 ; h < p1.getRows() ; h++)   // Calculating A1 row sizes
		{
			for(int q = 0 ; q < randompoint ; q++)
			{
				if(p1.Matrix[h][q] != '2')
				{
					A1rowssizes[h]++;
				}
			}				
		}
		int [] B1rowssizes = new int[p2.getRows()];
		for(int f = 0 ; f < A1rowssizes.length ; f++)  // Calculating B1 Row Sizes 
		{
			int w = 0;
			int counterp2 = 0;
			while(w < A1rowssizes[f])
			{
				if(p2.Matrix[f][counterp2] != '2')
				{
					w++;
				}
				counterp2++;
				B1rowssizes[f]++;
			}
		}
		int B1colsize = 0;
		for(int g = 0 ; g < B1rowssizes.length ; g++)  // Calculating column sizes for B1
		{
			if(B1colsize < B1rowssizes[g])
			{
				B1colsize = B1rowssizes[g];
			}
		}
		matrixB1 = new char [p2.getRows()][B1colsize];
		
		int B2columnsize = 0;
		for(int z = 0 ; z < B1rowssizes.length ; z++)  // Calculating column size for B2
		{
			if(p2.Matrix[z][B1rowssizes[z]] !='2')
			{
				int size = p2.getColumns() - B1rowssizes[z];
				if(B2columnsize < size)
				{
					B2columnsize = size;
				}
			}
			else
			{
				int size = p2.getColumns() - B1rowssizes[z];
				int q = B1rowssizes[z];
				int g = 0;
				while(p2.Matrix[z][q] == '2')
				{
					q++;
					g++;
				}
				size = size - g;
				if(B2columnsize < size)
				{
					B2columnsize = size;
				}
			}
		}
		
		matrixB2 = new char [p2.getRows()][B2columnsize];
		
		for(int n = 0 ; n < p2.getRows() ; n ++)
		{
			for(int m =0 ; m< B2columnsize ; m++)
			{
				matrixB2[n][m] = '2';
			}
		}
		
		
		for(int x = 0 ; x < p2.getRows() ; x++)
		{
			int h = 0;
			while(h < B1rowssizes[x])
			{
				matrixB1[x][h] = p2.Matrix[x][h];
				h++;
			}
			while(h < B1colsize)
			{
				matrixB1[x][h] = '2';
				h++;
			}
		}
		
		for(int p = 0 ; p < p2.getRows() ; p++)
		{
			int B2rowlength = p2.getColumns()- B1rowssizes[p];
			int counter = 0;
			if(B2columnsize > B2rowlength)
			{
				int gap = B2columnsize - B2rowlength;
				while(counter < gap)
				{
					matrixB2[p][counter] = '2';
					counter++;
				}
				int pointerB2Array = B1rowssizes[p];
				while(pointerB2Array < p2.getColumns())
				{
					matrixB2[p][counter] = p2.Matrix[p][pointerB2Array];
					pointerB2Array++;
					counter++;
				}				
			}
			else if( B2columnsize < B2rowlength)
			{
				int gap = B2rowlength - B2columnsize;
				int pointerB2Array = B1rowssizes[p];
				int j = 0;
				while(j < gap)
				{
					pointerB2Array++;
					j++;
				}
				while(pointerB2Array < p2.getColumns())
				{
					matrixB2[p][counter] = p2.Matrix[p][pointerB2Array];
					pointerB2Array++;
					counter++;
				}
				
			}
			else
			{
				int pointerB2Array = B1rowssizes[p];
				while(pointerB2Array < p2.getColumns())
				{
					matrixB2[p][counter] = p2.Matrix[p][pointerB2Array];
					pointerB2Array++;
					counter++;
				}
			}
		}
		
		BlossumMatrix obj = new BlossumMatrix();
		

		
		Chromosome child = new Chromosome();
		
	    this.createChild(matrixA1,randompoint, matrixA2 ,A2columnsize,p1.getRows(), matrixB1,B1colsize, matrixB2 , B2columnsize , p2.getRows() , childarray);
		
	
}

private void createChild(char A1[][] ,int A1columnsize ,char A2[][], int A2columnsize,int A2rows , char B1[][] ,int B1columnsize , char B2[][] ,int B2columnsize , int B2rows , Chromosome [] childarray)
{
	Chromosome child = new Chromosome();
	
	double p1point = (25*A2columnsize)/100;
	double p2point = (25*B2columnsize)/100;
	
	p1point = Math.ceil(p1point);
	p2point = Math.ceil(p2point);
	
			
	int p1cutpoint = (int)p1point;
	int p2cutpoint = (int)p2point;
	
	char [][] tempMatrixa2 = new char [A2rows][p1cutpoint];
	char [][] tempMatrixb2 = new char [B2rows][p2cutpoint];
	BlossumMatrix obj = new BlossumMatrix();
	
	for(int x = 0 ; x< A2rows ; x++)
	{
		int tempmatrixa2counter = p1cutpoint-1;
		for(int y = A2columnsize-1 ; y >= (A2columnsize-p1cutpoint) ; y--)
		{
			tempMatrixa2[x][tempmatrixa2counter] = A2[x][y];
			tempmatrixa2counter--;
		}
	}
	
	
	for(int x = 0 ; x< B2rows ; x++)
	{
		int tempmatrixb2counter = p2cutpoint-1;
		for(int y = B2columnsize-1 ; y >= (B2columnsize-p2cutpoint) ; y--)
		{
			tempMatrixb2[x][tempmatrixb2counter] = B2[x][y];
			tempmatrixb2counter--;
		}
	}
	
	int scoretempMatrixa1 = obj.CalculateMatrixScore(tempMatrixa2, A2rows, p1cutpoint);
	int scoretempMatrixb2 = obj.CalculateMatrixScore(tempMatrixb2, B2rows, p2cutpoint);
	
		int A3columnsize = p1cutpoint;
		int A2newcolumnsize = A2columnsize - p1cutpoint;
		char matrixA2new[][] = new char[A2rows][A2newcolumnsize];
		char matrixA3[][] = new char[A2rows][A3columnsize];
		for(int i = 0 ; i < A2rows ; i++) // Making matrix A3
		{
			int matrixa3counter = A3columnsize -1;
			for(int j = A2columnsize-1 ; j >= (A2columnsize-p1cutpoint) ; j--)
			{
				matrixA3[i][matrixa3counter] = A2[i][j];
				matrixa3counter--;
			}
		}
		

		for(int y = 0 ; y < A2rows ; y++) //Making matrix A2 new
		{
			int a1counter = A2newcolumnsize-1;
			for(int a = (A2columnsize - p1cutpoint)-1 ; a >= 0 ; a--)
			{
				matrixA2new[y][a1counter] = A2[y][a];
				a1counter--;
			}
		}
		
		int [] A3rowssizes = new int [A2rows]; 
		for(int h = 0 ; h < A2rows ; h++)   // Calculating A3 row sizes
		{
			for(int q = A3columnsize-1 ; q >=0 ; q--)
			{
				if(matrixA3[h][q] != '2')
				{
					A3rowssizes[h]++;
				}
			}				
		}
		
		int [] B3rowssizes = new int[B2rows];
		for(int f = 0 ; f < A3rowssizes.length ; f++)  // Calculating B3 Row Sizes 
		{
			int w = 0;
			int counterb2 = B2columnsize-1;
			while(w < A3rowssizes[f])
			{
				if(B2[f][counterb2] != '2')
				{
					w++;
				}
				counterb2--;
				B3rowssizes[f]++;
			}
		}
		
		int B3colsize = 0;
		for(int g = 0 ; g < B3rowssizes.length ; g++)  // Calculating column size for B3
		{
			if(B3colsize < B3rowssizes[g])
			{
				B3colsize = B3rowssizes[g];
			}
		}
		char matrixB3[][] = new char [B2rows][B3colsize];
		
		int B2newcolumnsize = 0;
		for(int z = 0 ; z < B3rowssizes.length ; z++)  // Calculating column size for B2 new
		{
			if(B2[z][(B2columnsize-B3rowssizes[z])-1] !='2')
			{
				int size = B2columnsize - B3rowssizes[z];
				if(B2newcolumnsize < size)
				{
					B2newcolumnsize = size;
				}
			}
			else
			{
				int size = B2columnsize - B3rowssizes[z];
				int q = (B2columnsize-B3rowssizes[z])-1;
				int g = 0;
				while(B2[z][q] == '2') //e
				{
					q--;
					g++;
					if(q == -1)
					{
						break;
					}
				}
				size = size - g;
				if(B2newcolumnsize < size)
				{
					B2newcolumnsize = size;
				}
			}
		}
		
		char matrixB2new[][] = new char [B2rows][B2newcolumnsize];
		
		for(int n = 0 ; n < B2rows ; n ++) 
		{
			for(int m =0 ; m< B2newcolumnsize ; m++)
			{
				matrixB2new[n][m] = '2';
			}
		}
		
		
		for(int x = 0 ; x < B2rows ; x++)  // Making B3 matrix    
		{
			int h = 0;
			int k = B2columnsize-1;
			int q = B3colsize-1;
			while(h < B3rowssizes[x])
			{
				matrixB3[x][q] = B2[x][k];
				h++;
				k--;
				q--;
			}
			while(h < B3colsize)
			{
				matrixB3[x][q] = '2';
				h++;
				q--;
			}
		}
		
		for(int p = 0 ; p < B2rows ; p++)          // Making matrix B2 new
		{
			int B2rowlength = B2columnsize- B3rowssizes[p];
			int counter = B2newcolumnsize-1;
			if(B2newcolumnsize > B2rowlength)
			{
				int gap = B2newcolumnsize - B2rowlength;
				int gapcounter=0;
				while(gapcounter < gap)
				{
					matrixB2new[p][counter] = '2';
					counter--;
					gapcounter++;
				}
				int pointerB2Array = (B2columnsize-B3rowssizes[p])-1;
				while(pointerB2Array >= 0)
				{
					matrixB2new[p][counter] = B2[p][pointerB2Array];
					pointerB2Array--;
					counter--;
				}				
			}
			else if( B2newcolumnsize < B2rowlength)
			{
				int gap = B2rowlength - B2newcolumnsize;
				int pointerB2Array = (B2columnsize-B3rowssizes[p])-1;
				int j = 0;
				while(j < gap)
				{
					pointerB2Array--;
					j++;
				}
				while(pointerB2Array >= 0)
				{
					matrixB2new[p][counter] = B2[p][pointerB2Array];
					pointerB2Array--;
					counter--;
				}
				
			}
			else
			{
				int pointerB2Array = (B2columnsize-B3rowssizes[p])-1;
				while(pointerB2Array >= 0)
				{
					matrixB2new[p][counter] = B2[p][pointerB2Array];
					pointerB2Array--;
					counter--;
				}
			}
		}
		
		char matrixc1[][] = new char[A2rows][A1columnsize+B2newcolumnsize+ A3columnsize];
		char matrixc2[][] = new char[B2rows][B1columnsize+A2newcolumnsize+ B3colsize];
		
		for(int rowc1 = 0 ; rowc1< A2rows ; rowc1++)
		{
			int a1counter = 0;
			int c1counter = 0;
			while(a1counter < A1columnsize)
			{
				matrixc1[rowc1][c1counter] = A1[rowc1][a1counter];
				a1counter++;
				c1counter++;
			}
			int b2counter = 0;
			while(b2counter < B2newcolumnsize)
			{
				matrixc1[rowc1][c1counter] = matrixB2new[rowc1][b2counter];
				b2counter++;
				c1counter++;
			}
			
			int a3counter = 0;
			while(a3counter < A3columnsize)
			{
				matrixc1[rowc1][c1counter] = matrixA3[rowc1][a3counter];
				a3counter++;
				c1counter++;
			}
		}
		
		for(int rowc2 = 0 ; rowc2< B2rows ; rowc2++)
		{
			int b1counter = 0;
			int c2counter = 0;
			while(b1counter < B1columnsize)
			{
				matrixc2[rowc2][c2counter] = B1[rowc2][b1counter];
				b1counter++;
				c2counter++;
			}
			int a2counter = 0;
			while(a2counter < A2newcolumnsize)
			{
				matrixc2[rowc2][c2counter] = matrixA2new[rowc2][a2counter];
				a2counter++;
				c2counter++;
			}
			int a3counter = 0;
			while(a3counter < B3colsize)
			{
				matrixc2[rowc2][c2counter] = matrixB3[rowc2][a3counter];
				a3counter++;
				c2counter++;
			}
		}
		
		Chromosome c1 = new Chromosome(A2rows , A1columnsize+B2newcolumnsize+ A3columnsize);
		c1.setMatrix(matrixc1);
		Chromosome c2 = new Chromosome(B2rows , B1columnsize+A2newcolumnsize+ B3colsize);
		c2.setMatrix(matrixc2);
		
		int c1score = c1.calculateScore();
		int c2score = c2.calculateScore();
		
        childarray[0]= c1;
        childarray[1]= c2;


}

}
