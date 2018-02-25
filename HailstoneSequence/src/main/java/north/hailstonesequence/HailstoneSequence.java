/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.hailstonesequence;

/**
 *
 * @author northernpike
 */
public class HailstoneSequence {
    
    private int startingPoint;
    private int rounds;
    private int secondLargestPoint;
    private int largestPoint;

    public HailstoneSequence(int startingPoint) {
        this.startingPoint = startingPoint;
        this.rounds = 0;
        this.largestPoint = 0;
        this.secondLargestPoint = 0;
    }
    
    public void calculateSequence() {
        int current = this.startingPoint; //Start calculating from the point given by the user
        while(true) {
            
            if (current > this.largestPoint) { //Check if the current value of sequence is the largest point
                this.secondLargestPoint = this.largestPoint;
                this.largestPoint = current;
            } else if (current > this.secondLargestPoint) {  //Check if the current value of sequence is the 2nd largest point
                this.secondLargestPoint = current;
            }
                        
            if (current == 1) { //If the current value is 1 break the loop and Main.java can continue to printing html file
                break;
            } else if (current % 2 == 0) { // If the number is even
                current = (current / 2);
            } else { // if the number is not even aka it is odd
                current = (current * 3 + 1); 
            }
            
            this.rounds++; //Increment amount of rounds at the start of each while loop
        }
    }

    public int getRounds() {
        return rounds;
    }

    public int getSecondLargestPoint() {
        return secondLargestPoint;
    }

    public int getStartingPoint() {
        return startingPoint;
    }
    
    
    
    
    
}
