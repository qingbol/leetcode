/*
 * @lc app=leetcode id=348 lang=java
 *
 * [348] Design Tic-Tac-Toe
 */

// @lc code=start
////-------------------------start(Appraoch1)------------------------
//20200413, by myself.
//Your runtime beats 12.41 % of java submissions

class TicTacToe1 {
  // public class TicTacToe {
  char[][] chessBoard;
  int n;

  /** Initialize your data structure here. */
  // public TicTacToe(int n) {
  public TicTacToe1(int n) {
    chessBoard = new char[n][n];
    this.n = n;
  }

  /**
   * Player {player} makes a move at ({row}, {col}).
   * 
   * @param row    The row of the board.
   * @param col    The column of the board.
   * @param player The player, can be either 1 or 2.
   * @return The current winning condition, can be either: 0: No one wins. 1:
   *         Player 1 wins. 2: Player 2 wins.
   */
  public int move(int row, int col, int player) {
    char token = player == 1 ? 'X' : 'O';
    chessBoard[row][col] = token;
    // System.out.format("chess:%s\n",
    // Arrays.deepToString(chessBoard).replaceAll("\\],", "\n"));
    int hor = 0, ver = 0, dia1 = 0, dia2 = 0;
    for (int i = 0; i < n; i++) {
      if (chessBoard[i][col] == token) {
        ver++;
      }
    }
    for (int j = 0; j < n; j++) {
      if (chessBoard[row][j] == token) {
        hor++;
      }
    }
    if (row == col) {
      for (int i = 0, j = 0; i < n && j < n; i++, j++) {
        if (chessBoard[i][j] == token) {
          dia1++;
        }
      }
    }
    if (row + col == n - 1) {
      for (int i = n - 1, j = 0; i >= 0 && j < n; i--, j++) {
        if (chessBoard[i][j] == token) {
          dia2++;
        }
      }
    }

    // System.out.format("hor:%d, ver:%d, dia1:%d, dia2:%d\n", hor, ver, dia1,
    // dia2);
    if (hor == n || ver == n || dia1 == n || dia2 == n) {
      return player;
    }
    return 0;
  }

  private boolean isWin(int row, int col, int player) {
    return false;
  }
}

//// ------------------------- end (Appraoch1)------------------------
//// -------------------------start(Appraoch1)------------------------
// 20200413.
// refer to :
//// https://leetcode.com/problems/design-tic-tac-toe/discuss/81898/Java-O(1)-solution-easy-to-understand
// Your runtime beats 100 % of java submissions

// class TicTacToe2 {
public class TicTacToe {

  int[] rows, cols;
  int diag, antiDiag;

  /** Initialize your data structure here. */
  public TicTacToe(int n) {
    // public TicTacToe2(int n) {
    rows = new int[n];
    cols = new int[n];
    diag = 0;
    antiDiag = 0;
  }

  public int move(int row, int col, int player) {
    int token = player == 1 ? 1 : -1;
    int n = rows.length;

    rows[row] += token;
    cols[col] += token;
    if (row == col) {
      diag += token;
    }
    if (row + col == n - 1) {
      antiDiag += token;
    }

    if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n) {
      return player;
    }
    return 0;
  }
}
//// ------------------------- end (Appraoch1)------------------------

/**
 * Your TicTacToe object will be instantiated and called as such: TicTacToe obj
 * = new TicTacToe(n); int param_1 = obj.move(row,col,player);
 */
// @lc code=end
