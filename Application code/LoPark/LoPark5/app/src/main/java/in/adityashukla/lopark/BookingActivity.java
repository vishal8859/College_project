package in.adityashukla.lopark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import in.adityashukla.lopark.ModulBooking.BookModel;
import in.adityashukla.lopark.ModulBooking.SlotAdapter;


public class BookingActivity extends AppCompatActivity {

RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        recyclerView = findViewById(R.id.recyViewBooking);

        ArrayList<BookModel> bookModelArrayList = new ArrayList<BookModel>();
        bookModelArrayList.add(new BookModel("Slot 1",R.drawable.card2));
        bookModelArrayList.add(new BookModel("Slot 2",R.drawable.card2));
        bookModelArrayList.add(new BookModel("Slot 3",R.drawable.card2));
        bookModelArrayList.add(new BookModel("Slot 4",R.drawable.card2));

        SlotAdapter slotAdapter = new SlotAdapter(this,bookModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.


        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(slotAdapter);





    }



}