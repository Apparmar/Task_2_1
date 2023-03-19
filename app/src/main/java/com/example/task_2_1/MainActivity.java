package com.example.task_2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button myButton;
    EditText inputNumber;
    TextView mtView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner dropdown = findViewById(R.id.spinner);
        Spinner dropdownTwo = findViewById(R.id.spinner2);
        Spinner dropdownThree = findViewById(R.id.spinner3);

        String[] items = {"Inch", "Foot", "Yard","Mile"};
        String[] options = {"Weight","Length","Temperature"};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, items);
        ArrayAdapter<String> adapterTwo = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, options);

        dropdown.setAdapter(adapter);
        dropdownTwo.setAdapter(adapter);
        dropdownThree.setAdapter(adapterTwo);

        dropdownThree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        // Your code here
                        String convType = dropdownThree.getItemAtPosition(dropdownThree.getSelectedItemPosition()).toString();
                        Log.v("Something:", convType);
                        if (convType == "Weight")
                        {
                            String[] items = {"Pound", "Ounce", "Ton"};
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),
                                    android.R.layout.simple_spinner_dropdown_item, items);
                            dropdown.setAdapter(adapter);
                            dropdownTwo.setAdapter(adapter);
                        }
                        else if (convType == "Length")
                        {
                            String[] items = {"Inch", "Foot", "Yard","Mile"};
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),
                                    android.R.layout.simple_spinner_dropdown_item, items);
                            dropdown.setAdapter(adapter);
                            dropdownTwo.setAdapter(adapter);
                        }
                        else if (convType == "Temperature")
                        {
                            String[] items = {"Celsius", "Fahrenheit", "Kelvin"};
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),
                                    android.R.layout.simple_spinner_dropdown_item, items);
                            dropdown.setAdapter(adapter);
                            dropdownTwo.setAdapter(adapter);
                        }
                        else
                        {
                            Log.v("No valid option.","");
                        }

                        mtView.setText("");
                    }

            @Override
                    public void onNothingSelected(AdapterView<?> parentView) {
                        // your code here
                    }
                }
        );



        myButton = findViewById(R.id.button);
        inputNumber = findViewById(R.id.mtView);
        mtView = findViewById(R.id.textView4);

        myButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                //Double input = Double.parseDouble(inputNumber.getText().toString());
                String convType = dropdownThree.getItemAtPosition(dropdownThree.getSelectedItemPosition()).toString();
                String source = dropdown.getItemAtPosition(dropdown.getSelectedItemPosition()).toString();
                String dest = dropdownTwo.getItemAtPosition(dropdownTwo.getSelectedItemPosition()).toString();
                Double valueToConv = Double.parseDouble(inputNumber.getText().toString());

                if (convType == "Weight")
                {
                    if (source == "Pound")
                    {
                        valueToConv = valueToConv * 0.453592;
                    }
                    else if (source == "Ounce")
                    {
                        valueToConv = valueToConv * 28.3495 / 1000;
                    }
                    else if (source == "Ton")
                    {
                        valueToConv = valueToConv * 907.185;
                    }
                    else
                    {
                        Log.v("No valid option.","");
                    }

                    if (dest == "Pound")
                    {
                        valueToConv = valueToConv / 0.453592;
                    }
                    else if (dest == "Ounce")
                    {
                        valueToConv = valueToConv * 1000 / 28.3495;
                    }
                    else if (dest == "Ton")
                    {
                        valueToConv = valueToConv / 907.185;
                    }
                    else
                    {
                        Log.v("No valid option.","");
                    }

                }
                else if (convType == "Length")
                {
                    if (source == "Inch")
                    {
                        valueToConv = valueToConv * 2.54;
                    }
                    else if (source == "Foot")
                    {
                        valueToConv = valueToConv * 30.48;
                    }
                    else if (source == "Yard")
                    {
                        valueToConv = valueToConv * 91.44;
                    }
                    else if (source == "Mile")
                    {
                        valueToConv = valueToConv * 1.60934 * 1000 * 1000;
                    }
                    else
                    {
                        Log.v("No valid option.","");
                    }

                    if (dest == "Inch")
                    {
                        valueToConv = valueToConv / 2.54;
                    }
                    else if (dest == "Foot")
                    {
                        valueToConv = valueToConv / 30.48;
                    }
                    else if (dest == "Yard")
                    {
                        valueToConv = valueToConv / 91.44;
                    }
                    else if (dest == "Mile")
                    {
                        valueToConv = valueToConv / (1.60934 * 1000 * 1000);
                    }
                    else
                    {
                        Log.v("No valid option.","");
                    }
                }
                else if (convType == "Temperature")
                {
                    if (source == "Celsius" && dest == "Fahrenheit")
                    {
                        valueToConv = (valueToConv * 1.8) + 32;
                    }
                    else if (source == "Fahrenheit" && dest == "Celsius")
                    {
                        valueToConv = (valueToConv - 32) / 1.8;
                    }
                    else if (source == "Celsius" && dest == "Kelvin")
                    {
                        valueToConv = valueToConv + 273.15;
                    }
                    else if (source == "Kelvin" && dest == "Celsius")
                    {
                        valueToConv = valueToConv - 273.15;
                    }

                    else
                    {
                        Log.v("No valid option.","");
                    }
                }
                else
                {
                    Log.v("No valid option.","");
                }

                mtView.setText(valueToConv.toString());

                //mtView.setText();
            }




        });

    }
}