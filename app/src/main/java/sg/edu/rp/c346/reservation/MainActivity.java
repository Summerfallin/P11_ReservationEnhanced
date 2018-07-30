package sg.edu.rp.c346.reservation;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnConfirm;
    Button btnReset;
    EditText etName;
    EditText etNumber;
    EditText etGroup;
    ToggleButton toggleButton;
    EditText etDate;
    EditText etTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConfirm=findViewById(R.id.buttonConfirm);
        btnReset=findViewById(R.id.buttonReset);
        etName=findViewById(R.id.editTextName);
        etNumber=findViewById(R.id.editTextNumber);
        etGroup=findViewById(R.id.editTextGroup);
        etDate=findViewById(R.id.editTextDate);
        etTime=findViewById(R.id.editTextTime);
        toggleButton=findViewById(R.id.toggleButton);

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        etDate.setText(i2+"/"+(i1)+"/"+i);
                    }
                };
                Calendar c = Calendar.getInstance();
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,myDateListener,c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH));
                myDateDialog.show();
            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        etTime.setText(i+":"+i1);
                    }
                };
                Calendar c = Calendar.getInstance();
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,myTimeListener,c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),true);
                myTimeDialog.show();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                // Code for the action
                Log.i("MyActivity", "Inside onClick()");
                String x = "";
                if(toggleButton.isChecked()){
                   x = "No";

                }
                else{
                    x = "Yes";

                }
                String strName = etName.getText().toString();
                String strGroup = etGroup.getText().toString();
                String strNumber = etNumber.getText().toString();

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Confirm Your Order");
                myBuilder.setMessage("New Reservation\r\n"+"Name:"+strName+"\r\nSmoking:"+x+"\r\nSize:"+strGroup+"\r\nDate:"+etDate.getText()+"\r\nTime:"+etTime.getText());
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Confirm", null);
                myBuilder.setNeutralButton("Cancel",null);
                AlertDialog mydialog = myBuilder.create();
                mydialog.show();



            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code for the action
                etGroup.setText("");
                etName.setText("");
                etNumber.setText("");
                etDate.setText("");
                etTime.setText("");
                toggleButton.setChecked(false);



            }
        });

    }
}
