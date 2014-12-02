package com.rasgrass.entry;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author RasGrass
 */
@Controller
public final class EntryController {

	private final EntryRepository entryRepository;

	private final List<Entry> entries;

	@Autowired(required = true)
	public EntryController(EntryRepository entryRepository) {
		this.entryRepository = entryRepository;
		entries = getEntries();
	}

	@RequestMapping(value = "entry/all", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<Entry> entry(Principal principal) {
		Assert.notNull(principal);
		return (List<Entry>) entryRepository.findAll();
	}

	@RequestMapping(value = "entry/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Entry getEntry(@PathVariable("id") int id) {
		List<Entry> t = getEntries();
		return t.get(id);
	}

	@RequestMapping(value = "entry/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void deleteEntry(@PathVariable("id") int id) {
		entryRepository.delete(getEntries().get(id));
	}

	@RequestMapping(value = "entry/{id}", method = RequestMethod.PATCH)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void patchEntry(@PathVariable("id") int id) {

	}

	@RequestMapping(value = "entry/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void putEntry(@PathVariable("id") int id) {

	}

	@RequestMapping(value = "entry/new", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void postEntry(@PathVariable("id") int id) {

	}

	public List<Entry> getEntries() {
		return (List<Entry>) entryRepository.findAll();
	}
}
