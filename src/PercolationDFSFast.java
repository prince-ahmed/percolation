import java.util.*;
public class PercolationDFSFast extends PercolationDFS{ 

    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n is the size of the simulated (square) grid
     */
    public PercolationDFSFast(int n){
        super(n);
    }
    
    @Override
    protected void updateOnOpen(int row, int col) {
        boolean full = false; 
        if(row == 0){
            full = true;
        }
        if(col!=0){
            if(isFull(row,col-1)==true){
                full=true;
            }
        }
        if(col!=myGrid.length-1){
            if(isFull(row,col+1)==true){
                full=true;
            }
        }
        if(row!= 0){
            if(isFull(row-1, col)==true){
                full=true;
            }
        }
        if(row!=myGrid.length-1){
            if(isFull(row+1, col)){
                full=true;
            }
        }
        if(full==true){
            search(row,col);
        }
    }   

}
