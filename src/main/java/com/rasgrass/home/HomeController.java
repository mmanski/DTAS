package com.rasgrass.home;

import com.rasgrass.entry.Entry;
import com.rasgrass.entry.EntryRepository;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private EntryRepository entryRepository;

	@ModelAttribute("entries")
	public List<Entry> getEntries() {
		return (List<Entry>) entryRepository.findAll();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal) {
		return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
	}
}
