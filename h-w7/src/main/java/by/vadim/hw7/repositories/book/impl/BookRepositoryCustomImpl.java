package by.vadim.hw7.repositories.book.impl;

import by.vadim.hw7.models.Book;
import by.vadim.hw7.repositories.book.BookRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@RequiredArgsConstructor
public class BookRepositoryCustomImpl implements BookRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public void removeExperienceArrayElementsById(String id) {
        val query = Query.query(Criteria.where("$id").is(new ObjectId()));
        val update = new Update().pull("authors", query);
        mongoTemplate.updateMulti(new Query(), update, Book.class);
    }
}
