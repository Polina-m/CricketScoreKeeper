package com.example.android.cricketscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int outTeamA = 0;
    int scoreTeamB = 0;
    int outTeamB = 0;
    TextView scoreTeamAView;
    TextView scoreTeamBView;
    TextView outTeamAView;
    TextView outTeamBView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreTeamAView = (TextView) findViewById(R.id.team_a_score);
        scoreTeamBView = (TextView) findViewById(R.id.team_b_score);
        outTeamAView = (TextView) findViewById(R.id.team_a_outs);
        outTeamBView = (TextView) findViewById(R.id.team_b_outs);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt( "score Team A", scoreTeamA);
        outState.putInt( "score Team B", scoreTeamB);
        outState.putInt( "out score A", outTeamA);
        outState.putInt( "out score B", outTeamB);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt("score Team A");
        scoreTeamB = savedInstanceState.getInt("score Team B");
        outTeamA = savedInstanceState.getInt("out score A");
        outTeamB = savedInstanceState.getInt("out score B");
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayOutTeamA(outTeamA);
        displayOutTeamB(outTeamB);
    }



        /**
         * Add one point to Team A score.
         */
    public void addOnePointTeamA(View view)
    {
        scoreTeamA++;
        displayForTeamA(scoreTeamA);
    }

    /**
    * Add 4 points to Team A score.
    */
    public void addFourPointsTeamA(View view)
    {
        scoreTeamA+= 4;
        displayForTeamA(scoreTeamA);
    }

    /**
    * Add 6 points to Team A score.
    */
    public void addSixPointsTeamA(View view)
    {
        scoreTeamA += 6;
        displayForTeamA(scoreTeamA);
    }

    /**
    * Add out to Team A score.
    */
    public void addOutTeamA(View view)
    {
       if(outTeamA == 10){
           outTeamA = 0;
           Toast toast = Toast.makeText(getApplicationContext(),
                   "End of innings!", Toast.LENGTH_LONG);
           toast.show();
       }
       else {
           outTeamA++;
       }
       displayOutTeamA(outTeamA);
    }

    /**
     * Add one point to Team B score.
    */
    public void addOnePointTeamB(View view)
    {
        scoreTeamB++;
        displayForTeamB(scoreTeamB);
    }

    /**
    * Add 4 points to Team B score.
    */
    public void addFourPointsTeamB(View view)
    {
        scoreTeamB+= 4;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Add 6 points to Team B score.
     */
    public void addSixPointsTeamB(View view)
    {
        scoreTeamB += 6;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Add out to Team B score.
     */
    public void addOutTeamB(View view)
    {
        if(outTeamB == 10){
            outTeamB = 0;
            Toast toast = Toast.makeText(getApplicationContext(),
                    "End of innings!", Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            outTeamB++;
        }
        displayOutTeamB(outTeamB);
    }

    /**
     * Reset all the views
     */
    public void reset (View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        outTeamA = 0;
        outTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayOutTeamA(outTeamA);
        displayOutTeamB(outTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        scoreTeamAView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        scoreTeamBView.setText(String.valueOf(score));
    }

    /**
     * Displays the given outs score for Team B.
     */
    public void displayOutTeamA(int score)
    {
        outTeamAView.setText(String.valueOf(score));
    }

    /**
     * Displays the given outs score for Team B.
     */
    public void displayOutTeamB(int score)
    {
        outTeamBView.setText(String.valueOf(score));
    }
}
