package units.converter;


public class ConverterApp {
	
	/**
	 * main app for running unit converter
	 * @param args 
	 */
	public static void main( String[] args ) {
		UnitConverter converter = new UnitConverter();
		ConverterUI converterUI = new ConverterUI( converter );
		converterUI.run();
	}
}
