package student.comsats.edu.pk.comsatsaggregatecalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*--------------------------------------------------------------------------------------
        Apply Button - Opens COMSATS website
        */
        Button ApplyBtn = (Button) findViewById(R.id.applyBtn);
        ApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String applyWebsite = "http://admissions.comsats.edu.pk/";
                Uri webAddress = Uri.parse(applyWebsite);

                Intent goToWebsite = new Intent(Intent.ACTION_VIEW, webAddress);

                // check if it has browser
                if (goToWebsite.resolveActivity(getPackageManager()) != null ){
                    startActivity(goToWebsite);
                }
            }
        });
        /* Apply Button ends
        --------------------------------------------------------------------------------------
        */


        /*--------------------------------------------------------------------------------------
        Exit Button
        */
        Button exitBtn = (Button) findViewById(R.id.exitBtn);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Exit");
                builder.setMessage("Are you sure you want to Exit?");

                // Yes, Exit Button
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                //No, Return Back to Main Screen
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        /*Exit Button Ends
        ---------------------------------------------------------------------------------------
        */


        /*---------------------------------------------------------------------------------------
        Matric Fsc Activity
        */
        Button matricFscBtn = (Button) findViewById(R.id.matricFscButton);
        matricFscBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToMatricFsc = new Intent(getApplicationContext(), MatricFscActivity.class);
                startActivity(goToMatricFsc);
            }
        });

        /*Matric Fsc. Activity Ends
        -----------------------------------------------------------------------------------------
        */



        /*----------------------------------------------------------------------------------------
        O/A Levels Activity
         */
        Button oaLevelBtn = (Button) findViewById(R.id.oaLevelButton);
        oaLevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToOaLevel = new Intent(getApplicationContext(), OALevelActivity.class);
                startActivity(goToOaLevel);
            }
        });
        /*O/A Level Activity Ends
        -------------------------------------------------------------------------------------------
         */

    }
}
