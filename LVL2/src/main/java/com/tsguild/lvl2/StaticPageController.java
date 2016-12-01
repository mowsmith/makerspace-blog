
package com.tsguild.lvl2;

import com.tsguild.lvl2.dao.StaticPageDao;
import com.tsguild.lvl2.dto.StaticPage;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticPageController {
    
    private final StaticPageDao dao;
    
    @Inject
    public StaticPageController(StaticPageDao dao){
        this.dao = dao;
    }
    
    @RequestMapping(value = "/static/{id}", method = RequestMethod.GET)
    public String displayStaticPage(ModelMap model, @PathVariable("id")int id) {
        StaticPage page = dao.getStaticPageById(id);
        
        model.addAttribute("title", page.getTitle());
        model.addAttribute("content", page.getContent());
        
        return "template/staticPage";
        
    }
}
