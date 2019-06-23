package student.comsats.edu.pk.comsatsaggregatecalculator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import java.util.Calendar;

public class OALevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oalevel);

        final CheckBox resAwait = (CheckBox) findViewById(R.id.rAchk);

        final int yearNow = Calendar.getInstance().get(Calendar.YEAR);

        resAwait.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                EditText aLevelObtMks = (EditText) findViewById(R.id.obtMksAlvl);
                EditText aLevelTotalMks = (EditText) findViewById(R.id.totalMksAlvl);
                EditText yearFactorForSetting = (EditText) findViewById(R.id.yearFacInt);



                if ( isChecked ) {
                    aLevelObtMks.setText("660");
                    aLevelTotalMks.setText("1100");
                    yearFactorForSetting.setText("2018");
                }

                if ( !isChecked ){
                    aLevelObtMks.setText("");
                    aLevelTotalMks.setText("");
                    yearFactorForSetting.setText("");
                    aLevelObtMks.setHint("Obtained Marks");
                    aLevelTotalMks.setHint("Total Marks");
                    yearFactorForSetting.setHint("Year of passing e.g. 2018");
                }
            }
        });

        Button calIntBtn = (Button) findViewById(R.id.calAggOfInt);
        calIntBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText obtMksAlvl_et = (EditText) findViewById(R.id.obtMksAlvl);
                EditText totalMksALvl_et = (EditText) findViewById(R.id.totalMksAlvl);
                EditText obtMksOlvl_et = (EditText) findViewById(R.id.obtMksOlvl);
                EditText totalMksOlvl_et = (EditText) findViewById(R.id.totalMksOlvl);

                double obtMksAlvlInt = Double.parseDouble(obtMksAlvl_et.getText().toString());
                double totalMksAlvlInt =  Double.parseDouble(totalMksALvl_et.getText().toString());
                double obtMksOlvlInt = Double.parseDouble(obtMksOlvl_et.getText().toString());
                double totalMksOlvlInt = Double.parseDouble(totalMksOlvl_et.getText().toString());

                EditText obtainedInNtsIntl_et = (EditText) findViewById(R.id.ntsMarksOaLevel);
                double obtainedInNtsIntlInt = Double.parseDouble(obtainedInNtsIntl_et.getText().toString());

                EditText yearFacIntl_et = (EditText) findViewById(R.id.yearFacInt);
                int yearFacIntlInt = Integer.parseInt(yearFacIntl_et.getText().toString());

                if ( resAwait.isChecked() ){
                    obtMksAlvlInt = 660;
                    totalMksAlvlInt =  1100;
                    yearFacIntlInt = 2018;

                }
                else{
                    obtMksAlvlInt = Double.parseDouble(obtMksAlvl_et.getText().toString());
                    totalMksAlvlInt = Double.parseDouble(totalMksALvl_et.getText().toString());
                    yearFacIntlInt = Integer.parseInt(yearFacIntl_et.getText().toString());
                }

                double percInOlvl = ( ( obtMksOlvlInt / totalMksOlvlInt ) * 100);
                double percInAlvl = (( obtMksAlvlInt / totalMksAlvlInt ) * 100);

                double aggregateInt = (obtainedInNtsIntlInt * 0.5) +  (percInAlvl * 0.4) + (percInOlvl * 0.1);

                //Year Factor
                /*
                EditText yearFacIntl_et = (EditText) findViewById(R.id.yearFacInt);
                int yearFacIntlInt = Integer.parseInt(yearFacIntl_et.getText().toString());
                */

                double aggregateIntlFinal;


                if ( yearFacIntlInt <= yearNow ) {

                    if (yearFacIntlInt == yearNow) {
                        aggregateIntlFinal = aggregateInt;
                    }

                    else if ( yearFacIntlInt == (yearNow - 1)) {
                        aggregateIntlFinal = (aggregateInt - 2);
                    }

                    else if ( yearFacIntlInt == (yearNow - 2)) {
                        aggregateIntlFinal = (aggregateInt - 4);
                    }

                    else if ( yearFacIntlInt == (yearNow - 3)) {
                        aggregateIntlFinal = (aggregateInt - 6);
                    }

                    else {
                        aggregateIntlFinal = (aggregateInt - 8);
                    }
                }

                else {
                    aggregateIntlFinal = 0.0; // just for initialization
                }

                String aggregateIntlFinalString = String.format("%.2f",aggregateIntlFinal);

                if (  aggregateInt >= 0 && aggregateInt <= 100 && yearFacIntlInt <= yearNow )  {

                    final AlertDialog.Builder finalAggIntlShow = new AlertDialog.Builder(OALevelActivity.this);
                    finalAggIntlShow.setTitle("Merit");
                    finalAggIntlShow.setMessage("Your merit is " + aggregateIntlFinalString);
                    finalAggIntlShow.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    AlertDialog dialogForAggIntl = finalAggIntlShow.create();
                    dialogForAggIntl.show();
                }

                else{
                    final AlertDialog.Builder errorShow = new AlertDialog.Builder(OALevelActivity.this);
                    errorShow.setTitle("Attention");
                    errorShow.setMessage("You have entered invalid data!");
                    errorShow.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    AlertDialog errorShowFinal = errorShow.create();
                    errorShowFinal.show();
                }

            }
        });


    }
}
