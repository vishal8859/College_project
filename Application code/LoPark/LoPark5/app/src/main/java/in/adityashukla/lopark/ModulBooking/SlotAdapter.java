package in.adityashukla.lopark.ModulBooking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.adityashukla.lopark.R;
import in.adityashukla.lopark.SlotActivity;

public class SlotAdapter extends RecyclerView.Adapter<SlotAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<BookModel> bookModelArrayList;

    public SlotAdapter(Context context, ArrayList<BookModel> bookModelArrayList) {
        this.context = context;
        this.bookModelArrayList = bookModelArrayList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        BookModel model = bookModelArrayList.get(position);
        holder.slot.setText(model.getSlot());
        holder.img.setImageResource(model.getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the Intent object of this class Context() to Second_activity class
                Intent intent = new Intent(v.getContext(), SlotActivity.class);
                // now by putExtra method put the value in key, value pair key is
                // message_key by this key we will receive the value, and put the string
                intent.putExtra("message_key", model.getSlot());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return bookModelArrayList.size();
    }

    class  ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView img;
        private final TextView slot;

        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            slot = (TextView) itemView.findViewById(R.id.textSlotBooking);
            img = (ImageView) itemView.findViewById(R.id.img_head);
            cardView = (CardView) itemView.findViewById(R.id.cardView);

        }
    }

}
