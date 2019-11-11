package up.cs301.homework3;

import android.widget.Button;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Author: James Conn
 * A Button Grid class that manages the data for the sliding puzzle
 */
public class ButtonGrid {

    protected Button[][] grid;
    int gridSize;
    int colorCorrect;
    int colorFalse;

    //Constructor
    public ButtonGrid(){
        grid = new Button[4][4];
        gridSize = 4;
        colorCorrect = 0x0012c91f;
        colorFalse = 0xffffffff;
    }

    //Randomizes and resets the grid of buttons
    //Algorithm inspired by Glen Johnson
    public void randomize(){
        Integer[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        List<Integer> randList = Arrays.asList(ints);
        Collections.shuffle(randList);
        randList.toArray(ints);
        for(int i = 0; i < 16; i++){
            CharSequence tmp = grid[i/4][i%4].getText();
            grid[i/4][i%4].setText(grid[ints[i]/4][ints[i]%4].getText());
            grid[ints[i]/4][ints[i]%4].setText(tmp);
        }
        for(int j = 0; j < 4; j++){
            for(int k = 0; k < 4; k++){
                grid[j][k].setBackgroundResource(android.R.drawable.btn_default);
                /* code taken from
                https://stackoverflow.com/questions/14802354/how-to-reset-a-buttons-background-color-to-default
                 */
            }
        }
    }

    //checks for correctness and changes color if so
    public boolean checkCorrect(ButtonGrid correct){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(grid[i][j].getText() != correct.getTextAt(i, j))
                    return false;
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                grid[i][j].setBackgroundColor(colorCorrect);
            }
        }
        return true;
    }

    //returns the ID of the button at the given coordinates
    public int getIDAt(int r, int c){
        return grid[r][c].getId();
    }

    //sets the onClickListener for all buttons in the grid
    public void setOnClickListener(ButtonGridController bgc) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j].setOnClickListener(bgc);
            }
        }
    }

    //used to initialize the button grid
    public void setGridVal(int r, int c, Button b){
        grid[r][c] = b;
    }

    //returns the button at the given coordinates
    public Button getButtonAt(int r, int c){
        return grid[r][c];
    }

    //returns the text of the button at the given coordinates
    public CharSequence getTextAt(int r, int c){
        return grid[r][c].getText();
    }

}
