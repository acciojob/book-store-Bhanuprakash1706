package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    HashMap<Integer,Book> map=new HashMap<>();
    public BookRepository(){

    }

    public Book save(Book book){
        book.setId(map.size()+1);
        map.put(book.getId(), book);
        return book;
    }

    public Book findBookById(int id){
        return map.get(id);
    }

    public List<Book> findAll(){
        List<Book> list=new ArrayList<>();
        list.addAll(map.values());
        return list;
    }

    public void deleteBookById(int id){
        map.remove(id);
        return;
    }

    public void deleteAll(){
        map.clear();
        return;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> list=new ArrayList<>();
        for(Book book: map.values()){
            if(Objects.equals(author,book.getAuthor())){
                list.add(book);
            }
        }
        return list;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> list=new ArrayList<>();
        for(Book book: map.values()){
            if(Objects.equals(genre,book.getGenre())){
                list.add(book);
            }
        }
        return list;
    }
}
