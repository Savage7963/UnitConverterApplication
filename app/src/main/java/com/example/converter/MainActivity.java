package com.example.converter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textField, Answer;
    EditText edtxt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        textField = findViewById(R.id.text);
        edtxt = findViewById(R.id.editTextNumber);
        Answer=findViewById(R.id.text2);
        btn=findViewById(R.id.button);
        // Sample data for the spinner
        String[] items = {"Meter", "Kilometer", "grams", "Kilograms"};

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Set a listener to handle item selections
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Get the selected item's text
                String selectedText = parentView.getItemAtPosition(position).toString();

                // Display the selected text in the EditText
                textField.setText(selectedText);
                if ("Kilometer".equals(selectedText)) {
                    edtxt.setHint("Enter Value in meters");
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String num = edtxt.getText().toString();

                            // Check if the EditText is not empty before trying to parse
                            if (!num.isEmpty()) {
                                try {
                                    double meters = Double.parseDouble(num);

                                    // Convert meters to kilometers
                                    double kilometers = meters / 1000.0;

                                    // Display the result in the Answer TextView
                                    Answer.setText(String.format("%.3f", kilometers) + " km");
                                } catch (NumberFormatException e) {
                                    // Handle the case where the text is not a valid number
                                    Log.e("MainActivity", "Invalid number format");
                                }
                            } else {
                                // Handle the case where the EditText is empty
                                Log.e("MainActivity", "EditText is empty");
                            }
                        }
                    });

                } else if ("Meter".equals(selectedText)) {
                    edtxt.setHint("Enter Value in Centimeter");
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String num = edtxt.getText().toString();

                            // Check if the EditText is not empty before trying to parse
                            if (!num.isEmpty()) {
                                try {
                                    double centimeters = Double.parseDouble(num);

                                    // Convert centimeters to meters
                                    double meters = centimeters / 100.0;

                                    // Display the result in the Answer TextView with more decimal places
                                    Answer.setText(String.format("%.2f", meters) + " m");
                                } catch (NumberFormatException e) {
                                    // Handle the case where the text is not a valid number
                                    Log.e("MainActivity", "Invalid number format");
                                }
                            } else {
                                // Handle the case where the EditText is empty
                                Log.e("MainActivity", "EditText is empty");
                            }
                        }
                    });

                } else if ("grams".equals(selectedText)) {
                    edtxt.setHint("Enter Value in milligrams");
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String num = edtxt.getText().toString();

                            // Check if the EditText is not empty before trying to parse
                            if (!num.isEmpty()) {
                                try {
                                    double milligrams = Double.parseDouble(num);

                                    // Convert milligrams to grams
                                    double grams = milligrams / 1000.0;

                                    // Display the result in the Answer TextView with more decimal places
                                    Answer.setText(String.format("%.3f", grams) + " g");
                                } catch (NumberFormatException e) {
                                    // Handle the case where the text is not a valid number
                                    Log.e("MainActivity", "Invalid number format");
                                }
                            } else {
                                // Handle the case where the EditText is empty
                                Log.e("MainActivity", "EditText is empty");
                            }
                        }
                    });
                } else if ("Kilograms".equals(selectedText)) {
                    Log.d("MainActivity", "Selected Kilogram");
                    edtxt.setHint("Enter Value in grams");
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
// Get the numeric value from the EditText when needed
                            String num = edtxt.getText().toString();

                            // Check if the EditText is not empty before trying to parse
                            if (!num.isEmpty()) {
                                try {
                                    double grams = Double.parseDouble(num);

                                    // Convert grams to kilograms
                                    double kilograms = grams / 1000.0;

                                    // Display the result in the Answer TextView with more decimal places
                                    Answer.setText(String.format("%.3f", kilograms) + " kg");
                                } catch (NumberFormatException e) {
                                    // Handle the case where the text is not a valid number
                                    Log.e("MainActivity", "Invalid number format");
                                }
                            } else {
                                // Handle the case where the EditText is empty
                                Log.e("MainActivity", "EditText is empty");
                            }
                        }
                    });
                } else {
                    Log.d("MainActivity", "Selected Something Else");
                    edtxt.setHint("Choose something from the list");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });
    }
}
