package ru.sstu.ushankashop.dto;

import ru.sstu.ushankashop.domain.ShippingInfoEntity;

/**
 * @author Dmitry Tarasov
 * Date: 10/28/2017
 * Time: 18:35
 */
public class ShippingInfo {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String city;
    private String postalCode;
    private String firstString;
    private String secondString;

    public ShippingInfo() {
    }

    public ShippingInfo(ShippingInfoEntity entity) {
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.phoneNumber = entity.getPhoneNumber();
        this.city = entity.getCity();
        this.postalCode = entity.getPostalCode();
        this.firstString = entity.getFirstString();
        this.secondString = entity.getSecondString();
    }

    public ShippingInfoEntity toEntity(){
        ShippingInfoEntity entity = new ShippingInfoEntity();
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        entity.setPhoneNumber(phoneNumber);
        entity.setCity(city);
        entity.setPostalCode(postalCode);
        entity.setFirstString(firstString);
        entity.setSecondString(secondString);
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFirstString() {
        return firstString;
    }

    public void setFirstString(String firstString) {
        this.firstString = firstString;
    }

    public String getSecondString() {
        return secondString;
    }

    public void setSecondString(String secondString) {
        this.secondString = secondString;
    }
}
