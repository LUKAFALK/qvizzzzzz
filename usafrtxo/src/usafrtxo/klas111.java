package usafrtxo;

public class klas111 {

    private double[][] matrix;
    private int n;

    public klas111(double[][] matrix) {
        this.matrix = matrix;
        this.n = matrix.length;
    }
        public double[] vonebisGamotvla() {
            double[] columnsums = new double[n];
            
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    columnsums[j] += matrix[i][j];
                }
            }

            double[] weights = new double[n];
            for (int i = 0; i < n; i++) {
                double rowsum = 0;
                for (int j = 0; j < n; j++) {
                    rowsum += matrix[i][j] / columnsums[j];
                }
                weights[i] = rowsum / n;
            }
            
            return weights;
        }
            
        public double tanmimdevrobisKoeficienti() {

            double[] weights = vonebisGamotvla();
            
            double[] aw = new double[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    aw[i] += matrix[i][j] * weights[j];
                }
            }
            double max = 0;
            for (int i = 0; i < n; i++) {
                max += aw[i] / weights[i];
            }
            max /= n;

            double ci = (max - n) / (n - 1);

            double[] ritable = {0.0, 0.0, 0.58, 0.90, 1.12, 1.24, 1.32, 1.41, 1.45, 1.49};
            double ri = (n < ritable.length) ? ritable[n - 1] : 1.49;

            if (ri == 0) return 0.0;

            return ci / ri;
        }
   


    public static void main(String[] args) {
        double[][] matrix = {
            {1.0,  6.0,  3.0, 0.5,  3.0,  2.0,  5.0},
            {0.5,  1.0,  2.0, 0.33, 3.0,  1.0,  4.0},
            {0.33, 0.5,  1.0, 0.25, 1.0,  0.5,  3.0},
            {2.0,  3.0,  4.0, 1.0,  4.0,  3.0,  4.0},
            {0.33, 0.25,  1.0, 0.25, 1.0,  0.5,  1.0},
            {0.,  1.0,  0.25, 0.33, 2.0,  1.0,  2.0},
            {0.2, 0.5,  2.0, 0.25, 1.0,  0.5,  1.0}
        };
        klas111 p1 = new klas111(matrix);
        double wonebi[]=p1.vonebisGamotvla();
        for (int i = 0; i < wonebi.length; i++) {
            System.out.println( (i + 1)+"  "+ wonebi[i]);
        }
        double cr = p1.tanmimdevrobisKoeficienti();
        System.out.printf("CR = "+ cr);

      
    }
}