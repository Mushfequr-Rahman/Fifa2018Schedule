package com.bashundhara.mushfequr.fifa2018schedule;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "INFO")
public class User {
    @PrimaryKey
    private int uid;



    @ColumnInfo(name = "ID")
    private String email_address;

    @ColumnInfo(name = "Phone_Number")
    private String phone_number;



    @ColumnInfo(name="Game")
    private String game_info;

    @ColumnInfo(name="Answer_1")
    private String answer_1;

    @ColumnInfo(name="Answer_2")
    private String answer_2;

    @ColumnInfo(name="Answer_3")
    private String answer_3;

    @ColumnInfo(name="Save_Answers")
    private boolean answers_saved=false;

    @ColumnInfo(name="Submitted_answers")
    private boolean answers_submitted=false;

    // Getters and setters are ignored for brevity,

    public User()
    {

    }

    public  User(String email_address,String Phone_number,String game_info,String answer_1,String answer_2,String answer_3){
        this.email_address=email_address;
        this.phone_number=Phone_number;
        this.game_info=game_info;
        this.answer_1=answer_1;
        this.answer_2=answer_2;
        this.answer_3=answer_3;
    }
    //GETTERS SET UP
    public int getUid() {
        return uid;
    }

    public String getEmail_address() {
        return email_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getGame_info() {
        return game_info;
    }

    public String getAnswer_1() {
        return answer_1;
    }

    public String getAnswer_2() {
        return answer_2;
    }

    public String getAnswer_3() {
        return answer_3;
    }

    public boolean isAnswers_saved() {
        return answers_saved;
    }

    public boolean isAnswers_submitted() {
        return answers_submitted;
    }

     //SETTERS SET UP


    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setGame_info(String game_info) {
        this.game_info = game_info;
    }

    public void setAnswer_1(String answer_1) {
        this.answer_1 = answer_1;
    }

    public void setAnswer_2(String answer_2) {
        this.answer_2 = answer_2;
    }

    public void setAnswer_3(String answer_3) {
        this.answer_3 = answer_3;
    }

    public void setAnswers_saved(boolean answers_saved) {
        this.answers_saved = answers_saved;
    }

    public void setAnswers_submitted(boolean answers_submitted) {
        this.answers_submitted = answers_submitted;
    }


    public void Change_Save_State()
    {
        this.answers_saved=true;
    }
    public void Change_Submit_State()
    {
        this.answers_submitted=true;
    }


    // but they're required for Room to work.
}