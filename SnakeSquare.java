/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alden
 */
public class SnakeSquare extends SorLSquare {

    // creates the initial and final square
    public SnakeSquare(int number, int endSquare) {
        super(number, endSquare);
        if (number < endSquare) {
            throw new IllegalArgumentException("endSquare cannot be greater than the current square");
        }
    }

    // returns the square it landed on 
    @Override
    public int landOn() {
        return super.landOn();
    }

    //prints the snake formatting for the initial square and final square
    @Override
    public String toString() {
        return Integer.toString(super.getNumber()) + "-" + Integer.toString(super.getEndSquare());
    }

    //checks whether object and the Class are the same values
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        return (super.equals(o));
    }

}
