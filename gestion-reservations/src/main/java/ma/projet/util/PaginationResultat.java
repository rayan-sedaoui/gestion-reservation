package ma.projet.util;

import java.util.List;

public class PaginationResultat<T> {
    
    private List<T> elements;
    private int pageCourante;
    private int totalPages;
    private long totalElements;

    public PaginationResultat() {}

    public PaginationResultat(List<T> elements, int pageCourante, int totalPages, long totalElements) {
        this.elements = elements;
        this.pageCourante = pageCourante;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public List<T> getElements() { return elements; }
    public void setElements(List<T> elements) { this.elements = elements; }
    public int getPageCourante() { return pageCourante; }
    public void setPageCourante(int pageCourante) { this.pageCourante = pageCourante; }
    public int getTotalPages() { return totalPages; }
    public void setTotalPages(int totalPages) { this.totalPages = totalPages; }
    public long getTotalElements() { return totalElements; }
    public void setTotalElements(long totalElements) { this.totalElements = totalElements; }
}