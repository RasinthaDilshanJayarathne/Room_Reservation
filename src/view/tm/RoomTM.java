package view.tm;

import javafx.scene.control.Button;

public class RoomTM {
    private String id;
    private String type;
    private String charges;
    private String offers;
    private Button btn;

    public RoomTM() {
    }

    public RoomTM(String id, String type, String charges, String offers, Button btn) {
        this.setId(id);
        this.setType(type);
        this.setCharges(charges);
        this.setOffers(offers);
        this.setBtn(btn);
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
