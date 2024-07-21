package dao;

import data.DataStore;
import entities.Bookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}
}
