/*Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

*/

public class Surrounded_Regions_130 {
    class Solution {// DFS, time O(n2), no extra space
        public void solve(char[][] board) {
            if(board.length <3) return;
            for(int i=0;i<board.length;i++){
                if(board[i][0]=='O') mark(i,0,board);
                if(board[i][board[0].length-1]=='O') mark(i,board[0].length-1,board);
            }
            for(int j=0;j<board[0].length;j++){
                if(board[0][j]=='O') mark(0,j,board);
                if(board[board.length-1][j]=='O') mark(board.length-1,j,board);
            }
            for(int i=0;i<board.length;i++){
                for(int j =0;j<board[0].length;j++){
                    if(board[i][j]=='O') board[i][j]='X';
                    else if(board[i][j]=='1') board[i][j]='O';
                }
            }
        }
        public void mark(int i,int j,char [][]board){
            if(i <0||j<0||i>=board.length||j>=board[0].length||board[i][j]!='O') return;
            board[i][j]='1';
            mark(i+1,j,board);
            mark(i,j+1,board);
            mark(i-1,j,board);
            mark(i,j-1,board);
        }
    }
}
