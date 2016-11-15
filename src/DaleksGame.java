
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thomas
 */
public class DaleksGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //for game loop
        boolean gameOver = false;
        //create 12x12 game board
        Board board = new Board(12, 12);
        //generate random row and column for doctor
        int randRowDoc = (int) (Math.random() * 12);
        int randColDoc = (int) (Math.random() * 12);
        //create doctor and place at random row and column
        Doctor doctor = new Doctor(randRowDoc, randColDoc);
        //place green peg at random row and column
        board.putPeg(Color.GREEN, randRowDoc, randColDoc);
        //create dalek array with three spaces
        Dalek[] dalek = new Dalek[3];
        //generate random dalek positions and place black pegs
        for (int i = 0; i < dalek.length; i++) {
            int dalekRow = (int) (Math.random() * 12);
            int dalekCol = (int) (Math.random() * 12);
            dalek[i] = new Dalek(dalekRow, dalekCol);
            board.putPeg(Color.BLACK, dalekRow, dalekCol);
        }
        //display info to player
        board.displayMessage("Click on board to move and avoid Daleks!");
        //loop while game ending scenerio has not been reached
        while (gameOver == false) {
            //check if any of the daleks have crashed
            dalek[0].dalCrash(dalek[1]);
            dalek[1].dalCrash(dalek[2]);
            dalek[2].dalCrash(dalek[0]);
            //if any daleks have crashed, place red peg at crash location
            for (int i = 0; i < dalek.length; i++) {
                //if dalek is crashed
                if (dalek[i].isCrashed() == true) {
                    //place red peg
                    board.putPeg(Color.RED, dalek[i].dalRow(), dalek[i].dalCol());
                }
            }
            //check if doctor is at same location as any of the daleks
            for (int i = 0; i < dalek.length; i++) {
                //call on doctors caputure method to check if it has been captured by any dalek
                doctor.docCapture(dalek[i]);
                //check if doctor has been captured
                if (doctor.isCaptured() == true) {
                    //place yellow peg at capture location
                    board.putPeg(Color.YELLOW, dalek[i].dalRow(), dalek[i].dalCol());
                    //if so, game over, player loses, don't loop game anymore
                    gameOver = true;
                    //display information player
                    board.displayMessage("The Doctor has been captured. You lose!");
                    //end for loop
                    break;
                }
            }
            //check if all the daleks have crashed
            if (dalek[0].isCrashed() == true && dalek[1].isCrashed() == true && dalek[2].isCrashed() == true) {
                //if so, game over, player wins, don't loop game anymore
                gameOver = true;
                //display information to player
                board.displayMessage("All Daleks have crashed. You Win!");
            }
            //get player click and store as coordinate
            Coordinate click = board.getClick();
            //remove doctor peg
            board.removePeg(doctor.docRow(), doctor.docCol());
            //call on doctor's move method
            doctor.move(click.getRow(), click.getCol());
            //place doctor's peg on new row and column 
            board.putPeg(Color.GREEN, doctor.docRow(), doctor.docCol());
            //move daleks toward doctor
            for (int i = 0; i < dalek.length; i++) {
                //check if dalek can move (hasnt crashed)
                if (dalek[i].isCrashed() == false) {
                    //remove dalek peg
                    board.removePeg(dalek[i].dalRow(), dalek[i].dalCol());
                    //call on dalek's move method
                    dalek[i].advanceToward(doctor.docRow(), doctor.docCol(), dalek[i].dalRow(), dalek[i].dalCol());
                    //place dalek's peg at new row and column
                    board.putPeg(Color.BLACK, dalek[i].dalRow(), dalek[i].dalCol());
                }
            }

        }

    }

}
