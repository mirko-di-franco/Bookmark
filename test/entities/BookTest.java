package entities;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import constants.BookGenre;
import managers.BookmarkManager;

public class BookTest {

	@Test
	public void test() {
		//Test 1: Philosophy genre -- false
		Book book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[] {"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
		
		boolean isKidFriendlyEligible = book.isKidFriendlyEligible();
		
		assertFalse("For Philosophy Genre - isKidFriendlyEligible should return false", isKidFriendlyEligible);
		
		
		//Test 2: Self help genre -- false
		book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[] {"Henry David Thoreau"}, BookGenre.SELF_HELP, 4.3);
		
		isKidFriendlyEligible = book.isKidFriendlyEligible();
		
		assertFalse("For Self help Genre - isKidFriendlyEligible should return false", isKidFriendlyEligible);
	}

}
