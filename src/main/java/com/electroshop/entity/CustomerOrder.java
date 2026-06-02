package com.electroshop.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomerOrder {
    private Long id;
    private String recipientName;
    private String phone;
    private String address;
    private String note;
    private String status = "PENDING";
    private List<CartLine> lines = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRecipientName() { return recipientName; }
    public void setRecipientName(String recipientName) { this.recipientName = recipientName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<CartLine> getLines() { return lines; }
    public void setLines(List<CartLine> lines) { this.lines = lines; }
    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (CartLine line : lines) total = total.add(line.getSubtotal());
        return total;
    }
}
