package in.adityashukla.lopark;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.razorpay.Checkout;


public class SlotActivity extends Activity {

    TextView slotNumberId;
    EditText name, carNumber, duration, phoneNumber, email;
    AppCompatButton addButton;

    private FirebaseDatabase database;
    private DatabaseReference parkingSlotsRef;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot);

        slotNumberId = findViewById(R.id.setText);

        name = findViewById(R.id.nameBook);
        carNumber = findViewById(R.id.carBook);
        duration = findViewById(R.id.durationBook);
        phoneNumber = findViewById(R.id.numBook);
        email = findViewById(R.id.emailId);

        addButton = findViewById(R.id.bookSlot);

        slotNumberId.setText(getIntent().getExtras().getString("message_key"));

        Checkout.preload(getApplicationContext());


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullName, carId, phone, emailAddress;
                int durationTime;

                fullName = name.getText().toString();
                carId = carNumber.getText().toString();
                durationTime = Integer.parseInt(duration.getText().toString());
                phone = phoneNumber.getText().toString();
                emailAddress = email.getText().toString();
                long bookingTime = System.currentTimeMillis();

                String val = slotNumberId.getText().toString();



                database = FirebaseDatabase.getInstance();

                parkingSlotsRef = database.getReference("parking-slots");
                DatabaseReference slotRef = parkingSlotsRef.child(val);

                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                                    Slot slot = new Slot();

                                    slot.setName(fullName);
                                    slot.setDuration(durationTime);
                                    slot.setCarNumber(carId);
                                    slot.setContact(phone);
                                    slot.setEmail(emailAddress);

                                    int amount = durationTime * 100;
                                    slotRef.setValue(slot);

                                    Toast.makeText(SlotActivity.this, "Done...", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(SlotActivity.this, PaymentPage.class);
                                    startActivity(intent);
                                    finish();



                    }
                });


            }
        });
    }

}