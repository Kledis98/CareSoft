package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin{
    //... imports class definition...

    // Inside class:
    private String role;
    private ArrayList<String> securityIncidents;

    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(int id, String role){
        super(id);
    }
    // TO DO: Implement HIPAACompliantUser!

    public boolean assignPin(int pin){
        if(pin>99999 && pin<1000000){
            return true;
        }
        return false;
    }

    // TO DO: Implement HIPAACompliantAdmin!

    public boolean accessAuthorized(Integer authorizedID){
        if ( this.id == authorizedID){
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return securityIncidents;
    }

    @Override
    public void printSecurityIncidents() {
        HIPAACompliantAdmin.super.printSecurityIncidents();
    }

    public void newIncident(String notes) {
        String report = String.format(
                "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n",
                new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
                "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n",
                new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    // TO DO: Setters & Getters


    public String getRole() {
        return role;
    }

    public ArrayList<String> getSecurityIncidents() {
        return securityIncidents;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSecurityIncidents(ArrayList<String> securityIncidents) {
        this.securityIncidents = securityIncidents;
    }
}
