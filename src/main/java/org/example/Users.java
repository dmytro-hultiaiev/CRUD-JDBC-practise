package org.example;

public class Users {
    private int DBid;
    private String login;
    private String car_brand;
    private String car_model;

    public Users(String login, String car_brand, String car_model) {
        this.login = login;
        this.car_brand = car_brand;
        this.car_model = car_model;
    }

    public Users(int DBid, String login, String car_brand, String car_model) {
        this.DBid = DBid;
        this.login = login;
        this.car_brand = car_brand;
        this.car_model = car_model;
    }

    public int getDBid() {
        return DBid;
    }

    public void setDBid(int DBid) {
        this.DBid = DBid;
    }

    public String getLogin() {
        return login;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) {
            return true;
        }

        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

        Users user = (Users) obj;

        return login.equals(user.getLogin()) && car_brand.equals(user.getCar_brand()) && car_model.equals(user.getCar_model());
    }

    @Override
    public String toString() {
        return "Users{" +
                "DBid=" + DBid +
                ", login='" + login + '\'' +
                ", car_brand='" + car_brand + '\'' +
                ", car_model='" + car_model + '\'' +
                '}';
    }
}
