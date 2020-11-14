/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmnet_pro192_tqt;

/**
 *
 * @author ADMIN
 */
public class InternationalTour extends Tour {
    private double aviationTax; 
    private double entryFee;

    public InternationalTour() {
    }
    
    
    public InternationalTour(String tourCode, String tourTile, 
            double tourPrice, boolean tourTransport, 
            String startDate, String endDate, double aviationTax, double entryFee){
        super (tourCode, tourTile, tourPrice, tourTransport, startDate, endDate);
        this.aviationTax = aviationTax;
        this.entryFee = entryFee;
    }

    public double getAviationTax() {
        return aviationTax;
    }

    public void setAviationTax(double aviationTax) {
        System.out.print("Input aviationTax: ");
        aviationTax = sc.nextDouble();
        this.aviationTax = aviationTax;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        System.out.print("Input entryFee: ");
        entryFee = sc.nextDouble();
        this.entryFee = entryFee;
    }
    @Override
    public double tourCharge(){
        return surcharge() + getTourPrice();
    }
    
    @Override
    public double surcharge(){
        return aviationTax + entryFee;
    }
   
    @Override
    public String toString(){
        return super.toString() 
                + ", AivationTax= " + aviationTax 
                + ", entryFee= " + entryFee + + '}';
    }
    
    public InternationalTour input(){
        InternationalTour interTour = new InternationalTour();
        interTour.setTourCode(tourCode);
        interTour.setTourTitle(tourTitle);
        interTour.setTourPrice(tourPrice);
        interTour.setTourTransport(tourTransport);
        interTour.setStartDate(startDate);
        interTour.setEndDate(endDate);
        interTour.setAviationTax(aviationTax);
        interTour.setEntryFee(entryFee);
        return interTour;
    }
}
