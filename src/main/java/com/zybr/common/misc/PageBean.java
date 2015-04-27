package com.zybr.common.misc;

/**
 * @author pst
 * @date 2011-7-17
 */
public class PageBean {

	private int page;
	private int rows;
	private Integer index;
	private int total;
    private Integer firstPage;
    private Integer previousPage;
    private Integer nextPage;
    private Integer lastPage;
    private Integer[] pages;

	public PageBean() {
		super();
	}

	public PageBean(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}

	public void resetPage() {
		page = 1;
	}
	
	public void nextPage() {
		page++;
	}
	
	public int getPage() {
		if(page <= 0){
			page = 1;
		}
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		if(rows <= 0){
			rows = 20;
		}
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getIndex() {
		if (index != null) {
			return index;
		}
		return ( getPage() - 1 ) * getRows();
	}
	
	public void setIndex(Integer index) {
		this.index = index;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

    public void compute() {
        firstPage = null;
        previousPage = null;
        nextPage = null;
        lastPage = null;
        pages = null;
        if (total < 1) {
            return;
        }
        int rows = getRows();
        lastPage = (total + rows - 1) / rows;
        if (lastPage <= 1) {
            lastPage = null;
            return;
        }
        int page = getPage();
        firstPage = 1;
        previousPage = page - 1;
        nextPage = page + 1;
        if (previousPage < firstPage) {
            previousPage = firstPage;
        }
        if (nextPage > lastPage) {
            nextPage = lastPage;
        }
        int beginPage;
        int endPage;
        if (page - 5 < firstPage) {
            beginPage = firstPage;
        } else {
            beginPage = page - 5;
        }
        if (page + 5 > lastPage) {
            endPage = lastPage;
        } else  {
            endPage = page + 5;
        }
        int size = endPage - beginPage + 1;
        pages = new Integer[size];
        for (int i = 0; i < size; i++) {
            pages[i] = beginPage++;
        }
        if (page == firstPage) {
            firstPage = null;
            previousPage = null;
        } else if (page == lastPage) {
            nextPage = null;
            lastPage = null;
        }
    }

    public Integer getFirstPage() {
        return firstPage;
    }

    public Integer getPreviousPage() {
        return previousPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public Integer[] getPages() {
        return pages;
    }

}
