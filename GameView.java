package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out an instance of  <b>BoardView</b> (the actual game) and 
 * two instances of JButton. The action listener for the buttons is the controller.
 */

public class GameView extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Reference to the view of the board
     */
    private BoardView board;
    private GameModel gameModel;    
    private JButton buttonRedo;
    private JButton buttonUndo;
    private GameController gameController;
    /**
     * Constructor used for initializing the Frame
     */

    public GameView(GameModel model, GameController gameController) {
        super("Circle the Dot");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setBackground(Color.WHITE); 
    	this.gameController = gameController;
 
        JButton buttonReset = new JButton("Reset");
        buttonReset.setFocusPainted(false);
        buttonReset.addActionListener(gameController);

        JButton buttonExit = new JButton("Quit");
        buttonExit.setFocusPainted(false);
        buttonExit.addActionListener(gameController);
        
        buttonUndo = new JButton("Undo");
        buttonUndo.setFocusPainted(false); 
        buttonUndo.setEnabled(false);
        buttonUndo.addActionListener(gameController);
        
        buttonRedo = new JButton("Redo");
        buttonRedo.setFocusPainted(false);
        buttonRedo.setEnabled(false);
        buttonRedo.addActionListener(gameController);
        
    	JPanel control = new JPanel();
    	control.setBackground(Color.WHITE);
        control.add(buttonReset);
        control.add(buttonExit);
        control.add(buttonUndo);
        control.add(buttonRedo);
        add(control, BorderLayout.SOUTH);
    	
        gameModel = model;
    	board = new BoardView(model, gameController);
    	board.setVisible(true);
    	add(board, BorderLayout.CENTER);

    	pack();
    	setResizable(false);
    	

    }
    public void setModel(GameModel g){
    	
    	gameModel = g;
    	board.setModel(g);
    	update();
    	
    }


    public void update(){
        board.update();
  
    }
    
    public void swithOnOff(){
    	
 
    	
    	
    	if(gameController.stackConditionRedo()){
    		
    		buttonRedo.setEnabled(false);
    		
    	}else{
    		
    		buttonRedo.setEnabled(true);
    		
    	}
    	
    		
        	if(gameController.stackConditionData()){
        		
        		buttonUndo.setEnabled(false);
        		
        	}else{
        		
        		buttonUndo.setEnabled(true);
        		
        	}
    		
    	}
    }


