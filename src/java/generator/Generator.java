/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Random;

/**
 *
 * @author Marc
 */
public class Generator {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String fName;
    private String lName;
    private String address;
    private String city;

    private String[] fNameResource = {"Adam", "Anja", "Albert", "Ben", "Bonnie", "Brian", "Carl", "Chris", "Donald", "Donnie", "Howard", "James", "Janice", "Jeffrey", "John", "Judith", "Marc", "Matthew",
        "Michael", "Patricia", "Roger", "Roy", "Ruby", "Sven", "Sarah", "Sebastian", "Theresa"};
    private String[] lNameResource = {"Walker", "Carter", "Franklin", "Arnold", "Adams", "Johnson", "O'Conner", "Oliver", "Moore", "Hayes", "Reyes", "Vasquez", "Mccoy", "Webb", "Hall", "West", "Snyder",
        "Ruiz", "Bradley", "George", "Shaw", "Rose"};
    private String[] addressResource = {"370 Atlantic Avenue Temple Hills", "173 College Avenue Pompano Beach", "764 8th Avenue Schaumburg",
        "427 Highland Avenue Raeford", "506 Sunset Drive Chatsworth", "7 Cardinal Drive Helotes", "837 2nd Street North Atwater",
        "881 Sheffield Drive Reidsville", "998 Edgewood Road Fernandina Beach", "351 York Road Freehold", "863 Route 30 Wasilla",
        "455 Roberts Road Monroe", "943 Woodland Drive Bethel Park", "235 Maple Avenue Langhorne", "168 Fieldstone Drive Romulus",
        "960 Roberts Road Pikesville", "142 3rd Street North Garfield", "716 State Street Chaska", "830 Rose Street Florence",
        "951 Summer Street Niles"};
    private String[] cityResource = {"Heidelberg", "Serskamp", "Des Moines", "Coaldale", "Suarlee", "Montreal", "Norfolk County", "Stratford-upon-Avon", "Chatillon", "Slough", "Bergeggi", "Green Bay",
        "Bientina", "Bismil", "Hattiesburg", "Bungay", "Armstrong", "Krems an der Donau", "Gembloux", "Coutisse", "Campagna", "Koersel", "Kapolei", "Mirzapur-cum-Vindhyachal", "Sheikhupura", "Bovigny", "Berbroek",
        "Dipignano", "Vauda Canavese", "Saint-Hilarion", "Treppo Carnico", "Brandenburg", "Candidoni", "Béziers", "Bruderheim", "Verrayes", "Alloa", "Magdeburg", "Galashiels", "Piagge", "Lompret"};

    public Generator() {

    }

    public String getData(int amount, String values) {
        JsonArray names = new JsonArray();
       
        for (int i = 0; i < amount; i++) {
            JsonObject person = new JsonObject();
            if(values.contains("fname")){
            person.addProperty("fName", getRandomFName());
            }
            if(values.contains("lname")){
            person.addProperty("lName", getRandomLName());
            }
            if(values.contains("street")){
            person.addProperty("street", getRandomAddress());
            }
            if(values.contains("city")){
            person.addProperty("city", getRandomCity());
            }
            names.add(person);
        }

        return gson.toJson(names); //The JSON string is ready
    };

    private String getRandomFName() {
        Random rand = new Random();
        return fNameResource[rand.nextInt(fNameResource.length)];
    }

    private String getRandomLName() {
        Random rand = new Random();
        return lNameResource[rand.nextInt(lNameResource.length)];
    }

    private String getRandomAddress() {
        Random rand = new Random();
        return addressResource[rand.nextInt(addressResource.length)];
    }

    private String getRandomCity() {
        Random rand = new Random();
        return cityResource[rand.nextInt(cityResource.length)];
    }

}
