package com.itbank.crud01.component;

public class Paging {

    int page;
    int pageSize;
    int totalRecords;
    int totalPages;

    public Paging(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }
}
