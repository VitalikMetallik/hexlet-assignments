package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        return posts.stream().map(this::toPostDTO).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO show(@PathVariable long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id "  + id + " not found"));
        return toPostDTO(post);
    }

    private PostDTO toPostDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        dto.setComments(commentRepository.findByPostId(post.getId())
                .stream()
                .map(this::toCommentDTO)
                .toList());
        return dto;
    }

    private CommentDTO toCommentDTO(Comment comment) {
        var dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setBody(comment.getBody());
        return dto;
    }
}
// END