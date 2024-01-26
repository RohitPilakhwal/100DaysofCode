class Solution {
    static int check;

    static boolean isValid(char arr[][],int row, int col, char ch){

        for(int j=0; j<9; j++){
            if(j!=col && arr[row][j]==ch) return false;
        }

        for(int i=0; i<9; i++){
            if(i!=row && arr[i][col]==ch) return false;
        }

        int stR = (row/3)*3;
        int stC = (col/3)*3;

        for(int i=stR; i<stR+3; i++){
            for(int j=stC; j<stC+3; j++){
                if(i==row && j==col) continue; 
                if(arr[i][j]==ch) return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] arr) {
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(arr[i][j]!='.'){
                    boolean ans = isValid(arr,i,j,arr[i][j]);
                    if(ans==false) return false;
                }
            }
        }
        return true;
    }
}