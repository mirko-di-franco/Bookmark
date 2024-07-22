package entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import managers.BookmarkManager;

public class WebLinkTest {

	@Test
	public void testIsKidFriendlyEligible() {
		//Test 1: adult in host -- false
		WebLink webLink = BookmarkManager.getInstance().createWebLink(2000,	"Taming Tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.adult.com");
		
		boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse("For adult in host - isKidFriendlyEligible() must return false", isKidFriendlyEligible);
		
		
		//Test 2: adult in url, but not in host part -- true
		webLink = BookmarkManager.getInstance().createWebLink(2000,	"Taming Tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",	"http://www.ciao.com");
		
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertTrue("For adult in url, but not host part - isKidFriendlyEligible() must return true", isKidFriendlyEligible);
		
		//Test 3: adult in title only -- true
		webLink = BookmarkManager.getInstance().createWebLink(2000,	"Taming adult, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.ciao.com");
		
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertTrue("For adult in title - isKidFriendlyEligible() must return true", isKidFriendlyEligible);
		
		
	}

}
