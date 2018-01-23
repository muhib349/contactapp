package com.contactapp.controller;

import com.contactapp.domain.Contact;
import com.contactapp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by gazi_muhib on 8/26/17.
 */

@Controller
public class ContactsController {

    @Autowired
    private ContactService contactService;

    @RequestMapping("/contact_form")
    public String contractForm(Model m){

        m.addAttribute("command",new Contact());
        return "contact_form";
    }

    @RequestMapping("/save_contact")
    public String saveContact(@ModelAttribute("command") Contact contact, Model m, HttpSession session){

        Integer userId=(Integer) session.getAttribute("userId");
        contact.setUser_id(userId);
        contactService.save(contact);
        return "redirect:contact_list?act=saved";
    }

    @RequestMapping("/contact_list")
    public String contactList(Model model,HttpSession session){
        Integer userid=(Integer)session.getAttribute("userId");
        model.addAttribute("contactList",contactService.findUserContacts(userid));
        return "c_list";
    }

    @RequestMapping("/delete_contact")
    public String deleteContact(@RequestParam("contactId") Integer contactId){
        contactService.delete(contactId);
        return "redirect:contact_list?act=del";
    }

    @RequestMapping("/update_contact")
    public String updateContact(@RequestParam("contact") Contact contact,Model model){
        model.addAttribute("contact",contact);

        return "";
    }
}
