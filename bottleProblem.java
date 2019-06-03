
package Algo2;

import java.util.Arrays;


public class Bottle_FW {

    public static int findIndex(int i, int j, int q) {
        return i * q + j;
    }

    
    public static boolean[][] BuildMat(int n, int m) {
        int size = (n + 1) * (m + 1);
        boolean[][] mat = new boolean[size][size];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                int row = findIndex(i, j, m + 1);
                mat[row][findIndex(0, j, m + 1)] = true;
                mat[row][findIndex(i, 0, m + 1)] = true;
                mat[row][findIndex(i, m, m + 1)] = true;
                mat[row][findIndex(n, j, m + 1)] = true;
                mat[row][findIndex(Math.max(0, i + j - m), Math.min(i + j, m), m + 1)] = true;
                mat[row][findIndex(Math.min(i + j, n), Math.max(0, i + j - n), m + 1)] = true;
            }
        }
        return mat;
    }

    public static void FloydW(boolean[][] mat) {
        int n = mat.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = (mat[i][j] || (mat[i][k] && mat[k][j]));
                }
            }
        }
    }
    
    public static int numOfTiesElement(boolean [][] mat){
        int num=0;
        int [] c=new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            if(c[i]==0){
                num++;
                c[i]=num;
            }
            for (int j = 0; j < mat.length; j++) {
                if(c[j]==0 && mat[i][j]) c[j]=num;
            }
        }
        return num;
    }
    
    public static void main(String[] args) {
        boolean [][] mat=BuildMat(1, 2);
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
        FloydW(mat);
        System.out.println("//////////////////");
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
        System.out.println("num of ties element: "+numOfTiesElement(mat));
    }
}
