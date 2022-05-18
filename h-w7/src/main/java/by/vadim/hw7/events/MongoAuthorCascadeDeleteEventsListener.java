package by.vadim.hw7.events;

import by.vadim.hw7.models.Author;
import by.vadim.hw7.repositories.book.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MongoAuthorCascadeDeleteEventsListener extends AbstractMongoEventListener<Author> {
    private final BookRepository bookRepository;

    @Override
    public void onAfterDelete(AfterDeleteEvent<Author> event) {
        super.onAfterDelete(event);
        val source = event.getSource();
        val id = source.get("_id").toString();
        bookRepository.removeExperienceArrayElementsById(id);
    }
}
