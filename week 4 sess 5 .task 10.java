import java.io.*;
import java.util.*;

class Result {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        // Create result matrix
        int[][] result = new int[m][n];

        // Number of layers
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            // Top row
            for (int j = layer; j < n - layer; j++) {
                elements.add(matrix.get(layer).get(j));
            }

            // Right column
            for (int i = layer + 1; i < m - layer; i++) {
                elements.add(matrix.get(i).get(n - layer - 1));
            }

            // Bottom row
            for (int j = n - layer - 2; j >= layer; j--) {
                elements.add(matrix.get(m - layer - 1).get(j));
            }

            // Left column
            for (int i = m - layer - 2; i > layer; i--) {
                elements.add(matrix.get(i).get(layer));
            }

            int size = elements.size();
            int rotations = r % size;

            int index = 0;

            // Top row
            for (int j = layer; j < n - layer; j++) {
                result[layer][j] = elements.get((index + rotations) % size);
                index++;
            }

            // Right column
            for (int i = layer + 1; i < m - layer; i++) {
                result[i][n - layer - 1] =
                        elements.get((index + rotations) % size);
                index++;
            }

            // Bottom row
            for (int j = n - layer - 2; j >= layer; j--) {
                result[m - layer - 1][j] =
                        elements.get((index + rotations) % size);
                index++;
            }

            // Left column
            for (int i = m - layer - 2; i > layer; i--) {
                result[i][layer] =
                        elements.get((index + rotations) % size);
                index++;
            }
        }

        // Print the result
        for (int i = 0; i < m; i++) {
            StringBuilder output = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    output.append(" ");
                }
                output.append(result[i][j]);
            }

            System.out.println(output);
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput =
                bufferedReader.readLine().trim().split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] values = bufferedReader.readLine().trim().split(" ");
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(Integer.parseInt(values[j]));
            }

            matrix.add(row);
        }

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}

output:
nput (stdin)
4 4 1
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
Your Output (stdout)
2 3 4 8
1 7 11 12
5 6 10 16
9 13 14 15
Expected Output
2 3 4 8
1 7 11 12
5 6 10 16
9 13 14 15
