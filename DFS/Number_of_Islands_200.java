/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/
public class Number_of_Islands_200 {
    class Solution {//DFS no extra space, time O(n2)
        public int numIslands(char[][] grid) {
            if(grid.length==0) return 0;
            int count =0;
            for (int i=0;i<grid.length;i++){
                for (int j =0;j<grid[0].length;j++){
                    if(grid[i][j]=='1')
                    {
                        DFS(i,j,grid);
                        count++;
                    }
                }
            }
            return count;
        }
        public void DFS(int i,int j,char[][]grid){
            if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0') return;
            grid[i][j] = '0';
            DFS(i+1,j,grid);
            DFS(i,j+1,grid);
            DFS(i-1,j,grid);
            DFS(i,j-1,grid);
        }
    }
}
class Solution {
    public void solve(char[][] board) {
        if (board.length==0) return;
        for (int i=0;i<board[0].length;i++){    // Check first row
            if (board[0][i]=='O') setSign(0,i,board);
        }
        for (int i=0;i<board[0].length;i++){    // Check last row
            if (board[board.length-1][i]=='O') setSign(board.length-1,i,board);
        }
        for (int i=0;i<board.length;i++){       // Check first column
            if (board[i][0]=='O') setSign(i,0,board);
        }
        for (int i=0;i<board.length;i++){       // Check last column
            if (board[i][board[0].length-1]=='O') setSign(i,board[0].length-1,board);
        }

        for (int i = 0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='O') board[i][j]='X';
            }
        }
        for (int i = 0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='-') board[i][j]='O';
            }
        }
    }

    public void setSign(int i,int j, char[][] board){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!='O') return;
        board[i][j]='-';
        setSign(i+1,j,board);
        setSign(i-1,j,board);
        setSign(i,j+1,board);
        setSign(i,j-1,board);
    }
}
