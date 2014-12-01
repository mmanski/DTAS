package com.rasgrass.entryform;

import com.rasgrass.entry.Entry;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author RasGrass
 */
@Data
public class EntryForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

	private final String author;

	@NotBlank(message = EntryForm.NOT_BLANK_MESSAGE)
	private String title;

	@NotBlank(message = EntryForm.NOT_BLANK_MESSAGE)
	private String text;

	public EntryForm() {
		author = SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public Entry postEntry() {
		return new Entry(text, title, author);
	}

}
