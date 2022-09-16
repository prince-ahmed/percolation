import java.util.*;

public class PercolationBFS extends PercolationDFSFast{

    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n is the size of the simulated (square) grid
     */
    public PercolationBFS(int n) {
        super(n);
    }
    @Override
    protected void search(int row, int col) {
        int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};

        Queue<int[]> q = new LinkedList<>();
        if (isFull(row, col) || !isOpen(row, col)){
            return;
        }
        myGrid[row][col] = FULL;
        q.add(new int[]{row, col});
        while(q.size() != 0 ){
            int[] p = q.remove();
            for(int i=0; i < rowDelta.length; i++){
                row = p[0] + rowDelta[i];
                col = p[1] + colDelta[i];
                if (inBounds(row,col) && myGrid[row][col] == OPEN){
                    q.add(new int[]{row,col});
                    myGrid[row][col] = FULL;
                }
            }
        }
    }

}
