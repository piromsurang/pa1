package units.converter;

/**
 * 
 * @author Piromsurang
 *
 */
public class UnitConverter {
	
	
	/**
	 * convert distance of input unit to distance of output unit
	 * 
	 * @param amount is amount that is input by the user
	 * @param fromUnit is input unit
	 * @param toUnit is output unit
	 * @return return result
	 */
	public double convert( double amount, Unit fromUnit, Unit toUnit ) {
		
		double x = amount * toUnit.getValue() / fromUnit.getValue();
		
		return x;
	}
	
	/**
	 * 
	 * @return array of all unit types
	 */
	public UnitType[] getUnitType() {
		return UnitType.values();
	}
}
