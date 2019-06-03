public class bottleProblem{

     public static void main(String []args){
         boolean test [][]= bottleProblem(1,2);
         for (int i=0;i<6;i++){
        for(int j=0;j<6;j++){
           System.out.println(test[i][j]);

        }
         }
         
     }
public static boolean [][] bottleProblem(int n,int m){
    int size= (n+1)*(m+1);
    boolean matrix [][]=new boolean [size][size];
    for (int i=0;i<size;i++){
        for(int j=0;j<size;j++){
         int row = findeIndex(i,j,m+1);
         matrix[row][findeIndex(0,j,m+1)]=true;
         matrix[row][findeIndex(i,0,m+1)]=true;
         matrix[row][findeIndex(i,m,m+1)]=true;
         matrix[row][findeIndex(n,j,m+1)]=true;
         matrix[row][findeIndex(i+j-Math.min(i+j,n),Math.min(i+j,n),m+1)]=true;
         matrix[row][findeIndex(Math.min(i+j,m),i+j - Math.min(i+j,m),m+1)]=true;

         
        }
        
    }
    return matrix;
}
public static int findeIndex(int i,int j, int p){
    return p*i+j;
}
}
