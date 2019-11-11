package up.cs301.homework3;

import android.view.View;
import android.widget.Button;

/* Author: James Conn
 * OnClickListener class for the grid of Button objects
 */
public class ButtonGridController implements Button.OnClickListener{

    protected ButtonGrid grid;
    protected ButtonGrid correct;
    private boolean solved;

    public ButtonGridController(ButtonGrid g, ButtonGrid c){
        grid = g;
        correct = c;
        solved = false;
    }

    /* onClick listening button for the grid, checking to see if a move is legal
     * and then checking to see if the puzzle is complete
     */
    @Override
    public void onClick(View V){
        int r = 0; int c = 0;
        boolean broke = false;
        //finds the coordinates of the button that was clicked
        for(; r < 4; r++){
            for(c = 0; c < 4; c++){
                if(V.getId() == grid.getIDAt(r, c)) {
                    broke = true;
                    break;
                }
            }
            if(broke)
                break;
        }
        if(!broke)
            return;
        broke = false;
        int rBlank = 0;
        int cBlank = 0;
        //checks to see if the move is legal, and performs it if it is
        for(; rBlank < 4; rBlank++){
            for(cBlank = 0; cBlank < 4; cBlank++){
                if(grid.getButtonAt(rBlank, cBlank).getText() == "") {
                    broke = true;
                    if((r == rBlank && c == cBlank+1) || (r == rBlank && c == cBlank-1)
                        || (r == rBlank+1 && c == cBlank) || (r == rBlank-1 && c == cBlank)){
                        CharSequence tmp = grid.getButtonAt(r, c).getText();
                        grid.getButtonAt(r, c).setText(grid.getButtonAt(rBlank, cBlank).getText());
                        grid.getButtonAt(rBlank, cBlank).setText(tmp);
                    }
                    break;
                }
            }
            if(broke)
                break;
        }
        solved = grid.checkCorrect(correct);
    }

    public boolean isSolved(){
        return solved;
    }

}
