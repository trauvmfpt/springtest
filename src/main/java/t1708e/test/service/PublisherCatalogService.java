package t1708e.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import t1708e.test.entity.BookDetail;
import t1708e.test.entity.PublisherCatalog;
import t1708e.test.repository.PublisherCatalogRepository;

import java.util.List;

@Service
public class PublisherCatalogService {
    @Autowired
    PublisherCatalogRepository publisherCatalogRepository;

    public List<PublisherCatalog> publisherCatalogs() {
        return publisherCatalogRepository.findAll();
    }

    public PublisherCatalog create(PublisherCatalog publisherCatalog) {
        return publisherCatalogRepository.save(publisherCatalog);
    }

    public PublisherCatalog update(PublisherCatalog publisherCatalog) {
        return publisherCatalogRepository.save(publisherCatalog);
    }

    public boolean delete(PublisherCatalog publisherCatalog) {
        publisherCatalogRepository.delete(publisherCatalog);
        return true;
    }
}
