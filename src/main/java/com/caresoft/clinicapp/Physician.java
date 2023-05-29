package com.caresoft.clinicapp;

import java.util.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser{

//... imports class definition...

    // Inside class:
    private ArrayList<String> patientNotes;

    // TO DO: Constructor that takes an ID
     public Physician (int id){
            super(id);
     }
    // TO DO: Implement HIPAACompliantUser!

    public boolean assignPin(int pin){
        if ( pin>999 && pin<10000 ){
            return true;
        }
        return false;
    }
    public boolean accessAuthorized(Integer authorizedID){
         if(this.id == authorizedID) {
             return true;
         }
         return false;
    }

    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
                "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    // TO DO: Setters & Getters

}
