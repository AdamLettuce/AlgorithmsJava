/**
 * Created by adam on 05/05/2018.
 */
public class KeepThoseQueensApart {
    public static void main(String[] args) {
        int N = 8;
        int[][] board = new int[N][N];

        int placedQueens = 0;

        int i = 0;
        int j = 0;

        boolean conflicts = false;
        while (placedQueens <= N) {
            if(i>=0 && i<N && j>=0 && j<N) {
                conflicts = conflicts(board, i, j, N);
            }
            if (!conflicts) {
                if(j<N) {
                    board[i][j] = 1;
                }
                placedQueens++;
                if(j+1<N) {
                    ++j;
                }
                i=0;
            }
            if (conflicts) {
                if(i<N) {
                    ++i;
                }
                if(i==N) {
                    --j;
                    --placedQueens;
                    if(j>0) {
                        for (int k = 0; k < N; k++) {
                            board[k][j] = 0;
                        }
                        --j;
                        if(j>0) {
                            for (int k = 0; k < N; k++) {
                                if(board[k][j]==1) {
                                    board[k][j]=0;
                                    i=k+1;
                                }
                            }
                        }
                    }
                }
            }
            printArray(board);
            System.out.println();
        }

        printArray(board);

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
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt + ", ");
            }
            System.out.println();
        }
    }
}
