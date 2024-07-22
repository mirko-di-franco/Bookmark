package data;

import constants.KidFriendlyStatus;
import constants.UserType;
import controllers.BookmarkController;
import entities.Bookmark;
import entities.User;

public class View {
	
	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n"+ user.getEmail() + "is browsing items...");
		int bookmarkCount = 0;
		
		for(Bookmark[] bookmarkList : bookmarks) {
			for(Bookmark bookmark : bookmarkList) {
				//Bookmarking
				if(bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarkded = getBookmarkDecision(bookmark);
					if(isBookmarkded) {
						bookmarkCount++;
						
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						
						System.out.println("New Item Bookmarked -- "+bookmark);
					}
				}
				
				//Mark as kid-friendly
				if(user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
						if(bookmark.isKidFriendlyEligible() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
							String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
							if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
								bookmark.setKidFriendlyStatus(kidFriendlyStatus);
								System.out.println("Kid-friendly status: "+ kidFriendlyStatus + ", "+ bookmark);
							}
						}
				}
				
			}
		}
		
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		double randomVal = Math.random();
		
		return randomVal < 0.4 ? KidFriendlyStatus.APPROVED : 
			(randomVal >= 0.4 && randomVal < 0.8) ? KidFriendlyStatus.REJECTED 
					: KidFriendlyStatus.UNKNOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;
	}
	
	
	/*public static void bookmark(User user, Bookmark[][] bookmarks) {
		System.out.println("\n"+ user.getEmail() + "is bookmarking");
		for(int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
			int typeOffset =(int)(Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
			int bookmarkOffset =(int)(Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
			
			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
			
			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
			
			System.out.println(bookmark);
		}
	}*/
}
