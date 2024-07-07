package com.mainpackage.PasswordManager.model;

import jakarta.persistence.*;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cardid;
    @ManyToOne
    @JoinColumn(name = "elementid")
    private Element elementid;
    private String owner;
    private String publisher;
    private String numbers;
    private String secureCode;
    private String descryption;
    public Card(){}
    public Card(Element elementid, String owner, String publisher, String numbers, String secureCode, String descryption) {
        this.elementid = elementid;
        this.owner = owner;
        this.publisher = publisher;
        this.numbers = numbers;
        this.secureCode = secureCode;
        this.descryption = descryption;
    }

    public Long getCardid() {
        return cardid;
    }

    public void setCardid(Long cardid) {
        this.cardid = cardid;
    }

    public Element getElementid() {
        return elementid;
    }

    public void setElementid(Element elementid) {
        this.elementid = elementid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getSecureCode() {
        return secureCode;
    }

    public void setSecureCode(String secureCode) {
        this.secureCode = secureCode;
    }

    public String getDescryption() {
        return descryption;
    }

    public void setDescryption(String descryption) {
        this.descryption = descryption;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardid=" + cardid +
                ", elementid=" + elementid +
                ", owner='" + owner + '\'' +
                ", publisher='" + publisher + '\'' +
                ", numbers='" + numbers + '\'' +
                ", secureCode='" + secureCode + '\'' +
                ", descryption='" + descryption + '\'' +
                '}';
    }
}
