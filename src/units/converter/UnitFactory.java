package units.converter;

/**
 * Factory for all units
 * 
 * @author Piromsurang
 *
 */
public class UnitFactory {
	private static UnitFactory instance = null;
	private UnitType unitType;
	
	/**
	 * constructor for UnitFactory
	 */
	protected UnitFactory() {

	}
	
	/**
	 * 
	 * @return the unitFactory 
	 */
	public static UnitFactory getInstance() {
		if ( instance == null ) {
			instance = new UnitFactory();
		}
		return instance;
	}
	
	/**
	 * get all unit types
	 * @return all unit types in array
	 */
	public UnitType[] getUnitType() {
		return UnitType.values();
	}
	
	/**
	 * 
	 * @param utype is the unit types 
	 * @return all units in the unit type
	 */
	public Unit[] getUnits( UnitType utype ) {
		return utype.getUnit();
	}
}
