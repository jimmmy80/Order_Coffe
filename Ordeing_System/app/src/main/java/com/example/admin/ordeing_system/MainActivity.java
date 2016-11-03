package com.example.admin.ordeing_system;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity = 1;

 public void submit(View view){
    EditText nameField = (EditText)findViewById(R.id.name);
    String name = nameField.getText().toString();

     CheckBox addCream = (CheckBox) findViewById(R.id.whippedCream);
     Boolean containCream = addCream.isChecked();

   CheckBox addChoc = (CheckBox) findViewById(R.id.choco);
   Boolean containChoc= addChoc.isChecked();  
   int price = calculatePrice(containCream,containChoc); 
   String priceMsg = orderSummary(price,containCream,containChoc,name);


     displayMessage(priceMsg);
 }
    private int calculatePrice(Boolean containCream, Boolean containChoc) {
        int fixedCost = 5;
        if (containCream) {
            fixedCost = fixedCost + 1;
        }
        if (containChoc) {
           fixedCost = fixedCost + 2;
        }
       return quantity * fixedCost;
    }
     public void increment(View view){
            if(quantity == 20){
                Toast.makeText(this,"You are not allowed to go above 20",Toast.LENGTH_SHORT).show();
              return;
            }
         quantity = quantity + 1;
          displayQuantity(quantity);
     }
    public void decrement(View view){
        if(quantity == 0) {
            Toast.makeText(this, "You are not allowed to go below 0", Toast.LENGTH_SHORT).show();
            return;
        }
            quantity = quantity - 1;
        displayQuantity(quantity);
    }

      private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(" " + number);
    }

      private void displayMessage(String Message) {
         TextView orderSumarryView = (TextView)findViewById(R.id.orderSummary_text_view);
        orderSumarryView.setText(Message);
    }

      private String orderSummary(int price, Boolean containCream, Boolean containChoc,String name) {
          String pricemessage = "Name: " + name;
        pricemessage += "\nAdd Whipped? " + containCream;
        pricemessage += "\nAdd Chocolate? " + containChoc;
        pricemessage += "\nQuantity: " + quantity;
        pricemessage += "\nTotal: R " + price;
        pricemessage += "\nThank For Ordering at Our store!";
          return pricemessage;
      }
    /*private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.orderSummary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }*/
}
