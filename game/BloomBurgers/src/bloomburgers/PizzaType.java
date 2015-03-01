/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;

/**
 *
 * @author alexx
 */
public enum PizzaType {
    CAPRICIOSSA (0),
    QFORMAGGI (1),
    QSTAGIONNI (2),
    PEPPERONI (3),
    VEGETARIAN (4);
    
    private int intType;
    
    PizzaType(int intType)
    {
        this.intType = intType;
    }
}
