package com.project.biblinarium.mvvm.repositories;

import android.util.Log;

import com.project.biblinarium.mvvm.models.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BooksRepository {

    private final HashMap<String, Book> allBooks = new HashMap<>();
    private int lastUSedId = 5;

    public BooksRepository () {
        String[] text = {
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ut arcu quis nisl pretium ullamcorper. Vivamus vitae arcu at lacus euismod faucibus. Nunc a arcu nec ex semper lobortis in laoreet tellus. Curabitur id neque eu lectus pretium auctor id efficitur eros. Cras mattis id felis eu luctus. Sed dictum tristique gravida. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Curabitur in sapien nunc. Etiam a dolor in diam euismod sollicitudin sed eu ante. Quisque eget cursus odio. Proin varius ac velit at fermentum.",
                "Aliquam a dui odio. In fringilla condimentum erat, non tincidunt ex congue sed. Aenean a laoreet magna. Cras accumsan augue nec mauris auctor lobortis. Phasellus cursus, est eget aliquam tincidunt, lorem felis fringilla augue, quis gravida eros magna quis urna. Suspendisse nec lobortis arcu, ac viverra ipsum. Maecenas ac varius urna. Praesent at pellentesque tellus. Ut eu ligula sodales, auctor justo vitae, vehicula quam. Pellentesque sed faucibus eros, vitae placerat libero. Nulla non risus sed purus sollicitudin dictum sit amet eu turpis. Cras maximus, erat in eleifend ornare, mi enim ornare quam, sit amet fringilla risus lectus sed turpis.",
                "Aenean consequat sollicitudin blandit. Suspendisse pulvinar commodo turpis, ut tincidunt neque molestie eu. Maecenas dictum dolor elit, a molestie enim imperdiet ut. Phasellus non sem nisl. Pellentesque scelerisque consectetur finibus. Aliquam commodo arcu vel tincidunt cursus. Suspendisse egestas metus et porta molestie. Duis molestie turpis eget tortor porttitor, et eleifend quam elementum. Nunc sit amet maximus libero, quis bibendum enim.",
                "Maecenas efficitur tristique dapibus. Ut cursus elit sit amet eros feugiat luctus. Maecenas ut venenatis est, a placerat dui. Ut ullamcorper mi eget dolor semper, varius hendrerit tortor eleifend. Pellentesque iaculis elit vitae vulputate vulputate. Quisque quis porttitor nibh. Etiam sed lectus maximus, tristique ex vel, suscipit mauris. Ut vitae nisl nec tortor tincidunt sodales.",
                "Nunc vitae molestie lacus, non ultrices lorem. In congue ultrices tellus ut elementum. Aenean accumsan, felis vel suscipit viverra, nisi lectus sagittis nisi, nec consequat metus ante lobortis diam. Nulla mattis tellus quis varius porta. Aenean egestas aliquam magna sit amet lacinia. Nullam congue, eros et hendrerit placerat, turpis ligula vehicula mi, euismod viverra quam libero in elit. Fusce dictum libero ligula, a eleifend sem feugiat id. Curabitur mattis in mauris nec lobortis."
        };

        allBooks.put("Book1", new Book(1, "Book1", "Author1", "Description1",
                111, text[0]));
        allBooks.put("Book2", new Book(2, "Book2", "Author2", "Description2",
                222, text[1]));
        allBooks.put("Book3", new Book(3, "Book3", "Author3", "Description3",
                333, text[2]));
        allBooks.put("Book4", new Book(4, "Book4", "Author4", "Description4",
                444, text[3]));
        allBooks.put("Book5", new Book(5, "Book5", "Author5", "Description5",
                555, text[4]));
    }

    public HashMap<String, Book> getAllBooks() {
        return allBooks;
    }

    public Book getBook(String bookName) {
        return allBooks.get(bookName);
    }

    public ArrayList<Book> getSomeBooks(String[] books) {
        ArrayList<Book> someBooks = new ArrayList<>();
        for (String book : books) {
            someBooks.add(allBooks.get(book));
        }
        return someBooks;
    }
}
