package dataproviders;

import org.testng.annotations.DataProvider;

public class LocationsProvider {

	@DataProvider(name="locations")
	public String[][] getLocations() {
		String[][] locations = new String[][]
				{
					{"Bochum"},
					{"Karlsruhe"},
					{"Mannheim"},
					{"Augsburg"}
				};
				return locations;
				
	}
}
