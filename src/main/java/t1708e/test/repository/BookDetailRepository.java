package t1708e.test.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import t1708e.test.entity.BookDetail;

import java.util.List;

public interface BookDetailRepository extends JpaRepository<BookDetail, String>, JpaSpecificationExecutor<BookDetail> {
    List<BookDetail> findAll(Specification specification);
}
