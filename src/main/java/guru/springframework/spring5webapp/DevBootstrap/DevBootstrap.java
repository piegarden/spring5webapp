package guru.springframework.spring5webapp.DevBootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher booksRUs =  new Publisher("books R us", "345 euhtehu road");
        Book manMonth = new Book("deontuhoetuh", "oeu", booksRUs);
        eric.getBooks().add(manMonth);
        manMonth.getAuthors().add(eric);


        authorRepository.save(eric);
        publisherRepository.save(booksRUs);
        bookRepository.save(manMonth);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher bookBuilders = new Publisher("Book builders", "341 etuet Road)");
        Book moneyBall = new Book("oetunheotuh", "ethunohe", bookBuilders);

        rod.getBooks().add(moneyBall);




        authorRepository.save(rod);
        publisherRepository.save(bookBuilders);
        bookRepository.save(moneyBall);


    }
}
