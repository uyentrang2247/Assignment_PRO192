/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmnet_pro192_tqt;

import java.util.Comparator;

/**
 *
 * @author truon
 */
public class SortByPrice implements Comparator<Tour> {

    @Override
    public int compare(Tour o1, Tour o2) {
        double tour1 = o1.getTourPrice();
        double tour2 = o2.getTourPrice();
        if (tour1 < tour2) {
            return 1;
        } else if (tour1 == tour2) {
            return 0;
        } else {
            return -1;
        }
    }
}
