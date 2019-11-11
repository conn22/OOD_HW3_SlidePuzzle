package up.cs301.homework3;

import android.view.View;
import android.widget.Button;

/* Author: James Conn
 * OnClickListener class for the button that randomizes the grid of Buttons
 */
public class RandomController implements Button.OnClickListener {

    private ButtonGrid grid;

    public RandomController(ButtonGrid g){
        grid = g;
    }

    @Override
    public void onClick(View v) {
        grid.randomize();
    }
}
