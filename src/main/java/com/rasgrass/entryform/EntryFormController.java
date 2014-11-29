package com.rasgrass.entryform;

import com.rasgrass.entry.EntryRepository;
import com.rasgrass.support.web.MessageHelper;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author RasGrass
 */
@Controller
public class EntryFormController {

	private static final String ENTRY_FORM_VIEW_NAME = "entry/form";

	@Autowired
	private EntryRepository entryRepository;

	@RequestMapping(value = "entry")
	public String entry(Model model) {
		model.addAttribute(new EntryForm());
		return ENTRY_FORM_VIEW_NAME;
	}

	@RequestMapping(value = "entry", method = RequestMethod.POST)
	public String entry(@Valid @ModelAttribute EntryForm entryForm, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return ENTRY_FORM_VIEW_NAME;
		}
		entryRepository.save(entryForm.postEntry());

		MessageHelper.addSuccessAttribute(ra, "entry.success");
		return "redirect:/";
	}
}
