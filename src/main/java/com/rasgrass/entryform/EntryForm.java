package com.rasgrass.entryform;

import com.rasgrass.account.Account;
import com.rasgrass.entry.Entry;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author RasGrass
 */
public class EntryForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

	@NotBlank(message = EntryForm.NOT_BLANK_MESSAGE)
	private String title;

	@NotBlank(message = EntryForm.NOT_BLANK_MESSAGE)
	private String text;

	@Autowired
	private Account author;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Entry postEntry() {
		return new Entry(getText(), getAuthor(), title);
	}

	public Account getAuthor() {
		return author;
	}
}
