package units.converter;
/**
 * 
 * @author Piromsurang
 *
 */
public enum Length implements Unit {
	METER( "meter", 1.0 ),
	CENTIMETER( "centimeter", 100.0 ),
	KILOMETER( "kilometer", 0.001 ),
	MILE( "mile", 0.000621371 ),
	FOOT( "feet", 3.28084 ),
	WA( "wa", 0.5 );
	
	
	public final double distance;
	public final String name;

	/**
	 * 
	 * @param n is the input name
	 * @param d is the input distance
	 */
	private Length( String n, double d ) {
		this.distance = d;
		this.name = n;
	}
	
	/**
	 * 
	 * @return return distance
	 */
	public double getValue() {
		return this.distance;
	}
	
	/**
	 * 
	 * @return return name
	 */
	@Override
	public String toString() {
		return this.name;
	}
}
