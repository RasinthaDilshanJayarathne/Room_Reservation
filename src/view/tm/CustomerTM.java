package view.tm;

import javafx.scene.control.Button;

public class CustomerTM {
    private String id;
    private String name;
    private String nic;
    private String contact;
    private String email;
    private String address;
    private String checkIn;
    private Button btn;
    private Button btn1;

    public CustomerTM(String id, String txtAvailable, String txtNotAvailable, Button btn) {
    }

    public CustomerTM(String id, String name, String nic, String contact, String email, String address, String checkIn, Button btn, Button btn1) {
        this.setId(id);
        this.setName(name);
        this.setNic(nic);
        this.setContact(contact);
        this.setEmail(email);
        this.setAddress(address);
        this.setCheckIn(checkIn);
        this.setBtn(btn);
        this.setBtn1(btn1);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public Button getBtn1() {
        return btn1;
    }

    public void setBtn1(Button btn1) {
        this.btn1 = btn1;
    }
}
