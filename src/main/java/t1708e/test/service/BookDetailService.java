package t1708e.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import t1708e.test.entity.BookDetail;
import t1708e.test.repository.BookDetailRepository;
import t1708e.test.specification.BookDetailSpecification;

import java.util.List;

@Service
public class BookDetailService {
    @Autowired
    BookDetailRepository bookDetailRepository;

    public List<BookDetail> bookDetails(Specification specification) {
        return bookDetailRepository.findAll(specification);
    }

    public BookDetail create(BookDetail bookDetail) {
        return bookDetailRepository.save(bookDetail);
    }

    public BookDetail update(BookDetail bookDetail) {
        return bookDetailRepository.save(bookDetail);
    }

    public boolean delete(BookDetail bookDetail) {
        bookDetailRepository.delete(bookDetail);
        return true;
    }
}
