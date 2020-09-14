package com.library.servlet;

public enum RouteURL {
	LIST_BOOK("./books"), ADD_BOOK("./add-book"), LIST_BOOK_JSP("/jsp/book/list-book.jsp"),
	UPDATE_BOOK_JSP("/jsp/book/update-book.jsp"), ADD_BOOK_JSP("/jsp/book/add-book.jsp"),

	LIST_USER("./users"), ADD_USER("./add-user"), LIST_USER_JSP("/jsp/user/list-user.jsp"),
	UPDATE_USER_JSP("/jsp/user/update-user.jsp"), ADD_USER_JSP("/jsp/user/add-user.jsp"),

	LIST_LEND("./lends"), LIST_LEND_JSP("/jsp/lending/list-lending.jsp");
	private final String url;

	RouteURL(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return this.url;
	}
}
