package t1708e.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookDetail {
    private String id;
    private String name;
    private String author;
    private String genre;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisherId")
    private PublisherCatalog publisher;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public PublisherCatalog getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherCatalog publisher) {
        this.publisher = publisher;
    }
}
