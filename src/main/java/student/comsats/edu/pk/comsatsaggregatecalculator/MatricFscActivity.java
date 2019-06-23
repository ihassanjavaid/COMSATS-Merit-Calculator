package student.comsats.edu.pk.comsatsaggregatecalculator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MatricFscActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matric_fsc);

            Button calPakBtn = (Button) findViewById(R.id.calPakBtn);

            calPakBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    EditText obtainedInMatric = (EditText) findViewById(R.id.obtainedInMatric);
                    EditText totalInMatric = (EditText) findViewById(R.id.totalInMatric);
                    EditText obtainedinFsc = (EditText) findViewById(R.id.obtainedInFsc);
                    EditText totalinFsc = (EditText) findViewById(R.id.totalInFsc);
                    EditText obtainedInNtsPak = (EditText) findViewById(R.id.ntsMarksPak);

                    double obtainedInMatricInt = Double.parseDouble(obtainedInMatric.getText().toString());
                    double totalInMatricInt = Double.parseDouble(totalInMatric.getText().toString());
                    double obtainedInFscInt = Double.parseDouble(obtainedinFsc.getText().toString());
                    double totalinFscInt = Double.parseDouble(totalinFsc.getText().toString());
                    double obtainedInNtsPakInt = Double.parseDouble(obtainedInNtsPak.getText().toString());

                    double percInMatric = ((obtainedInMatricInt / totalInMatricInt) * 100);
                    double percInFsc = ((obtainedInFscInt / totalinFscInt) * 100);

                    double aggregatePak = (obtainedInNtsPakInt * 0.5) +
                            (percInFsc * 0.4) +
                            (percInMatric * 0.1);

                    //Year Factor
                    EditText yearFacPak = (EditText) findViewById(R.id.yearFacPk);
                    int yearFacPakInt = Integer.parseInt(yearFacPak.getText().toString());

                    double aggregatePakFinal;
                    int yearNow = 2018;

                    if ( yearFacPakInt <= yearNow ) {

                        if (yearFacPakInt == yearNow) {
                            aggregatePakFinal = aggregatePak;
                        }

                        else if (yearFacPakInt == (yearNow - 1)) {
                            aggregatePakFinal = (aggregatePak - 2);
                        }

                        else if (yearFacPakInt == (yearNow - 2)) {
                            aggregatePakFinal = (aggregatePak - 4);
                        }

                        else if (yearFacPakInt == (yearNow - 3)) {
                            aggregatePakFinal = (aggregatePak - 6);
                        }

                        else {
                            aggregatePakFinal = (aggregatePak - 8);
                        }
                    }

                    else {
                        aggregatePakFinal = 0.0; // just for initialization
                    }

                    String aggregatePakString = String.format("%.2f",aggregatePakFinal);

                    if (obtainedInNtsPakInt > 100 || aggregatePak < 0 || aggregatePak > 100 || yearFacPakInt > yearNow) {

                        final AlertDialog.Builder invalidDataShowPk = new AlertDialog.Builder(MatricFscActivity.this);
                        invalidDataShowPk.setTitle("Attention");
                        invalidDataShowPk.setMessage("You have entered invalid data!");
                        invalidDataShowPk.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        AlertDialog dialogueForInvalidDataPk = invalidDataShowPk.create();
                        dialogueForInvalidDataPk.show();

                    }

                    else {

                        final AlertDialog.Builder finalAggregateShow = new AlertDialog.Builder(MatricFscActivity.this);
                        finalAggregateShow.setTitle("Merit");
                        finalAggregateShow.setMessage("Your merit is " + aggregatePakString);
                        finalAggregateShow.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        AlertDialog dialogueForAggregate = finalAggregateShow.create();
                        dialogueForAggregate.show();
                    }

                }
            }   );

    }
}
