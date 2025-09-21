
package io.techexchange.backend.api;

import io.techexchange.backend.model.Question;
import io.techexchange.backend.repo.QuestionRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {

    private final QuestionRepository repo;
    public QuestionController(QuestionRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Question> list() {
        List<Question> all = repo.findAll();
        if (all.isEmpty()) {
            // seed a few questions if DB is empty
            List<Question> seed = new ArrayList<>();
            seed.add(new Question("How to scale Spring Boot?","Use stateless services, externalize session, gateway, autoscaling."));
            seed.add(new Question("Why MongoDB for Q&A?","Flexible schema, fast reads, easy to shard."));
            repo.saveAll(seed);
            return seed;
        }
        return all;
    }

    @PostMapping
    public Question create(@RequestBody Question q) {
        return repo.save(q);
    }
}
