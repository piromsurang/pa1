package units.converter;

/**
 * List of units for Length class
 * 
 * @author Piromsurang
 *
 */
public enum UnitType {
	LENGTH( "Length", Length.values() ),
	AREA( "Area", Area.values() ),
	WEIGHT( "Weight", Weight.values() ),
	TIME( "Time", Time.values() );
	
	private final String name;
	private final Unit[] unit;
	
	/**
	 * constructor for UnitType class
	 * 
	 * @param name is the name of the Unit class
	 * @param unit is list of the units in Unit class
	 */
	private UnitType( String name, Unit[] unit ) {
		this.name = name;
		this.unit = unit;
	}
	
	/**
	 * get name of the Unit class
	 */
	public String toString() {
		return this.name;
	}
	
	/**
	 * get list of the unit in Unit class
	 * 
	 * @return get values of the Unit class
	 */
	public Unit[] getUnit() {
		return this.unit;
	}
}
