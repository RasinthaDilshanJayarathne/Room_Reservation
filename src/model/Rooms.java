package model;

public class Rooms {
    private String id;
    private String type;
    private String charges;
    private String offers;

    public Rooms() {
    }

    public Rooms(String id, String type, String charges, String offers) {
        this.setId(id);
        this.setType(type);
        this.setCharges(charges);
        this.setOffers(offers);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }
}
