package net.dyy.utils;

import java.util.List;

/**
 * 封装分页参数
 *
 * @author Mzlalal
 *
 */
public class PageBean<T> {

	// 当前页
	private int currentPage = 1;
	// 每页显示的行数
	private int pageCount = 5;
	// 总记录数
	private int totalCount;
	// 总页数
	private int totalPage;
	// 每页的数据
	private List<T> pageData;

	// 封装所有的查询条件
	private Condition condition;

	public int getTotalPage() {
		// 总页数 = 总记录 / 每页显示行数 (+ 1)
		if (totalCount % pageCount == 0) {
			totalPage = totalCount / pageCount;
		} else {
			totalPage = totalCount / pageCount + 1;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public PageBean<T> repeatPageBean(PageBean<T> pageBean, int totalCount) {

		// 设置分页bean参数之总记录数
		pageBean.setTotalCount(totalCount);

		if (pageBean.getCurrentPage() < 1) {
			pageBean.setCurrentPage(1);
		} else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
			pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		return pageBean;
	}

	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageCount=" + pageCount + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", pageData=" + pageData + ", condition=" + condition + "]";
	}

}
