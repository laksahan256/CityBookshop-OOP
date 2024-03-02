
package com.mycompany.ClassPackage;

import java.io.*;

public class BookClass {
    
    FileSystem fs = new FileSystem("BookDetails.txt");
    private String BookId;
    private String BookName;
    private String Category;
    private String AuthorName;
    private String Price;
    private int BookCount;
       
    
    public BookClass(){}

    public BookClass(String BookId, String BookName,String Category, String AuthorName, String Price) {
        this.BookId = BookId;
        this.BookName = BookName;
        this.Category = Category;
        this.AuthorName = AuthorName;
        this.Price = Price;
        
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String BookId) {
        this.BookId = BookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String AuthorName) {
        this.AuthorName = AuthorName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public int getBookCount() {
        return BookCount;
    }

    public void setBookCount(int BookCount) {
        this.BookCount = BookCount;
    }
     
          
     public boolean addBooks() {
        
        if(!fs.createANewFile())
        {
            String record = BookId + " " + BookName + " " + Category + " " + AuthorName+" " + Price;
            System.err.println(BookId + " " + BookName + " " + Category + " " + AuthorName+" " + Price);
            return fs.writeDataToFile(record);
        }
       return false;
    }
    
       public String viewAllBooks () 
      {
        String books, allBooks = "";
        String[] words = null;
        int count = 0;

        BufferedReader bk = fs.readAFile();

        try {
            while ((books = bk.readLine()) != null)
            {     
                words = books.split(" ");
                allBooks = allBooks + words[0] + " \t" + words[1] + " \t" + words[2] + " \t \t" + words[3] 
                        + " \t" + "\n";             
                                           
                count++; 
                
            }
        } catch (Exception e)
        {
            System.err.println("Error Searching Emp"+e); 
        }

        setBookCount(count);
        return allBooks;
    }
     
       public boolean searchBooks (String BookId) 
      {
        boolean isFound = false;
         
        try {
            String[] words = null;
            
            BufferedReader bk = fs.readAFile();
            String books;          
            outerloop:
            while ((books = bk.readLine()) != null) {            
                words = books.split(" "); 
                
                for (String word : words) {
                    if (word.equals(BookId)) 
                    {
                        isFound = true;                       
                        this.setBookId(words[0]);
                        this.setBookName(words[1]);
                        this.setCategory(words[2]);
                        this.setAuthorName(words[3]);
                        this.setPrice(words[4]);
                        
                        break outerloop;
                    }
                }
            }
        } catch (Exception e) {
        }
        
        return isFound;
    }
}
