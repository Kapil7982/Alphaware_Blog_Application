package com.blogApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogApp.models.Comment;
import com.blogApp.models.Post;
import com.blogApp.repositories.CommentRepository;
import com.blogApp.repositories.PostRepository;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;
	
	@Override
	public List<Comment> getCommentsByPostId(Long postId) {
		return commentRepository.findByPostId(postId);
	}

	@Override
	public Comment createComment(Long postId, Comment comment) {
		Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        comment.setPost(post);
        return commentRepository.save(comment);
	}

	@Override
	public Comment updateComment(Long id, Comment comment) {
		Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        existingComment.setContent(comment.getContent());
        return commentRepository.save(existingComment);
	}

	@Override
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
	}

}
