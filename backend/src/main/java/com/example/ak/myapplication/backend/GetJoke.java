package com.example.ak.myapplication.backend;

/** The object model for the data we are sending through endpoints */
public class GetJoke {

    private String Joke;

    public String getData() {
        return Joke;
    }

    public void setData(String Joke) {
        this.Joke = Joke;
    }
}