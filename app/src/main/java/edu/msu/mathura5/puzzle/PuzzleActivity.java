package edu.msu.mathura5.puzzle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class PuzzleActivity extends AppCompatActivity {

    @Override
    protected void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
//        PuzzleView view = (PuzzleView)this.findViewById(R.id.puzzleView);
//        view.saveInstanceState(bundle);
        getPuzzleView().saveInstanceState(bundle);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_shuffle:
                getPuzzleView().getPuzzle().shuffle();
                getPuzzleView().invalidate();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_puzzle, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_puzzle);

        if(bundle != null) {
            // We have saved state
//            PuzzleView view = (PuzzleView)this.findViewById(R.id.puzzleView);
//            view.loadInstanceState(bundle);
            getPuzzleView().loadInstanceState(bundle);
        }
    }
    /**
     * Get the puzzle view
     * @return PuzzleView reference
     */
    public PuzzleView getPuzzleView() {
        return (PuzzleView)this.findViewById(R.id.puzzleView);
    }
}