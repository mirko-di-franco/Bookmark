package entities;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import constants.MovieGenre;
import managers.BookmarkManager;

public class MovieTest {

	@Test
	public void testIsKidFriendlyEligible() {
		//Test 1: horror genre -- false
		Movie movie = BookmarkManager.getInstance().createMovie(3000,	"Citizen Kane", "",	1941,	new String[] {"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},	MovieGenre.HORROR,	8.5);
		
		boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();
		
		assertFalse("For horror Genre - isKidFriendlyEligible should return false", isKidFriendlyEligible);
		
		
		//Test 2: thrillers genre -- false
		movie = BookmarkManager.getInstance().createMovie(3000,	"Citizen Kane", "",	1941,	new String[] {"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},	MovieGenre.THRILLERS,	8.5);
		
		isKidFriendlyEligible = movie.isKidFriendlyEligible();
			
		assertFalse("For Thrillers Genre - isKidFriendlyEligible should return false", isKidFriendlyEligible);
		
	}

}
