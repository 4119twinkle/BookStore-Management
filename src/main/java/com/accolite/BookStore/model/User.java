package com.accolite.BookStore.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    long user_id;
    @Column(name = "user_name")
    String user_name;
    @Column(name = "phone_no")
    long phone_no;
    @Column(name = "email")
    String email;
    @Column(name = "is_suspended")
    int is_suspended;
    @Column(name = "wallet_amount")
    double wallet_amount;

    public long getUser_id(){
        return user_id;
    }
    public void setUser_id(long user_id){
        this.user_id = user_id;
    }
    public String getUser_name(){
        return user_name;
    }
    public void setUser_name(String user_name){
        this.user_name = user_name;
    }
    public long getPhone_no(){
        return phone_no;
    }
    public void setPhone_no(long phone_no){
        this.phone_no = phone_no;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public int getSuspended(){
        return is_suspended;
    }
    public void setSuspended(int is_suspended){
        this.is_suspended = is_suspended;
    }
    public double getWallet_amount(){
        return wallet_amount;
    }
    public void setWallet_amount(double wallet_amount){
        this.wallet_amount = wallet_amount;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", phone_no=" + phone_no +
                ", email='" + email + '\'' +
                ", is_suspended=" + is_suspended +
                ", wallet_amount=" + wallet_amount +
                '}';
    }

}
