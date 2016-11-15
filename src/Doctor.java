//.lo;p0'[-=wrqut1bn,KX.'

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thomas
 */
public class Doctor {
    //class variables
    private int row;
    private int col;
    private boolean captured = false;

    /**
     * doctor constructor
     * @param row doc is on
     * @param col doc is on
     */
    public Doctor(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * move method for doctor
     * @param newRow player wants to move to
     * @param newCol player wants to move to
     */
    public void move(int newRow, int newCol) {
        //check if space is 1 square away from doctor
        if ((newRow == this.row + 1 || newRow == this.row - 1 || newRow == this.row)
                && (newCol == this.col + 1 || newCol == this.col - 1 || newCol == this.col)) {
            //change row and col to requested location
            this.row = newRow;
            this.col = newCol;
            //if location is not one tile away
        } else {
            //'teleport' doctor to random location on the board
            this.row = (int) (Math.random() * 12);
            this.col = (int) (Math.random() * 12);
        }

    }

    /**
     * check if doc is captured
     * @param d dalek 
     */
    public void docCapture(Dalek d) {
        //check if doctor and dalek area at same location
        if (this.docRow() == d.dalRow() && this.docCol() == d.dalCol()) {
            //if so return true
            this.captured = true;
        }
    }
    //give doctors row
    public int docRow() {
        return this.row;
    }
    //give doctors column
    public int docCol() {
        return this.col;
    }
    //return whether or not doctor is captured
    public boolean isCaptured() {
        return this.captured;
    }

}
