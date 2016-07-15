package net.tfedu.core.helper;

import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * 分页查询结果集
 * @author WeiCuicui
 *
 */
public class PaginationHelper<T> {

	private static final long serialVersionUID = 1L;
    // 当前页
    private int page;
    // 每页的数量
    private int perPage;

    // 总记录数
    private long totalLines;
    // 总页数
    private int total;
    
    // 结果集
    private List<T> list;

    // 视频总量 （用于查询视频课程）
    private int count;
   
    public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getTotalLines() {
        return totalLines;
    }

    public void setTotalLines(long totalLines) {
        this.totalLines = totalLines;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    /**
     * 将pageIn封装为自定义的pagination
     * @param list
     * @return
     */
    public static <T> PaginationHelper transfer(List<T> list) {
        
    	// 将查询结果封装到pagination
        PageInfo pageInfo = new PageInfo(list);

        PaginationHelper<T> pagination = new PaginationHelper<T>();

        // 设置当前页
        pagination.setPage(pageInfo.getPageNum());

        // 设置每页记录数
        pagination.setPerPage(pageInfo.getPageSize());

        // 设置总页数
        pagination.setTotal(pageInfo.getPages());

        // 设置总记录数目
        pagination.setTotalLines(pageInfo.getTotal());

        // 设置查询结果集
        pagination.setList(list);

        return pagination;

    }
}

    
