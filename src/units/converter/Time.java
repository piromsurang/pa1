package units.converter;

/**
 * List of units in Time class
 * 
 * @author Piromsurang
 *
 */
public enum Time implements Unit {

	SECOND( "second", 60 ),
	MINUTE( "minute", 1 ),
	HOUR( "hour", 1.0 / 6 ),
	DAY( "day", 1.0 / 144 ),
	WEEK( "week", 1.0 / 1008 );
	
	public final String name;
	public final double time;
	
	/**
	 * constructor for Time class
	 * 
	 * @param name is the name of the unit
	 * @param time is the amount of the unit per sixty second
	 */
	private Time( String name, double time ) {
		this.name = name;
		this.time = time;
	}
	
	/**
	 * get amount of the unit
	 */
	public double getValue() {
		return this.time;
	}
	
	/**
	 * get the name of the unit
	 */
	@Override
	public String toString() {
		return this.name;
	}
}
