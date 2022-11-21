package com.example.myapplication;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Book implements Serializable{
    private String title;
    private UUID id;
    private List<String> authors;
    private List<String> translators;
    private Map<String,String> WebIds;
    private String publisher;
    private Date pubtime;
    private Calendar addTime;
    private String isbn;
    private boolean hasCover;
    public Book(){
        id = UUID.randomUUID();
    }
    public Book(UUID uuid){
        id = uuid;
    }
    public String getCoverPhotoFileName(){
        return "Cover_"+id.toString()+".jpg";
    }
    public Calendar getAddTime() {
        return addTime;
    }
    public void setAddTime(Calendar addTime) {
        this.addTime = addTime;
    }
    public Map<String, String> getWebIds() {
        return WebIds;
    }
    public void setWebIds(Map<String, String> webIds) {
        WebIds = webIds;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public Date getPubtime() {
        return pubtime;
    }
    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<String> getAuthors() {
        return authors;
    }
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    public List<String> getTranslators() {
        return translators;
    }
    public void setTranslators(List<String> translators) {
        this.translators = translators;
    }
    public boolean isHasCover() {
        return hasCover;
    }
    public void setHasCover(boolean hasCover) {
        this.hasCover = hasCover;
    }
}
