/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thomas
 */
public class Dalek {

    //class variables
    private int row;
    private int col;
    private boolean crashed = false;

    /**
     * dalek constructor
     *
     * @param row dalek is on
     * @param col dalek is on
     */
    public Dalek(int row, int col) {
        this.row = row;
        this.col = col;

    }

    /**
     * advance toward doctor
     *
     * @param docRow get doc row
     * @param docCol get doc col
     * @param dalRow get dal row
     * @param dalCol get dal col
     */
    public void advanceToward(int docRow, int docCol, int dalRow, int dalCol) {
        //create boolean to keep track of weather dalek has done a movement already
        boolean hasMoved = false;
        //if doctor and dalek are in same row
        if (docRow == dalRow) {
            //if doctors column is greater than daleks column
            if (docCol > dalCol) {
                //increase daleks column by one
                this.col++;
                //dalek has used up its move, set hasMoved to true
                hasMoved = true;
                //if doctors column is less than daleks column 
            } else if (docCol < dalCol) {
                //decrease daleks column by one
                this.col--;
                //dalek has used up its move, set hasMoved to true
                hasMoved = true;
            }
        }//check if dalek has already moved
        if (hasMoved == false) {
            //if doctor and dalek are in same column
            if (docCol == dalCol) {
                //if doctors row is greater than daleks row
                if (docRow > dalRow) {
                    //increase daleks row by one
                    this.row++;
                    //dalek has used up its move, set hasMoved to true
                    hasMoved = true;
                    //if doctors row is less than daleks row
                } else if (docRow < dalRow) {
                    //decrease daleks row by one
                    this.row--;
                    //dalek has used up its move, set hasMoved to true
                    hasMoved = true;
                }
            }
        }
        //check if dalek has already moved
        if (hasMoved == false) {
            //if doctors row is greater than daleks row
            if (docRow > dalRow) {
                //increase daleks row by one
                this.row++;
            }
            //if doctors row is less than daleks row
            if (docRow < dalRow) {
                //decrease daleks row by one
                this.row--;
            }
            //if doctors colums is greater than daleks column
            if (docCol > dalCol) {
                //increase daleks column by one
                this.col++;
            }
            //if doctors column is less than daleks column
            if (docCol < dalCol) {
                //decrease daleks column by one
                this.col--;
            }
        }

    }

    /**
     * check is dalek is crashed with other dalek
     *
     * @param d other dalek
     */
    public void dalCrash(Dalek d) {
        //check if daleks are at same location
        if ((this.row == d.dalRow()) && (this.col == d.dalCol())) {
            //set both daleks as crashed
            this.crashed = true;
            d.crashed = true;
        }
    }

    //give daleks row
    public int dalRow() {
        return this.row;
    }

    //give daleks column
    public int dalCol() {
        return this.col;
    }

    //return whether or not dalek is crashed
    public boolean isCrashed() {
        return this.crashed;
    }

}
