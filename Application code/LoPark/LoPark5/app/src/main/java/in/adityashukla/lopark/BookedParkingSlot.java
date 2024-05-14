package in.adityashukla.lopark;

public class BookedParkingSlot {

    public String getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(String slotNo) {
        this.slotNo = slotNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(long bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String slotNo="";

    public String name;
    public String phoneNumber;
    public int duration;
    public long bookingTime;
    public String carNumber;
    public String email;

    public BookedParkingSlot() {
        // Default constructor required for calls to DataSnapshot.getValue(BookedParkingSlot.class)
    }

    public BookedParkingSlot(String slotNo, String name, String phoneNumber, int duration, long bookingTime, String carNumber, String email) {
        this.slotNo = slotNo;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.duration = duration;
        this.bookingTime = bookingTime;
        this.carNumber = carNumber;
        this.email = email;
    }
}
