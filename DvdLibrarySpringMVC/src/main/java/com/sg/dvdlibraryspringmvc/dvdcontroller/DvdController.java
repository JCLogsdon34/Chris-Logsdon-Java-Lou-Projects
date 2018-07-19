package com.sg.dvdlibraryspringmvc.dvdcontroller;

import com.sg.dvdlibraryspringmvc.dao.DvdListDao;
import com.sg.dvdlibraryspringmvc.model.dvd.Dvd;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author JCLog
 */
@Controller
public class DvdController {

    DvdListDao dao;

    @Inject
    public DvdController(DvdListDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/displayDvdsPage", method = RequestMethod.GET)
    public String displayDvdsPage(Model model) {
        // Get all the Contacts from the DAO
        List<Dvd> dvdList = dao.getAllDvds();

        // Put the List of Contacts on the Model
        model.addAttribute("dvdList", dvdList);

        // Return the logical name of our View component
        return "dvds";
    }

    @RequestMapping(value = "/createDvd", method = RequestMethod.POST)
    public String createDvd(HttpServletRequest request) {
  
        Dvd dvd = new Dvd();
        dvd.setDvdTitle(request.getParameter("dvdTitle"));
        dvd.setReleaseDate(request.getParameter("releaseDate"));
        dvd.setDirectorsName(request.getParameter("directorsName"));
        dvd.setRating(request.getParameter("rating"));

        // persist the new Contact
        dao.addDvd(dvd);

        // we don't want to forward to a View component - we want to
        // redirect to the endpoint that displays the Contacts Page
        // so it can display the new Contact in the table.
        return "redirect:displayDvdsPage";
    }

    @RequestMapping(value = "/displayDvdDetails", method = RequestMethod.GET)
    public String displayDvdDetails(HttpServletRequest request, Model model) {
        String dvdTitleParameter = request.getParameter("dvdTitle");
       // int contactId = Integer.parseInt(contactIdParameter);

        Dvd dvd = dao.getDvdByTitle(dvdTitleParameter);

        model.addAttribute("dvd", dvd);

        return "dvdDetails";
    }

    @RequestMapping(value = "/deleteDvd", method = RequestMethod.GET)
    public String deleteDvd(HttpServletRequest request) {
        String dvdTitleParameter = request.getParameter("dvdTitle");
      //  Stri = Long.parseLong(dvdTitleParameter);
        dao.removeDvd(dvdTitleParameter);
        return "redirect:displayDvdsPage";
    }

    @RequestMapping(value = "/displayEditDvdForm", method = RequestMethod.GET)
    public String displayEditDvdForm(HttpServletRequest request, Model model) {
        String dvdTitleParameter = request.getParameter("dvdTitle");
 //       long contactId = Long.parseLong(contactIdParameter);
        Dvd dvd = dao.getDvdByTitle(dvdTitleParameter);
        model.addAttribute("dvd", dvd);
        return "editDvdForm";
    }

    @RequestMapping(value = "/editDvd", method = RequestMethod.POST)
    public String editDvd(@Valid @ModelAttribute("dvd") Dvd dvd, BindingResult result) {

        if (result.hasErrors()) {
            return "editDvdForm";
        }

        dao.updateDvd(dvd);

        return "redirect:displayDvdsPage";
    }
}

