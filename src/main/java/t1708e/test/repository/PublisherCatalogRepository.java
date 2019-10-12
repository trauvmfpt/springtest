package t1708e.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t1708e.test.entity.PublisherCatalog;

public interface PublisherCatalogRepository extends JpaRepository<PublisherCatalog, String> {
}
