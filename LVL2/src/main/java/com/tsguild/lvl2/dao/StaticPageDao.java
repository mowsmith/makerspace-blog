
package com.tsguild.lvl2.dao;

import com.tsguild.lvl2.dto.StaticPage;
import java.util.List;

public interface StaticPageDao {

    public StaticPage addStaticPage(StaticPage staticPage);

    public StaticPage getStaticPageById(int id);

    public List<StaticPage> getAllStaticPages();

    public void updateStaticPage(StaticPage updatedPage);

    public void removeStaticPage(int id);

}
