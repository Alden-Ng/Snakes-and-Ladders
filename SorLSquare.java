/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alden
 */
public class SorLSquare extends SnLSquare {

    //creates variables
    private int endSquare;

    //creates initial and final square
    public SorLSquare(int number, int endSquare) {
        super(number);
        this.endSquare = endSquare;
        if (number == endSquare) {
            throw new IllegalArgumentException("endSquare is the same as the square itself");
        }
    }

    // gets the endSquare
    public int getEndSquare() {
        return this.endSquare;
    }

    // returns the square landed on
    @Override
    public int landOn() {
        return getEndSquare();
    }

    // prints the initial square and the final square
    @Override
    public String toString() {
        return super.toString() + ":" + Integer.toString(endSquare);
    }

    //checks if the object and the Class values are the same
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
        SorLSquare s = (SorLSquare) o;
        return (super.equals(o) && (this.endSquare == s.endSquare));
    }
}
