package controllers;

import entities.Bookmark;
import entities.User;
import managers.BookmarkManager;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();
	private BookmarkController() {}
	public static BookmarkController getInstance() {
		return instance;
	}
	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
	}
	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		BookmarkManager.getInstance().setkidFriendlyStatus(user, kidFriendlyStatus, bookmark);
	}
	public void share(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().share(user, bookmark);
	}
}
