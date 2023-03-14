package Task1;

import java.util.Arrays;

public class Matrix {
    private final int[][] matrix;

    public Matrix(int rows, int cols) {
        matrix = new int[rows][cols];
    }

    public Matrix(int rows, int cols, int defaultValue) {
        this(rows, cols);

        fillMatrix(defaultValue);
    }

    public void fill(int value) {
        fillMatrix(value);
    }

    public void clear() {
        fillMatrix(0);
    }

    private void fillMatrix(int value) {
        for (int[] r : matrix) {
            for (int i = 0; i < r.length; i++) {
                r[i] = value;
            }
        }
    }

    public int[] getRow(int row) {
        if (row < 0 || row >= matrix.length) {
            throw new IllegalArgumentException("Invalid row index");
        }
        return matrix[row];
    }

    public int[] getColumn(int col) {
        if (col < 0 || col >= matrix[0].length) {
            throw new IllegalArgumentException("Invalid column index");
        }

        int[] columnElements = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            columnElements[i] = matrix[i][col];
        }
        return columnElements;
    }

    public void set(int x, int y, int value) {
        checkRange(x, y);
        matrix[x][y] = value;
    }

    public int get(int x, int y) {
        checkRange(x, y);
        return matrix[x][y];
    }

    private void checkRange(int x, int y) {
        if (!(x >= 0 && x < matrix.length && y >= 0 && y < matrix[y].length)) { //TODO
            throw new IllegalArgumentException("");
        }
    }

    public Matrix subMatrix(int x1, int y1, int x2, int y2) {
        Range rows = new Range(x1, x2);
        Range columns = new Range(y1, y2);
        int rLen = rows.getLength();
        int cLen = columns.getLength();
        Matrix subM = new Matrix(cLen, rLen);
        int rStart = rows.getStart();
        int cStart = columns.getStart();

        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                int val = matrix[rStart + i][cStart + j];
                subM.set(i, j, val);
            }
        }
        return subM;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(matrix);
    }
}