package managers;

import entities.Book;
import entities.Movie;
import entities.WebLink;

public class BookmarkManager {
	// Static private instance of the class itself, created immediately.
	private static BookmarkManager instance = new BookmarkManager();
	
	// Private constructor to prevent creation of new instances from outside.
	private BookmarkManager() {}
	
	// Static public method to get the one instance of the class.
	public static BookmarkManager getInstance() {
		return instance;
	}
	
	
	public WebLink createWebLink(long id, String title, String url, String host) {
		WebLink weblink = new WebLink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(url);
		weblink.setHost(host);
		
		return weblink;
	}
	
	
	public Book createBook(long id, String title, int publicationYear, String publisher, double amazonRating) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAmazonRating(amazonRating);
		
		return book;
	}
	
	
	
	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast, String[] directors, String genre, double imdbRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);
		
		return movie;
	}
}