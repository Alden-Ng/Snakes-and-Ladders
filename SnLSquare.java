/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alden
 */
public class SnLSquare {

    //creating variables
    private int number;

    //creates square number
    public SnLSquare(int number) {
        this.number = number;
    }

    //get the value of number
    public int getNumber() {
        return this.number;
    }

    //returns the value of the square it lands on
    public int landOn() {
        return getNumber();
    }

    //prints out the number value
    @Override
    public String toString() {
        return Integer.toString(this.number);
    }

    //checks whether the object values and the Class values are the same 
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
        SnLSquare s = (SnLSquare) o;
        return (this.number == s.number);
    }
}
