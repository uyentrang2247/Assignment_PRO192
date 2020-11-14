/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmnet_pro192_tqt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public abstract class Tour implements ITour {
    protected String tourCode;
    protected String tourTitle;
    protected double tourPrice;
    protected boolean tourTransport; // true for aircraft, flase for car
    protected String startDate;
    protected String endDate;

    Scanner sc = new Scanner(System.in);
    
    public Tour() {
    }

    public Tour(String tourCode, String tourTitle, double tourPrice, boolean tourTransport, String startDate, String endDate) {
        this.tourCode = tourCode;
        this.tourTitle = tourTitle;
        this.tourPrice = tourPrice;
        this.tourTransport = tourTransport;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public String getTourCode() {
        return tourCode;
    }
    
    public void setTourCode(String tourCode) {
        System.out.print("Input tourCode: ");
        tourCode = sc.next();
        this.tourCode = tourCode;
    }

    public String getTourTitle() {
        return tourTitle;
    }

    public void setTourTitle(String tourTitle) {
        sc.nextLine();
        System.out.print("Input tourTitle: ");
        tourTitle = sc.nextLine();
        this.tourTitle = tourTitle;
    }

    public double getTourPrice() {
        return tourPrice;
    }

    public void setTourPrice(double tourPrice) {
        System.out.print("Input tourPrice: ");
        tourPrice = sc.nextDouble();
        this.tourPrice = tourPrice;
    }

    public boolean isTourTransport() {
        return tourTransport;
    }

    public void setTourTransport(boolean tourTransport) {
        System.out.print("Input tourTransport(true= aircraft, false= car): ");
        tourTransport = sc.nextBoolean();
        this.tourTransport = tourTransport;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        System.out.print("Input startDate(dd/MM/yyy): ");
        startDate = sc.next();
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        sc.nextLine();
        System.out.print("Input endDate(dd/MM/yyy): ");
        endDate = sc.next();
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Tour{" + "tourCode= " + tourCode 
                + ", tourTitle= " + tourTitle 
                + ", tourPrice= " + tourPrice 
                + ", tourTransport= " + tourTransport 
                + ", starDate= " + startDate 
                + ", endDate= " + endDate ;
    }
    
 

    public abstract double surcharge();
}
