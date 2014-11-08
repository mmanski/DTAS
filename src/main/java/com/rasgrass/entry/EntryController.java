/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasgrass.entry;

import com.rasgrass.account.Account;
import com.rasgrass.account.AccountRepository;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author RasGrass
 */
@Controller
public class EntryController {

    private EntryRepository entryRepository;

    @Autowired
    public EntryController(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @RequestMapping(value = "entry/current", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Entry entry(Principal principal) {
        Assert.notNull(principal);
        return null;
    }
}
