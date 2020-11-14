/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmnet_pro192_tqt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author ADMIN
 */
public class DomesticTour extends Tour {
    
    private double tourGuideTip;

    public DomesticTour() {
    }
    
    public DomesticTour(String tourCode, String tourTile, 
            double tourPrice, boolean tourTransport, 
            String startDate, String endDate, double tourGuideTip){
        super (tourCode, tourTile, tourPrice, tourTransport, startDate, endDate);
        this.tourGuideTip = tourGuideTip;
    }
    
    public double getTourGuideTip() {
        return tourGuideTip;
    }

    public void setTourGuideTip(double tourGuideTip) {
        System.out.print("Input tourGuideTip: ");
        tourGuideTip = sc.nextDouble();
        this.tourGuideTip = tourGuideTip;
    }
    
    public long numberOfDate(){
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
       LocalDate date1 = LocalDate.parse(getStartDate(),sdf);
       LocalDate date2 = LocalDate.parse(getEndDate(),sdf);
       
       long daysBetween = ChronoUnit.DAYS.between(date1, date2);
       
       return daysBetween;
    }
    @Override
    public double tourCharge(){
        return surcharge() + getTourPrice();
    }
    
    @Override
    public double surcharge(){
        return tourGuideTip*numberOfDate();
    }
    
    @Override
    public String toString(){
        return super.toString() + ", TourGuideTrip= " + tourGuideTip  + '}'; 
    }
    public DomesticTour input(){
        DomesticTour domesTour = new DomesticTour();
        domesTour.setTourCode(tourCode);
        domesTour.setTourTitle(tourTitle);
        domesTour.setTourPrice(tourPrice);
        domesTour.setTourTransport(tourTransport);
        domesTour.setStartDate(startDate);
        domesTour.setEndDate(endDate);
        domesTour.setTourGuideTip(tourGuideTip);
        return domesTour;
    }
}
