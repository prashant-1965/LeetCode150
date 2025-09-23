class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> set;
        for(int i=0;i<9;i++)
        {
            set = new HashSet<>();
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {
                    if(set.contains(board[i][j]-'0'))
                    {
                        return false;
                    }
                    else
                    {
                        set.add(board[i][j]-'0');
                    }
                }
            }
            set = new HashSet<>();
            for(int j=0;j<9;j++)
            {
                if(board[j][i]!='.')
                {
                    if(set.contains(board[j][i]-'0'))
                    {
                        return false;
                    }
                    else
                    {
                        set.add(board[j][i]-'0');
                    }
                }
            }
            int row=0,col=0,Row=0,Col=0;
            while(Row!=9)
            {
                while(col!=9)
                {
                    set = new HashSet<>();
                    row=Row;
                    for(int j=row;j<row+3;j++)//j=0 && j<3
                    {
                        for(int k=col;k<col+3;k++)// k=0 && k<3
                        {
                            if(board[j][k]!='.')
                            {
                                if(set.contains(board[j][k]-'0'))
                                {
                                    return false;
                                }
                                else
                                {
                                    set.add(board[j][k]-'0');
                                }
                            }
                        }
                    }
                    col+=3;
                }
                Row+=3;
                col=0;
            }
        }
        return true;
    }
}