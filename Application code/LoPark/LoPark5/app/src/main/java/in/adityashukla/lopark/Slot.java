package in.adityashukla.lopark;

public class Slot {


    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String name;
    private int duration;
    private String carNumber;
    private String contact;
    private String email;

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public Slot(String name, int duration, String carNumber, String contact, String email) {
        this.name = name;
        this.duration = duration;
        this.carNumber = carNumber;
        this.contact = contact;
        this.email = email;
    }

    public Slot() {
        // Default constructor required for calls to DataSnapshot.getValue(Slot.class)
    }


}

