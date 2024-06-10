import java.util.Arrays;

public class Matrix {
    //Matrix Class is an Arrays with Complex object entries
    public static String displayMatrix(ComplexNumber [][] mat){
        String output = "";
        for (ComplexNumber[] row: mat){
            output += Arrays.toString(row) + "\n";
        }
        return output;
    }
    public static ComplexNumber[] matrixMultiplication(ComplexNumber[][] nn, ComplexNumber[] n1){
        int n = nn.length;
        ComplexNumber [] temp = new ComplexNumber [n]; 
        for(int row = 0; row < n;row++){
            temp[row] = new ComplexNumber(0,0);
            for(int col = 0; col < n; col++){
                temp[row].add(ComplexNumber.multiply(nn[row][col], n1[col]));
            }
        }
        return temp;
    }
    public static ComplexNumber [] matrixMultiplication(ComplexNumber[][] nn, ComplexNumber[] n1, int n){
        ComplexNumber [] v = new ComplexNumber [nn.length];
        if (n == 0){
            return n1;
        }
        else{
            return matrixMultiplication(nn, matrixMultiplication(nn, n1, n-1));
        }
    }
    public static String displayMatrix(ComplexNumber [] mat){
        String output = "[";
        for (ComplexNumber row: mat){
            output += row.toString() + "\n" + ", ";
        }
        return output.substring(0, output.length()-2) + "]";
    }
    public static ComplexNumber [] normalizeMatrix(ComplexNumber[] n1){
        ComplexNumber [] v = new ComplexNumber [n1.length]; 
        double sum = 0;
        for (int i = 0; i < n1.length; i++){
            sum += Math.pow(n1[i].mod(), 2);
        }
        sum = Math.pow(sum, (0.5));
        ComplexNumber temp = new ComplexNumber(sum,0);
        for (int j = 0; j < n1.length; j++){
            v[j] = ComplexNumber.divide(n1[j], temp);
        }
        return v;
    }
}
