package com.rasgrass.entry;

import com.rasgrass.account.Account;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author RasGrass
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "entries")
public class Entry implements Serializable {

    @Id
    @GeneratedValue
    private String ID;

    private String PARENT_ID;

    private String entryText;

    private int entryVotes;

    @OneToOne(targetEntity = Account.class)
    private Account author;
    
    //@OneToOne(targetEntity = Account.class, optional = true)
    private String embeddedItem;

    public Entry() {
    }

    public Entry(final String parent, final String text, final Account author, final String embedded) {
        this.author = author;
        this.embeddedItem = embedded;
        this.entryText = text;
        this.PARENT_ID = parent;
    }

    public Entry(final String text, final Account author, final String embedded) {
        this.author = author;
        this.embeddedItem = embedded;
        this.entryText = text;
        this.PARENT_ID = null;
    }

    public String getID() {
        return ID;
    }

    public String getPARENT_ID() {
        return PARENT_ID;
    }

    public String getEntryText() {
        return entryText;
    }

    public int getEntryVotes() {
        return entryVotes;
    }

    public Account getAuthor() {
        return author;
    }

    public Object getEmbeddedItem() {
        return embeddedItem;
    }

    public void setEntryText(String entryText) {
        this.entryText = entryText;
    }

    public void setEntryVotes(int entryVotes) {
        this.entryVotes = entryVotes;
    }

    public void setEmbeddedItem(String embeddedItem) {
        this.embeddedItem = embeddedItem;
    }

}
