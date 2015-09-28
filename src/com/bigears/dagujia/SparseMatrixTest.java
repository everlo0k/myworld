package com.bigears.dagujia;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SparseMatrixTest 
{
    public static SparseMatrix readMatrix(String filename) throws IOException
    {      
        Scanner sc1 = new Scanner(new File(filename));
        int row = sc1.nextInt();
        int col = sc1.nextInt();
        int n = sc1.nextInt();
        
        SparseMatrix m = new SparseMatrix(row, col);
        
        for (int i = 0; i < n; i++)
        {
            int r = sc1.nextInt();
            int c = sc1.nextInt();
            double v = sc1.nextDouble();
            
            m.setValue(r, c, v);
        }
        
        sc1.close(); 
        
        return m;
    }
    
    public static void main(String[] args) throws IOException
    {   
        String filename1 = "d:\\matrix1.txt"; 
        String filename2 = "d:\\matrix2.txt";        
        
        SparseMatrix m1 = readMatrix(filename1);
        System.out.println("SparseMatrix 1:");
        System.out.println(m1);    
        m1.setValue(0, 3, 5);
        
        System.out.println("");
        SparseMatrix m2 = readMatrix(filename2);
        System.out.println("SparseMatrix 2:");
        System.out.println(m2);  
                
        System.out.println("");
        SparseMatrix m3 = m1.add(m2);
        System.out.println("SparseMatrix 3:");
        System.out.println(m3);    
                
        System.out.println("\nTest setValue()\n");
        m3.setValue(2, 3, 1.9);
        m3.setValue(1, 5, 0);

        System.out.println("SparseMatrix 2:");
        System.out.println(m2); 
        System.out.println("");
        System.out.println("SparseMatrix 3:");
        System.out.println(m3);                
    }    
}
