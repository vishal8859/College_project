package in.adityashukla.lopark;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {



//    String [] slot;
//    String [] carNumber;
//    String [] userName;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    Context context;

    ArrayList<User> list;

//    public MyAdapter(String[] slot, String[] carNumber, String[] userName) {
//        this.slot = slot;
//        this.carNumber = carNumber;
//        this.userName = userName;
//    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         FirebaseDatabase database;
         DatabaseReference parkingSlotsRef;
//        holder.slotId.setText(slot[position]);
//        holder.bookingId.setText(carNumber[position]);
//        holder.userName.setText(userName[position]);

        database = FirebaseDatabase.getInstance();



        User user = list.get(position);
        holder.bookingId.setText(user.getCarNumber());
        holder.userName.setText(user.getUserName());

        parkingSlotsRef = database.getReference("parking-slots");

        DatabaseReference slotRef = parkingSlotsRef.child(user.getSlotId());



        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                slotRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {

                            Toast.makeText(v.getContext(),"Booked", Toast.LENGTH_SHORT).show();

                        } else {
                            Intent intent = new Intent(v.getContext(), SlotActivity.class);
                            intent.putExtra("message_key", user.getSlotId());

                            v.getContext().startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e(TAG, "onCancelled",error.toException());
                    }
                });


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{

        private TextView slotId,bookingId,userName;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            slotId = (TextView) itemView.findViewById(R.id.getSlotId);
            bookingId = (TextView) itemView.findViewById(R.id.getBookedStatusId);
            userName = (TextView) itemView.findViewById(R.id.getNameId);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
