package game;
import java.io.Serializable;
import java.util.Random;


/**
 * The class <b>GameModel</b> holds the model, the state of the systems. 
 * It stores the followiung information:
 * - the current location of the blue dot
 * - the state of all the dots on the board (available, selected or 
 *  occupied by the blue dot
 * - the size of the board
 * - the number of steps since the last reset
 */
public class GameModel implements Cloneable, Serializable{


    public static final int AVAILABLE   = 0;
    public static final int SELECTED    = 1;
    public static final int DOT         = 2;
    private static final int INITIAL_PROBA = 10;
    private int sizeOfGame;
    private int[][] model;
    private Point currentDot;
    private int numberOfSteps;
    private Random generator;

   


    /**
     * Constructor to initialize the model to a given size of board.
     */
    public GameModel(int size) {
        numberOfSteps = 0;        
        generator = new Random();
        sizeOfGame = size;
        reset();
    }    	
    	
    
    /**
     * Resets the model to (re)start a game. The previous game (if there is one)
     * is cleared up . The blue dot is positioned as per instructions, and each 
     * dot of the board is either AVAILABLE, or SELECTED (with
     * a probability 1/INITIAL_PROBA). The number of steps is reset.
     */
    public void reset(){

        model = new int[sizeOfGame][sizeOfGame];

        for(int i = 0; i < sizeOfGame; i++){
            for(int j = 0; j < sizeOfGame; j++){
                model[i][j] = AVAILABLE;
            }
        }

        // on a odd board, put the current dot randomly on a centered square of
        // 2 by 2, on an even board, put the current dot randomly on a centered 
        // square of 3 by 3

        if(sizeOfGame%2 == 0){
            currentDot = new Point(sizeOfGame/2 - generator.nextInt(2),
                sizeOfGame/2 - generator.nextInt(2));
        } else{
        	
            currentDot = new Point(sizeOfGame/2 + 1 - generator.nextInt(3),
                sizeOfGame/2 + 1 - generator.nextInt(3));
        }

        model[currentDot.getX()][currentDot.getY()] = DOT;

        for(int i = 0; i < sizeOfGame; i++){
            for(int j = 0; j < sizeOfGame; j++){
                if(!( i == currentDot.getX() && j == currentDot.getY())){
                    if(generator.nextInt(INITIAL_PROBA) == 0){
                        model[i][j] = SELECTED;
                    }
                }
            }
        }

        numberOfSteps = 0;
    }

 
    public int getSize(){
        return sizeOfGame;
    }


    public int[][] getModel(){
        return model;
        }
    



    /**
     * returns the current status (AVAILABLE, SELECTED or DOT) of a given dot in the game

     */   
    public int getCurrentStatus(int i, int j){
        return model[i][j];
    }

   
    public void select(int i, int j){
        model[i][j] = SELECTED;
        numberOfSteps++;
    }

    /**
     * Puts the blue dot at coordinate (i,j). Clears the previous location 
     * of the blue dot. If the i coordinate is "-1", it means that the blue 
     * dot exits the board (the player lost)
     */   
    public void setCurrentDot(int i, int j){
        model[currentDot.getX()][currentDot.getY()] = AVAILABLE;
        // pass on "-1" to remove the current dot at the end of the game
        if(i != -1) {
            model[i][j] = DOT;
            currentDot.reset(i,j);
        }
    }
    
    public void setModel(int [][] m){
    	
    	this.model = m;
    	
    }

    /**
     * Getter method for the current blue dot
     * 
     */   
    public Point getCurrentDot(){
        return currentDot;
    }

    /**
     * Getter method for the current number of steps
     * 
     * @return the current number of steps
     */   
    public int getNumberOfSteps(){
        return numberOfSteps;
    }
    
    public void setCurrentDot(Point p){
    	
    	currentDot = p;
    	
    }
    
    public Object clone(GameModel source) throws CloneNotSupportedException{
    	
    	Object copy = super.clone();
    	int[][]m = new int[source.sizeOfGame][source.sizeOfGame];
    	 for(int i = 0; i < source.getSize(); i++){
   		   	for(int j = 0; j < source.getSize(); j++){
   		   	 m[i][j] = (source.getCurrentStatus(i, j));
   		   	 }}	    	
    	((GameModel) copy).setCurrentDot((Point) currentDot.clone());
    	
    	 //int[][] m = model.clone(); another way of emplementig clone
    	 ((GameModel) copy).setModel(m);
    	return copy;
    	
    }
}
