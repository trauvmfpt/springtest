package t1708e.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import t1708e.test.entity.BookDetail;
import t1708e.test.entity.PublisherCatalog;
import t1708e.test.service.BookDetailService;
import t1708e.test.service.PublisherCatalogService;
import t1708e.test.specification.BookDetailSpecification;
import t1708e.test.specification.SearchCriteria;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookDetailController {
    @Autowired
    BookDetailService bookDetailService;
    @Autowired
    PublisherCatalogService publisherCatalogService;

    @RequestMapping(method = RequestMethod.GET, value = "/book/search")
    public String index(){
        return "book/index";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/book/search")
    public String returnList(
            @RequestParam(value = "keyword", required = false) String keyword, Model model) {
        Specification specification = Specification.where(null);
        if (keyword != null && keyword.length() > 0) {
            specification = specification
                    .and(new BookDetailSpecification(new SearchCriteria("name", ":", keyword)))
                    .or(new BookDetailSpecification(new SearchCriteria("id", ":", keyword)))
                    .or(new BookDetailSpecification(new SearchCriteria("author", ":", keyword)))
                    .or(new BookDetailSpecification(new SearchCriteria("genre", ":", keyword)))
                    .or(new BookDetailSpecification(new SearchCriteria("publisherId", ":", keyword)));
        }
        List<BookDetail> bookDetails = bookDetailService.bookDetails(specification);
        model.addAttribute("bookDetails", bookDetails);
        return "book/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/book/create")
    public String create(Model model) {
        model.addAttribute("bookDetail", new BookDetail());
        model.addAttribute("publisherCatalogs", publisherCatalogService.publisherCatalogs());
        return "book/form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String store(Model model, @Valid BookDetail bookDetail, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bookDetail", bookDetail);
            return "hero/form";
        }
        bookDetailService.create(bookDetail);
        return "redirect:/book/search";
    }

}
