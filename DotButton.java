package game;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * In the application <b>Circle the dot</b>, a <b>DotButton</b> is a specialized type of
 * <b>JButton</b> that represents a dot in the game. It uses different icons to
 * visually reflect its state: a blue icon if the blue dot is currently on this location
 * an orange icon is the dot has been selected and a grey icon otherwise.
 */

public class DotButton extends JButton {

    private static final long serialVersionUID = 1L;
    private final ImageIcon icon1 = new ImageIcon(getClass().getResource("data/ball-0.png"));
    private final ImageIcon icon2 = new ImageIcon(getClass().getResource("data/ball-1.png"));
    private final ImageIcon icon3 = new ImageIcon(getClass().getResource("data/ball-2.png"));


    /**
     * Number of colours
     */

    private static final int NUM_COLOURS = 3;


    /**
     * The cell type. Valid values are GameModel.AVAILABLE, 
     * GameModel.SELECTED and GameModel.DOT
     */

    private int type;


    /**
     * The coordinate of this cell on the <b>Board</b>.
     */

    private int row, column;

    /**
     * An array is used to cache all the images. Since the images are not
     * modified, all the cells that display the same image reuse the same
     * <b>ImageIcon</b> object. Notice the use of the keyword <b>static</b>.
     */

    private static final ImageIcon[] icons = new ImageIcon[NUM_COLOURS];


    /**
     * Constructor used for initializing a cell of a specified type.
     */

    public DotButton(int row, int column, int type) {
    	this.row = row;
    	this.column = column;
    	this.type = type;
    	setBackground(Color.WHITE);
    	setIcon(getImageIcon());
    	Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
    	setBorder(emptyBorder);
    	setBorderPainted(false);
    }

    /**
     * Determine the image to use based on the cell type. Implements a caching mechanism.
     */

    private ImageIcon getImageIcon() {
	
    	if (icons[type] == null) {
    	    String strId = Integer.toString(type);
    	    //icons[type] = new ImageIcon("data/ball-" + strId + ".png");
    	    if (type == 0){
    	    	icons[type] = icon1;
    	    }
    	    if (type == 1){
    	    	icons[type] = icon2;
    	    }
    	    if (type == 2){
    	    	icons[type] = icon3;
    	    }
    	}
    	return icons[type];
    }

    /**
     * Changes the cell type of this cell. The image is updated accordingly.
     */

    public void setType(int type) {
    	this.type = type;
    	setIcon(getImageIcon());
    }



    public int getRow() {
	   return row;
    }

    /**
     * Getter method for the attribute column.
     * 
     * @return the value of the attribute column
     */

    public int getColumn() {
	   return column;
    }
}
