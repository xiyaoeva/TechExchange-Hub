
package io.techexchange.backend.repo;

import io.techexchange.backend.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String> {}
