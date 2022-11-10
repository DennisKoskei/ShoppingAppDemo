package com.mobileshoppingappdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    // This are the fixed prices of the items
    final int PRICEOFBREAD = 50;
    final int PRICEOFPASTA = 95;
    final int PRICEOFEGGS = 35;
    final int PRICEOFMILK = 65;

    // This declares all the variables that are used in the calculation of the prices of the items selected
    int breadPrice, pastaPrice, eggsPrice, milkPrice;
    int beforeDiscountPrice, discountedPrice, totalPrice;
    int breadSelectedTimes, pastaSelectedTimes, eggsSelectedTimes, milkSelectedTimes;
    int noOfItemsSelected;  // This show the count of no of items that are selected by the user.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button breadAddButton = (Button) findViewById(R.id.breadAddButton);
        Button breadRemoveButton = (Button) findViewById(R.id.breadRemoveButton);
        Button pastaAddButton = (Button) findViewById(R.id.pastaAddButton);
        Button pastaRemoveButton = (Button) findViewById(R.id.pastaRemoveButton);
        Button eggsAddButton = (Button) findViewById(R.id.eggsAddButton);
        Button eggsRemoveButton = (Button) findViewById(R.id.eggsRemoveButton);
        Button milkAddButton = (Button) findViewById(R.id.milkAddButton);
        Button milkRemoveButton = (Button) findViewById(R.id.milkRemoveButton);
        Button getTotalButton = (Button) findViewById(R.id.getTotalButton);
        Button clearButton = findViewById(R.id.clearButton);
        ImageButton aboutImageButton = (ImageButton) findViewById(R.id.aboutImageButton);

        TextView breadPriceTextView = (TextView) findViewById(R.id.breadPriceTextView);
        TextView pastaPriceTextView = (TextView) findViewById(R.id.pastaPriceTextView);
        TextView eggsPriceTextView = (TextView) findViewById(R.id.eggsPriceTextView);
        TextView milkPriceTextView = (TextView) findViewById(R.id.milkPriceTextView);
        TextView discountTextView = (TextView) findViewById(R.id.discountTextView);
        TextView totalTextView = (TextView) findViewById(R.id.totalTextView);
        TextView breadSelectedTextView = (TextView) findViewById(R.id.bSelectedtextView);
        TextView pastaSelectedTextView = (TextView) findViewById(R.id.pSelectedTextView);
        TextView eggsSelectedTextView = (TextView) findViewById(R.id.eSelectedTextView);
        TextView milkSelectedTextView = (TextView) findViewById(R.id.mSelectedTextView);


        // ----- BREAD ADD AND REMOVE BUTTON -----
        breadAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (breadSelectedTimes >= 4){
                    alertMaxMessage();
                }else {
                    breadSelectedTimes ++;
                    breadPrice = breadSelectedTimes * PRICEOFBREAD;
                    breadSelectedTextView.setText("x" + breadSelectedTimes);
                    breadPriceTextView.setText(String.valueOf(breadPrice));
                }

            }
        });
        breadRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                breadSelectedTimes --;
                if(breadSelectedTimes < 0){
                    alertMinMessage();
                    breadSelectedTimes ++;
                }else {
                    breadPrice = breadSelectedTimes * PRICEOFBREAD;
                    breadSelectedTextView.setText("x" + breadSelectedTimes);
                    breadPriceTextView.setText(String.valueOf(breadPrice));
                }
            }
        });
        // ----- PASTA ADD AND REMOVE BUTTON -----
        pastaAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pastaSelectedTimes >=4){
                    alertMaxMessage();
                }else {
                    pastaSelectedTimes ++;
                    pastaPrice = pastaSelectedTimes * PRICEOFPASTA;
                    pastaSelectedTextView.setText("x"+ pastaSelectedTimes);
                    pastaPriceTextView.setText(String.valueOf(pastaPrice));
                }

            }
        });
        pastaRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pastaSelectedTimes --;
                if(pastaSelectedTimes < 0){
                    alertMinMessage();
                    pastaSelectedTimes ++;
                }else {
                    pastaPrice = pastaSelectedTimes * PRICEOFPASTA;
                    pastaSelectedTextView.setText("x"+ pastaSelectedTimes);
                    pastaPriceTextView.setText(String.valueOf(pastaPrice));
                }
            }
        });
        // ----- EGGS ADD AND REMOVE BUTTON -----
        eggsAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(eggsSelectedTimes >=4){
                    alertMaxMessage();
                }else{
                    eggsSelectedTimes ++;
                    eggsPrice = eggsSelectedTimes * PRICEOFEGGS;
                    eggsSelectedTextView.setText("x"+ eggsSelectedTimes);
                    eggsPriceTextView.setText(String.valueOf(eggsPrice));
                }

            }
        });
        eggsRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eggsSelectedTimes --;
                if(eggsSelectedTimes < 0){
                    alertMinMessage();
                    eggsSelectedTimes ++;
                }else {
                    eggsPrice = eggsSelectedTimes * PRICEOFEGGS;
                    eggsSelectedTextView.setText("x"+ eggsSelectedTimes);
                    eggsPriceTextView.setText(String.valueOf(eggsPrice));
                }

            }
        });
        // ----- MILK ADD AND REMOVE BUTTON -----
        milkAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(milkSelectedTimes >= 4){
                    alertMaxMessage();
                }else{
                    milkSelectedTimes ++;
                    milkPrice = milkSelectedTimes * PRICEOFMILK;
                    milkSelectedTextView.setText("x"+ milkSelectedTimes);
                    milkPriceTextView.setText(String.valueOf(milkPrice));
                }

            }
        });
        milkRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                milkSelectedTimes --;
                if(milkSelectedTimes < 0){
                    alertMinMessage();
                    milkSelectedTimes ++;
                }else{
                    milkPrice = milkSelectedTimes * PRICEOFMILK;
                    milkSelectedTextView.setText("x"+ milkSelectedTimes);
                    milkPriceTextView.setText(String.valueOf(milkPrice));
                }

            }
        });

        // ----- DISCOUNT  AND TOTAL PRICE CALCULATION -----
        getTotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                noOfItemsSelected = breadSelectedTimes + pastaSelectedTimes + eggsSelectedTimes + milkSelectedTimes;
                beforeDiscountPrice =breadPrice + pastaPrice + eggsPrice + milkPrice ;

                // Get the Discount if more than one item is selected
                if(breadSelectedTimes > 1 || pastaSelectedTimes > 1 || eggsSelectedTimes > 1 || milkSelectedTimes >1 || noOfItemsSelected > 1){
                   discountedPrice = (int) (0.2 * beforeDiscountPrice);

                    totalPrice = beforeDiscountPrice - discountedPrice ;
                }
                else {
                    totalPrice = beforeDiscountPrice;
                    discountedPrice = 0;
                }

                //Display the value of the discount Price and the totalPrice
                discountTextView.setText(String.valueOf(discountedPrice));
                totalTextView.setText(String.valueOf(totalPrice));
            }
        });

        // ------ TO GO TO THE ABOUT ACTIVITY OF THIS APP -----
        // This is used to show the about section of this app
        aboutImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });

        // ----- BUTTON TO CLEAR THE ENTRIES MADE -----
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                breadSelectedTimes = pastaSelectedTimes = eggsSelectedTimes = milkSelectedTimes = noOfItemsSelected = discountedPrice = totalPrice = 0;
                breadPrice = pastaPrice = eggsPrice = milkPrice = 0;

                breadSelectedTextView.setText("x" + breadSelectedTimes);
                breadPriceTextView.setText(String.valueOf(breadPrice));

                pastaSelectedTextView.setText("x" + pastaSelectedTimes);
                pastaPriceTextView.setText(String.valueOf(pastaPrice));

                eggsSelectedTextView.setText("x" + eggsSelectedTimes);
                eggsPriceTextView.setText(String.valueOf(eggsPrice));

                milkSelectedTextView.setText("x"+ milkSelectedTimes);
                milkPriceTextView.setText(String.valueOf(milkPrice));

                discountTextView.setText(String.valueOf(discountedPrice));
                totalTextView.setText(String.valueOf(totalPrice));
            }
        });
    }

    // ----- Method used to invoke an Alert Dialog that shows that you cannot select more than 4 of the same items.
    private void alertMaxMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Warning!");
        builder.setMessage("You cannot select more than 4 items of the same item.");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    // This method is used to invoke an alert Dialog that shows that you cannot select a negative no of items
    private void alertMinMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Warning!");
        builder.setMessage("You cannot select a negative number of this item.");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }
}