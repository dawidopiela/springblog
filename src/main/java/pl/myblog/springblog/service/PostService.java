package pl.myblog.springblog.service;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.myblog.springblog.model.Post;
import pl.myblog.springblog.repository.PostRepository;
import pl.myblog.springblog.repository.UserRepository;

import java.util.List;

@Service
public class PostService {
    PostRepository postRepository;
    UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    //metoda zwracajaca wszystkie posty

    public List<Post> getallPosts() {
        return postRepository.findAll();
    }

    //metoda zwracajac post po id
    public Post getPostByid(Long id) {
        return postRepository.getOne(id);
    }

    //metoda usuwajaca posta po id
    public void deletepostById(Long id) {
        postRepository.deleteById(id);

    }

    //metoda aktualizujaca post w bazie danych
    public Post updatePost(Long id, Post post) {
        Post updatePost = postRepository.getOne(id);
        updatePost.setTitle(post.getTitle());
        updatePost.setContent(post.getContent());
        return postRepository.save(updatePost);

    }

}
