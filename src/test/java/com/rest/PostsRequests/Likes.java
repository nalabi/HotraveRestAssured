package com.rest.PostsRequests;

public class Likes {

    private int id;
    private int userId;
    private String predicate;
    private int pageNumber;
    private int PageSize;


    public int getPageNumber(){
        return pageNumber;
    }
    public void setPageNumber(int pageNumber){
        this.pageNumber = pageNumber;
    }


    public int getPageSize() {return PageSize;}
    public void setPageSize(int PageSize){
        this.PageSize = PageSize;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {this.userId = userId;}

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {this.predicate = predicate;}

    public int getId() {return id;}




}




