package models;

import lombok.Data;

@Data
public class BillingDetails {
    private String address;
    private String city;
    private String postCode;
    private String country;
    private String region;
}
