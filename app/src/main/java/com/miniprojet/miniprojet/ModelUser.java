package com.miniprojet.miniprojet;

public class ModelUser {
    String name,email,phone,image,search,uid ;

    public ModelUser() {
    }

    public ModelUser(String name, String email, String phone, String image, String search, String uid) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.image = image;
        this.search = search;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}