package units.converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Piromsurang
 *
 */
public class ConverterUI extends JFrame{
	
	private JMenu menu;
	private JMenuBar menuBar;
	private JTextField leftTextField;
	private JComboBox leftUnitList;
	private JLabel equalSign;
	private JTextField rightTextField;
	private JComboBox rightUnitList;
	private JButton convertButton;
	private JButton clearButton;
	private JRadioButton leftToRight;
	private JRadioButton rightToLeft;
	private UnitConverter converter;
	
	/**
	 * constructor for ConverterUI class
	 * @param unitConverter
	 */
	public ConverterUI( UnitConverter unitConverter ) {
		super( "Units Converter" );
		this.converter = unitConverter;
		this.initComponent();
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	/**
	 * to run this GUI
	 */
	public void run() {
		pack();
		this.setVisible( true );
	}
	
	/**
	 * components in this GUI
	 */
	public void initComponent() {
		JPanel panel = new JPanel();
		panel.setLayout( new GridLayout( 3, 1 ) );
		
		menuBar = new JMenuBar();
		menu = this.makeMenu();
		menuBar.add( menu );
		
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout( new FlowLayout() );
		ConvertButtonListener convertListener = new ConvertButtonListener();
		leftTextField = new JTextField( 10 );
		leftTextField.addActionListener( convertListener );;
		leftUnitList = new JComboBox( Length.values() );
		equalSign = new JLabel( "  =  " );
		rightTextField = new JTextField( 10 );
		rightTextField.addActionListener( convertListener );
		rightUnitList = new JComboBox( Length.values() );
		convertButton = new JButton( "convert!" );
		convertButton.addActionListener( convertListener );
		clearButton = new JButton( "clear" );
		clearButton.addActionListener( new ClearButtonListener() );
		middlePanel.add( leftTextField );
		middlePanel.add( leftUnitList );
		middlePanel.add( equalSign );
		middlePanel.add( rightTextField );
		middlePanel.add( rightUnitList );
		middlePanel.add( convertButton );
		middlePanel.add( clearButton );
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout( new FlowLayout() );
		ViceVersaListener viceversa = new ViceVersaListener();
		leftToRight = new JRadioButton( "Left -> Right", true );
		leftToRight.addActionListener( viceversa );
		rightToLeft = new JRadioButton( "Right -> Left" );
		rightToLeft.addActionListener( viceversa );
		ButtonGroup buttonGroup = new ButtonGroup();	
		buttonGroup.add( leftToRight );
		buttonGroup.add( rightToLeft );	
		bottomPanel.add( leftToRight );
		bottomPanel.add( rightToLeft );
		
		panel.add( menuBar );
		panel.add( middlePanel );
		panel.add( bottomPanel );
		
		this.add( panel );
	}
	
	/**
	 * method for creating manu
	 * 
	 * @return menu with item list
	 */
	private JMenu makeMenu() {
		JMenu menu = new JMenu( "Units" );
		UnitType[] unitsType = converter.getUnitType();
		for ( UnitType unit : unitsType ) {
			JMenuItem menuItem = new JMenuItem( unit.toString() );
			menuItem.addActionListener( new UnitAction( unit ) );
			menu.add( menuItem );
		}
		menu.addSeparator();
		JMenuItem exit = new JMenuItem( "Exit" );
		exit.addActionListener( new ExitAction( this ) );
		menu.add( exit );
		
		return menu;
	}
	
	/**
	 * actionListener for converting
	 * 
	 * @author Piromsurang
	 *
	 */
	class ConvertButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent e ) {


			if ( leftTextField.isEnabled() == true ) {
				String s = leftTextField.getText().trim();
				if ( s.length() > 0 ) {
					try {
						double inputValue = Double.valueOf( s );
						double outputValue = converter.convert( inputValue, ( Unit ) leftUnitList.getSelectedItem(), ( Unit ) rightUnitList.getSelectedItem() );

						rightTextField.setText( outputValue + "" );
					} catch ( NumberFormatException a ) {
						JOptionPane.showMessageDialog( null , "That's not a number!" );
					}

				}
			}

			else {
				String s = rightTextField.getText().trim();

				if ( s.length() > 0 ) {
					try {
						double inputValue = Double.valueOf( s );
						double outputValue = converter.convert( inputValue,( Unit ) rightUnitList.getSelectedItem(),( Unit ) leftUnitList.getSelectedItem() );

						leftTextField.setText( outputValue + "" );
					} catch ( NumberFormatException a ) {
						JOptionPane.showMessageDialog( null , "That's not a number!" );
					}

				}
			}
		}
	}
	
	/**
	 * actionListener for clearing all
	 * 
	 * @author Piromsurang
	 *
	 */
	class ClearButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent e ) {
			leftTextField.setText( "" );
			rightTextField.setText( "" );
			leftUnitList.setSelectedIndex( 0 );
			rightUnitList.setSelectedIndex( 0 );
		}
	}
	
	/**
	 * actionListener for switching between left to right and right to left textField
	 * 
	 * @author Piromsurang
	 *
	 */
	class ViceVersaListener implements ActionListener {
		public void actionPerformed( ActionEvent e ) {
			if ( leftToRight.isSelected() ) {
				rightTextField.setEnabled( false );
				leftTextField.setEnabled( true );
			}
			else if ( rightToLeft.isSelected() ) {
				leftTextField.setEnabled( false );
				rightTextField.setEnabled( true );
			}
		}
	}
	
	/**
	 * actionListener for menuItem 
	 * 
	 * @author Piromsurang
	 *
	 */
	class UnitAction extends AbstractAction {
		UnitType utype;
		public UnitAction( UnitType utype) {
			super( utype.toString() );
			this.utype = utype;
		}
		public void actionPerformed( ActionEvent e ) {
			leftUnitList.removeAllItems();
			rightUnitList.removeAllItems();
			
			for ( int i = 0 ; i < utype.getUnit().length ; i++ ) {
				leftUnitList.addItem( utype.getUnit()[i] );
				rightUnitList.addItem( utype.getUnit()[i] );
			}
		}
	}
	
	/**
	 * actionListener for exit
	 * 
	 * @author Piromsurang
	 *
	 */
	class ExitAction extends AbstractAction {
		JFrame frame;
		public ExitAction( JFrame frame ) {
			super( "Exit" );
			this.frame = frame;
		}	
		
		public void actionPerformed( ActionEvent e ){
			frame.setVisible( false );
		}
	}
}
