package units.converter;

/**
 * List of units in Area class
 * 
 * @author Piromsurang
 *
 */
public enum Area implements Unit {
	SQUARE_METER( "square_meter", 1 ),
	SQUARE_CENTIMETER( "square_centimeter", 10000 ),
	SQUARE_KILOMETER( "square_kilometer", 0.000001 ),
	SQUARE_MILE( "square_mile", 3.86 * Math.pow( 10, -7 ) ),
	SQUARE_FOOT( "square_feet", 10.76 ),
	SQUARE_WA( "square_wa", 0.25 );
	
	public final double area;
	public final String name;

	/**
	 * constructor for Area class
	 * 
	 * @param name is the name of the unit
	 * @param area is the amount of the unit per 1 square meter
	 */
	private Area( String name, double area ) {
		this.name = name;
		this.area = area;
	}
	
	/**
	 * @return value of the unit
	 */
	public double getValue() {
		return this.area;
	}
	
	/**
	 * 
	 * @return the name of the unit
	 */
	@Override
	public String toString() {
		return this.name();
	}
}
