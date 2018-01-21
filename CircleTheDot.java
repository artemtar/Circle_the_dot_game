package game;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Formatter;

import javax.swing.JOptionPane;

/**
 * The class <b>CircleTheDot</b> launches the game
 */
public class CircleTheDot {


   /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If a game size (>4) is passed as parameter, it is 
     * used as the board size. Otherwise, a default value is passed
     */
     public static void main(String[] args){
    	 
    	 StudentInfo.display();

        File f = new File("savedGame.ser");        
        
        if(f.exists()){
        	           
        	try{            	
        		
            	FileInputStream in = new FileInputStream(f);
            	ObjectInputStream obj = new ObjectInputStream(in);
            	GameModel savedGame = (GameModel) obj.readObject();   
     			GameController game = new GameController(savedGame.getSize());
     			game.setModel(savedGame);
     			game.getView().setModel(savedGame);   
     			obj.close();
     			if(f.delete()){
     				
     				System.out.println("Saved file is deleted");
     				
     			}

            	
            }catch(IOException e1){
	
			System.out.println("Saved file not found");
			
            }      
            
            catch (ClassNotFoundException e2){
            	
            	System.out.println("Whatever");
            	
            }
        	
        }else{
        	
        	
        	int size = Integer.parseInt(JOptionPane.showInputDialog("Input size of board", "9"));
            if (args.length == 1) {
                try{
                    size = Integer.parseInt(args[0]);
                    if(size<4){
                        System.out.println("Invalide argument, using default...");
                        size = 9;
                    }
                } catch(NumberFormatException e){
                    System.out.println("Invalide argument, using default...");
                }
            }
        	
        	
        	GameController game = new GameController(size);}
    }
}
