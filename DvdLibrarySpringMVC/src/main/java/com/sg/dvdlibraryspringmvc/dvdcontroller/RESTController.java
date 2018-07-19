package com.sg.dvdlibraryspringmvc.dvdcontroller;
/**
 *
 * @author JCLog
 */
import com.sg.dvdlibraryspringmvc.dao.DvdListDao;
import com.sg.dvdlibraryspringmvc.model.dvd.Dvd;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author JCLog
 */
@CrossOrigin
@Controller
public class RESTController {

    private DvdListDao dao;

    @Inject
    public RESTController(DvdListDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/dvd/{title}", method = RequestMethod.GET)
    @ResponseBody
    public Dvd getDvd(@PathVariable("title") String dvdTitle) {
        return dao.getDvdByTitle(dvdTitle);
    }

    @RequestMapping(value = "/dvd", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Dvd createDvd(@Valid @RequestBody Dvd dvd) {
        return dao.addDvd(dvd);
    }

    @RequestMapping(value = "/dvd/{title}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDvd(@PathVariable("title") String dvdTitle) {
        dao.removeDvd(dvdTitle);
    }

    @RequestMapping(value = "/dvd/{title}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateContact(@PathVariable("title") String dvdTitle,
            @Valid @RequestBody Dvd dvd) throws UpdateIntegrityException {

        if (dvdTitle == null ? dvd.getDvdTitle() != null : !dvdTitle.equals(dvd.getDvdTitle())) {
            throw new UpdateIntegrityException("Dvd title on URL must match Dvd title in submitted data.");
        }
        dao.updateDvd(dvd);
    }

    @RequestMapping(value = "/dvds", method = RequestMethod.GET)
    @ResponseBody
    public List<Dvd> getAllDvds() {
        return dao.getAllDvds();
    }
}

