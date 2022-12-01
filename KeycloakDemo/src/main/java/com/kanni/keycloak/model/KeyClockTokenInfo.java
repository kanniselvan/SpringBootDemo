package com.kanni.keycloak.model;

import lombok.Data;
import lombok.ToString;
import org.keycloak.representations.AccessToken;


@Data
@ToString
public class KeyClockTokenInfo {


    protected String name;

    protected String givenName;

    protected String familyName;

    protected String middleName;

    protected String nickName;

    protected String preferredUsername;

    protected String profile;

    protected String picture;

    protected String website;

    protected String email;

    protected String gender;

    protected String birthdate;

    protected String zoneinfo;

    protected String locale;

    protected String phoneNumber;

    protected Boolean phoneNumberVerified;

    protected String formattedAddress;

    protected String streetAddress;

    protected String locality;

    protected String region;

    protected String postalCode;

    protected String country;

    protected Long updatedAt;

    protected String claimsLocales;

    protected String acr;

    public KeyClockTokenInfo(AccessToken token) {
        this.acr = token.getAcr();
        this.claimsLocales = token.getClaimsLocales();
        this.updatedAt = token.getUpdatedAt();
        this.country = token.getAddress()!=null?token.getAddress().getCountry():null;
        this.name = token.getName();
        this.givenName = token.getGivenName();
        this.familyName = token.getFamilyName();

        this.middleName = token.getMiddleName();

        this.nickName = token.getNickName();

        this.preferredUsername = token.getPreferredUsername();

        this.profile = this.getProfile();

        this.picture = this.getPicture();

        this.website = token.getWebsite();

        this.email = token.getEmail();

        this.gender = token.getGender();

        this.birthdate = token.getBirthdate();

        this.zoneinfo = token.getZoneinfo();

        this.locale = token.getLocale();

        this.phoneNumber = token.getPhoneNumber();

    }
}
