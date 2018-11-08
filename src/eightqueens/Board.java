
package eightqueens;

public class Board {
    
    public int numLeft;
    protected int dim;
    public boolean boardArray[][];
    
    public Board(int dim)
    {
        this.dim = dim;
    }
    
    public void initialize()
    {
        numLeft = dim;
        
        boardArray = new boolean[dim][dim];
        for(int i = 0; i < dim; i++)
        {
            for(int j =0; j < dim; j++)
            {
                boardArray[i][j] = false;
            }
        }
    }
    
    public boolean checkCorrect()
    {
        boolean queenFound = false; 
        boolean correct = true;
        
        //check rows
        for(int i = 0; i < dim; i++)
        {
            for(int j =0; j < dim; j++)
            {
                if(boardArray[i][j] == true)
                {
                    if(queenFound == true)
                    {
                        correct = false;
                    }
                    else
                    {
                        queenFound = true;
                    }
                }
            }
            
            queenFound = false;
        }
        
        //check columns
        for(int i = 0; i < dim; i++)
        {
            for(int j =0; j < dim; j++)
            {
                if(boardArray[j][i] == true)
                {
                    if(queenFound == true)
                    {
                        correct = false;
                    }
                    else
                    {
                        queenFound = true;
                    }
                }
            }
            
            queenFound = false;
        }
        
        //check major diagonals
        for (int line = 1; line <= (dim + dim - 1); line++) {

            int start_col = max(0, line - dim);

            int count = min(line, (dim - start_col), dim);

            for (int j = 0; j < count; j++)
            {
                if(boardArray[min(dim, line) - j - 1][start_col + j] == true)
                {
                    if(queenFound == true)
                    {
                        correct = false;
                    }
                    else
                    {
                        queenFound = true;
                    }
                }
                System.out.print(min(dim, line) - j - 1 + " ");
                System.out.print(start_col + j + "  ");
            }
            System.out.println();
            queenFound = false;
        }

        //check minor diagonal
        for (int line = 1; line <= (dim + dim - 1); line++) {

            int start_col = max(0, line - dim);

            int count = min(line, (dim - start_col), dim);
 
            for (int j = 0; j < count; j++)
            {
                if(boardArray[max(dim - line, 0) + j][start_col + j] == true)
                {
                    if(queenFound == true)
                    {
                        correct = false;
                    }
                    else
                    {
                        queenFound = true;
                    }
                }
                System.out.print(max(dim - line, 0) + j + " ");
                System.out.print(start_col + j + "  ");
            }
            System.out.println();
            queenFound = false;
        }
        
        
        return correct;
    }
    
    //helper methods ----------------------------------------------------------
    public int min(int a, int b)
    {
        if(a<b) return a;
        else return b;
    }
    
    public int min(int a, int b, int c)
    {
        return min(min(a,b),c);
    }
    
    public int max(int a, int b)
    {
        if(a>b) return a;
        else return b;
    }
    //end helper methods ------------------------------------------------------
}
