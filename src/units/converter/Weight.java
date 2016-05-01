package units.converter;

/**
 * List of units in Weight class
 * 
 * @author Piromsurang
 *
 */
public enum Weight implements Unit {
	GRAM( "g", 1000 ),
	KILOGRAM( "kg", 1 ),
	TONNE( "tonne", 0.001 ),
	MILLIGRAM( "milligram", Math.pow( 10, 6 ) ),
	MICROGRAM( "microgram", Math.pow( 10, 9 ) ),
	POUND( "pound", 2.20462 ),
	OUNCE( "ounce", 35.2739201537888 );
	
	public final String name;
	public final double weight;
	
	/**
	 * constructor for Weight class
	 * 
	 * @param name is the name of the unit
	 * @param weight is the amount of the unit per one kilogram
	 */
	private Weight( String name, double weight ) {
		this.name = name;
		this.weight = weight;
	}
	
	/**
	 * get value of weight per one kilogram
	 * 
	 */
	public double getValue() {
		return this.weight;
	}
	
	/**
	 * get the name of the unit
	 */
	@Override
	public String toString() {
		return this.name;
	}
	
}
