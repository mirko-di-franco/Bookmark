package dao;

import data.DataStore;
import entities.Bookmark;
import entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
