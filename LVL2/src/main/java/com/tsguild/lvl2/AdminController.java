
package com.tsguild.lvl2;

import com.tsguild.lvl2.dao.BlogPostDao;
import com.tsguild.lvl2.dao.StaticPageDao;
import com.tsguild.lvl2.dto.BlogPost;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class AdminController {

    private final StaticPageDao staticDao;
    private final BlogPostDao blogDao;

    @Inject
    public AdminController(StaticPageDao staticDao, BlogPostDao blogDao) {
        this.staticDao = staticDao;
        this.blogDao = blogDao;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {

        return "admin";
    }

    @ResponseBody
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<BlogPost> getAllBlogPosts() {
        return blogDao.getAllBlogPosts();
    }

    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/blog", method = RequestMethod.POST)
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost, HttpServletRequest request) {
        /*
        1 Admin Post
        2 User Post Pending
        3 User Post Approved
        4 User Post Declined
        5 Admin Comment
        6 Reader comment Pending
        7 Reader Comment Approved
        8 Reader Comment Declined
        9 Draft
        10 Pending Deletion
        11 Deleted
         */

        int s = blogPost.getStatus();

        // admin only status
        if (s == -1 || s == 1 || s == 2 || s == 3 || s == 4 || s == 9 || s == 10 || s == 11) {
            if (s == -1 || s == 2) { //if its an unsorted or user post
                if (request.isUserInRole("ROLE_EMPLOYEE")) {
                    blogPost.setStatus(2);
                } else if (request.isUserInRole("ROLE_ADMIN")) {
                    blogPost.setStatus(1);
                }
            } else if (s == 9) { //if its a draft make sure they're authenticated
                if (!(request.isUserInRole("ROLE_EMPLOYEE") || request.isUserInRole("ROLE_ADMIN"))) {
                    return new BlogPost();
                }
            } else if (!request.isUserInRole("ROLE_ADMIN")) {
                return new BlogPost();
            }
        } else {
            return new BlogPost();
        }

        blogPost.setAuthor(request.getUserPrincipal().getName());
        return blogDao.addBlogPost(blogPost);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public void editBlogPost(@RequestBody BlogPost editedPost, HttpServletRequest request) {
        if (request.isUserInRole("ROLE_EMPLOYEE")) {
            editedPost.setStatus(2);
        } else if (request.isUserInRole("ROLE_ADMIN")) {
            editedPost.setStatus(1);
        }
        blogDao.updateBlogPost(editedPost);
    }

    // this isnt the real edit page just using it for testing
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBlogPost(ModelMap model, @PathVariable int id) {
        BlogPost postToEdit = blogDao.getBlogPostById(id);

        model.addAttribute("title", postToEdit.getTitle());
        model.addAttribute("author", postToEdit.getAuthor());
        model.addAttribute("datePosted", postToEdit.getDatePosted());
        model.addAttribute("content", postToEdit.getContent());
        model.addAttribute("status", postToEdit.getStatus());
        model.addAttribute("id", postToEdit.getId());

        return "edit";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
    public void deleteBlogPost(@PathVariable int id, HttpServletRequest request) {
        BlogPost post = blogDao.getBlogPostById(id);
        if (request.isUserInRole("ROLE_EMPLOYEE")) {
            post.setStatus(10);
            blogDao.updateBlogPost(post);
        } else if (request.isUserInRole("ROLE_ADMIN")) {
            blogDao.removeBlogPost(id);
        }
    }
}
