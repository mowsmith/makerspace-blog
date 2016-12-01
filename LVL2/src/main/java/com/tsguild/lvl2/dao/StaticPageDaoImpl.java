
package com.tsguild.lvl2.dao;

import com.tsguild.lvl2.dto.StaticPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class StaticPageDaoImpl implements StaticPageDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public StaticPage addStaticPage(StaticPage staticPage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //Get static page by ID
    private static final String SQL_GET_PAGE
            = "SELECT * "
            + "FROM StaticPages WHERE pageId = ?";

    @Override
    public StaticPage getStaticPageById(int id) {
        try {
            int test = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
            return jdbcTemplate.queryForObject(SQL_GET_PAGE, // select stmt
                    new PageMapper(), // what we're turning the RS into!
                    id); // and then subsitituting in any placeholders
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<StaticPage> getAllStaticPages() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateStaticPage(StaticPage updatedPage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeStaticPage(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    private static final class PageMapper implements RowMapper<StaticPage>{

        @Override
        public StaticPage mapRow(ResultSet rs, int rowNum) throws SQLException {
            StaticPage mappedPage = new StaticPage();
            
            mappedPage.setId(Integer.parseInt(rs.getString("pageId")));
            mappedPage.setTitle(rs.getString("pageTitle"));
            mappedPage.setContent(rs.getString("pageContent"));
            mappedPage.setStatus(Integer.parseInt(rs.getString("status")));
            
            return mappedPage;
        }
        
    }

}
