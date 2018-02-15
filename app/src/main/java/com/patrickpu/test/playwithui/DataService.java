package com.patrickpu.test.playwithui;

import java.util.ArrayList;

/**
 * Created by patrickpu on 2/15/2018.
 */

public class DataService {

    private static volatile DataService dataService;
    private ArrayList<Contact> contacts = new ArrayList<>();
    private ArrayList<String> sentences = new ArrayList<>();

    public DataService() {
        contacts.add(new Contact("Patrick", 28));
        contacts.add(new Contact("Emma", 18));
        contacts.add(new Contact("Richard", 37));
        contacts.add(new Contact("Yason", 31));

        sentences.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        sentences.add("minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo");
        sentences.add("est, qui dolorem ipsum quia dolor sit amet, consectetur");
        sentences.add("laboriosam, nisi ut aliquid ex ea commodi consequatur?");
    }

    public static DataService getInstance(){
        if (dataService == null){
            synchronized (DataService.class){
                if (dataService == null){
                    dataService = new DataService();
                }
            }
        }
        return dataService;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public ArrayList<String> getSentences() {
        return sentences;
    }
}
