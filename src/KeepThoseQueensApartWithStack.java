import util.Pair;

import java.util.Stack;

/**
 * Created by adam on 05/05/2018.
 */
public class KeepThoseQueensApartWithStack {
    public static void main(String[] args) throws Exception {
        int min = 10;
        int max = min;
        for (int i = min; i <= max; i++) {
            solve(i);
            for (int j = 0; j < i*2; j++) {
                System.out.print("-");
            }
            System.out.println();
        }

    }

    private static void solve(int size) {

        boolean solutionCanBeFound = true;

        int[][] board = new int[size][size];

        int i = 0;
        int j = 0;

        Stack<Pair<Integer, Integer>> coordinates = new Stack<>();

        boolean conflicts = false;

        while (coordinates.size() < size) {
            if (i >= 0 && i < size && j >= 0 && j < size) {
                conflicts = conflicts(board, i, j, size);
            }
            if (!conflicts) {
                coordinates.push(new Pair<>(i, j));
                board[i][j] = 1;
                i = 0;
                ++j;
            }
            if (conflicts && i < size) {
                ++i;
            }
            if (i == size && !coordinates.empty()) {
                Pair<Integer, Integer> oldIJ = coordinates.pop();
                board[oldIJ.getFirst()][oldIJ.getSecond()] = 0;
                i = oldIJ.getFirst() + 1;
                j = oldIJ.getSecond();
            }
            if (i == size && coordinates.empty()) {
                solutionCanBeFound = false;
                break;
            }
        }
        if(solutionCanBeFound) {
            printArray(board);
        }
        if(!solutionCanBeFound) {
            System.out.println("No solution for: " + size);
        }
    }

    private static boolean conflicts(int[][] board, int queenRow, int queenColumn, int N) {

        for (int i = 1; i <= queenColumn; i++) {
            if (board[queenRow][queenColumn - i] == 1) {
                return true;
            }
        }

        int k = 1;
        while (queenRow - k >= 0 && queenColumn - k >= 0) {
            if (board[queenRow - k][queenColumn - k] == 1) {
                return true;
            }
            k++;
        }

        k = 1;
        while (queenRow + k < N && queenColumn - k >= 0) {
            if (board[queenRow + k][queenColumn - k] == 1) {
                return true;
            }
            ++k;
        }

        return false;
    }

    private static void printArray(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
