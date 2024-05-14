package in.adityashukla.lopark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BookSlotStatusActivity extends AppCompatActivity {

//    String [] slot = {"Slot 1","Slot 2","Slot 3","Slot 4","Slot 5","Slot 6"};
//    String [] carNumber={"RJ 25 6748","RJ 30 2348","RJ 43 6432","RJ 40 4322","RJ 21 5322","RJ 23 3442"};
//    String [] userName = {"Aditya Shukla","Ram Sharma","Shiva Roy","Sumant Kumar","Vishal Sharma","jay kumar"};


//    FirebaseDatabase firebaseDatabase,firebaseDatabase2;
//    DatabaseReference databaseReference,databaseReference2;
//    TextView slotValue,idValue,nameValue,numValue,statusValue;
//    TextView slotValueSecond,idValueSecond,nameValueSecond,numValueSecond,statusValueSecond;

    RecyclerView recyclerView ;
    ArrayList <User> list;
    MyAdapter myAdapter;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_slot_status);

        recyclerView = findViewById(R.id.recLayout);
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        recyclerView.setHasFixedSize(true);

//        MyAdapter myAdapter = new MyAdapter(slot,carNumber,userName);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    User user = snapshot.getValue(User.class);
                    list.add(user);
                }

                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

            }
        });






//        slotValue = findViewById(R.id.slotValue);
//        idValue = findViewById(R.id.idValue);
//        nameValue = findViewById(R.id.nameValue);
//        numValue = findViewById(R.id.numValue);
//        statusValue = findViewById(R.id.statusValue);
//
//        slotValueSecond = findViewById(R.id.slotValueSecond);
//        idValueSecond = findViewById(R.id.idValueSecond);
//        nameValueSecond = findViewById(R.id.nameValueSecond);
//        numValueSecond = findViewById(R.id.numValueSecond);
//        statusValueSecond = findViewById(R.id.statusValueSecond);

//        firebaseDatabase = FirebaseDatabase.getInstance();
//        firebaseDatabase2 = FirebaseDatabase.getInstance();


//
//        databaseReference = firebaseDatabase.getReference("User1");
//
//       databaseReference.addValueEventListener(new ValueEventListener() {
//           @Override
//           public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//               String value = snapshot.child("data").getValue(String.class);
//               slotValue.setText(value);
//
//               String value1 = snapshot.child("id").getValue(String.class);
//               idValue.setText(value1);
//
//               String value2 = snapshot.child("name").getValue(String.class);
//               nameValue.setText(value2);
//
//               String value3 = snapshot.child("number").getValue(String.class);
//               numValue.setText(value3);
//
//               String value4 = snapshot.child("status").getValue(String.class);
//               statusValue.setText(value4);
//
//           }
//
//
//
//           @Override
//           public void onCancelled(@NonNull DatabaseError error) {
//               Toast.makeText(BookSlotStatusActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
//           }
//       });
//
//
//
//        databaseReference2 = firebaseDatabase2.getReference("User2");
//
//        databaseReference2.addValueEventListener(new ValueEventListener() {
//            @Override
//
//            public void onDataChange(@NonNull DataSnapshot snapshot1) {
//
//                //               data second user *********
//
//                String valueSecond = snapshot1.child("data2").getValue(String.class);
//                slotValueSecond.setText(valueSecond);
//
//                String value1Second = snapshot1.child("id2").getValue(String.class);
//                idValueSecond.setText(value1Second);
//
//                String value2Second = snapshot1.child("name2").getValue(String.class);
//                nameValueSecond.setText(value2Second);
//
//                String value3Second = snapshot1.child("number2").getValue(String.class);
//                numValueSecond.setText(value3Second);
//
//                String value4Second = snapshot1.child("status2").getValue(String.class);
//                statusValueSecond.setText(value4Second);
//            }
//
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(BookSlotStatusActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
//            }
//        });
//            }
//


    }
}