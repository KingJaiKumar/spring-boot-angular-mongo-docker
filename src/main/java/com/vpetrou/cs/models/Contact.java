package com.vpetrou.cs.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Document(collection = "contacts")
@ApiModel(description = "All details about the Contact. ")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated contact ID", hidden = true)
    String id;

    @NotNull
    @Size(min = 1, max = 90)
    @ApiModelProperty(notes = "The contact's name", required = true)
    String name;

    @Size(min = 0, max = 90)
    @ApiModelProperty(notes = "The contact's address")
    String address;

    @NotEmpty
    @NotNull
    @Size(min = 1, max = 30)
    @Pattern(regexp = "^(Athens|Thessaloniki|Patra|Kavala|Serres)$")
    @ApiModelProperty(notes = "The contact's city", required = true, allowableValues = "Athens|Thessaloniki|Patra|Kavala|Serres")
    String city;

    @Size(min = 0, max = 30)
    @ApiModelProperty(notes = "The contact's phone")
    String phone;

    @NotNull
    @Size(min = 1, max = 90)
    @ApiModelProperty(notes = "The contact's email (must be unique)", required = true, allowableValues = "mustBeUnique@mail.com")
    String email;

    @NotNull
    @Size(min = 1, max = 1)
    @Pattern(regexp = "^(m|f)$")
    @ApiModelProperty(notes = "The contact's gender", required = true, allowableValues = "m|f")
    String gender;

    @NotNull
    @Size(min = 4, max = 5)
    @Pattern(regexp = "^(false|true)$")
    @ApiModelProperty(notes = "Is contact disabled?", required = true, allowableValues = "false|true")
    String disabled;

    public Contact() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }
}
