import com.hu.dao.BookDao;
import com.hu.dao.impl.BookDaoImpl;
import com.hu.entiry.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author suhu
 * @createDate 2021/11/21
 */
public class GetBookTest {
    private final BookDao bookDao = new BookDaoImpl();

    @Test
    public void test() {
        List<Book> bookList = bookDao.getBookList(1, 1, null);
        bookList.forEach(System.out::println);
    }
}
