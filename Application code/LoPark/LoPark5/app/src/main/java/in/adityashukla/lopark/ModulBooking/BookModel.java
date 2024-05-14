package in.adityashukla.lopark.ModulBooking;

import androidx.cardview.widget.CardView;

public class BookModel {

    public BookModel(CardView cardView) {
        this.cardView = cardView;
    }

    public CardView getCardView() {
        return cardView;
    }

    public void setCardView(CardView cardView) {
        this.cardView = cardView;
    }

    CardView cardView;
    public BookModel(String slot, int image) {
        this.slot = slot;
        this.image = image;
    }

    String slot;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private int image;

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }


}
