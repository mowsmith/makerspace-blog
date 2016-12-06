
package com.tsguild.lvl2.dao;

import com.tsguild.lvl2.dto.BlogPost;
import com.tsguild.lvl2.dto.Comment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BlogPostDao {

    public BlogPost addBlogPost(BlogPost blogPost);

    public BlogPost getBlogPostById(int id);

    public List<BlogPost> getAllBlogPosts();
    
    public List<BlogPost> searchBlogPosts(Map<SearchTerm,String> criteria);
    
    public void updateBlogPost(BlogPost updatedPage);

    public void removeBlogPost(int id);

    public List<BlogPost> getBlogPostsByAuthor(String author);
    
    public void approveComment(int commentId);
    
    public void declineComment(int commentId);
            
    public Comment createComment(Comment comment);

    public void deleteComment(int id);
    
    public List<Comment> loadCommentsByBlogId(int id);


}
