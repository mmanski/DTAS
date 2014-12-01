package com.rasgrass.entry;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author RasGrass
 */
@SuppressWarnings("serial")
@Entity
@Data
@Document(collection = "entries")
public class Entry implements Serializable {

	@Id
	private ObjectId ID = new ObjectId();

	private String PARENT_ID;

	private String title;

	private String entryText;

	private int entryVotes;

	//@OneToOne(targetEntity = Account.class)
	private String author;

	private String embeddedItem;

	public Entry() {
	}

	public Entry(final String parent, final String text, final String embedded, final String author) {
		this.author = author;
		this.embeddedItem = embedded;
		this.entryText = text;
		this.PARENT_ID = parent;
	}

	public Entry(final String text, final String title,final String author) {
		this.title = title;
		this.entryText = text;
		this.PARENT_ID = null;
		this.author = author;
	}

}
