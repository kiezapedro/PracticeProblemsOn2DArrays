public class SaddlePrice {
    // Function to find saddle price of the matrix
    public static Integer findSaddlePrice(int[][] matrix, int n) {
        // Traverse each row to find minimum value in a row
        for (int i = 0; i < n; i++) {
            int minValue = matrix[i][0];
            int minColIndex = 0;

            // Find the minimum value in row i
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < minValue) {
                    minValue = matrix[i][j];
                    minColIndex = j;
                }
            }

            // Check if the minimum element in the row is the largest in its column
            boolean isSaddlePrice = true;
            for (int k = 0; k < n; k++) {
                if (matrix[k][minColIndex] > minValue) {
                    isSaddlePrice = false;
                    break;
                }
            }

            // Return minimum element if it is the largest in the column
            if (isSaddlePrice) {
                return minValue;
            }
        }

        // Return null if there is no saddle price found
        return null;
    }

    public static void main(String[] args) {
        // Example
        int n = 3;
        int[][] matrix = {
                { 3, 8, 1 },
                { 9, 5, 6 },
                { 7, 4, 2 }
        };

        Integer saddlePrice = findSaddlePrice(matrix, n);

        if (saddlePrice != null) {
            System.out.println("Saddle Price: " + saddlePrice);
        } else {
            System.out.println("No saddle price found.");
        }
    }
}
