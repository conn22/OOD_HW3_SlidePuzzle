package up.cs301.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

/* Author: James Conn
 * MainActivity class for the Sliding Puzzle Assignment
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create the board
        ButtonGrid grid = new ButtonGrid();
        initGrid(grid);

        //create the correct
        ButtonGrid correctCpy = new ButtonGrid();
        initGrid(correctCpy);

        //randomize the board
        grid.randomize();

        //create and set the listener
        ButtonGridController bgc = new ButtonGridController(grid, correctCpy);
        grid.setOnClickListener(bgc);

        //set listener for the randomizer button
        Button randButton = (Button) findViewById(R.id.resetButton);
        randButton.setOnClickListener(new RandomController(grid));

        boolean solved = bgc.isSolved();

    }

    //helper method to initialize the grids
    private void initGrid(ButtonGrid g){
        g.setGridVal(0, 0, (Button) findViewById(R.id.button1));
        g.setGridVal(0, 1, (Button) findViewById(R.id.button2));
        g.setGridVal(0, 2, (Button) findViewById(R.id.button3));
        g.setGridVal(0, 3, (Button) findViewById(R.id.button4));
        g.setGridVal(1, 0, (Button) findViewById(R.id.button5));
        g.setGridVal(1, 1, (Button) findViewById(R.id.button6));
        g.setGridVal(1, 2, (Button) findViewById(R.id.button7));
        g.setGridVal(1, 3, (Button) findViewById(R.id.button8));
        g.setGridVal(2, 0, (Button) findViewById(R.id.button9));
        g.setGridVal(2, 1, (Button) findViewById(R.id.button10));
        g.setGridVal(2, 2, (Button) findViewById(R.id.button11));
        g.setGridVal(2, 3, (Button) findViewById(R.id.button12));
        g.setGridVal(3, 0, (Button) findViewById(R.id.button13));
        g.setGridVal(3, 1, (Button) findViewById(R.id.button14));
        g.setGridVal(3, 2, (Button) findViewById(R.id.button15));
        g.setGridVal(3, 3, (Button) findViewById(R.id.blank));
    }

}