package com.springcloud.common;

/**
 * 分页工具
 * 
 * @author 王郁文
 *
 */
public class PageUtils {

	/**
	 * 设置每页显示的数据行数为10条
	 */
	public static final Integer PAGE_ROW_COUNT = 10;

	/**
	 * 当前页
	 */
	private Integer pageNumber;

	/**
	 * 
	 */
	private Integer startRow;

	/**
	 * 最后一页
	 */
	private Integer lastPage;

	/**
	 * 分页按钮数组
	 */
	private int[] pageButton;

	/**
	 * 每页显示数据的行数
	 */
	private Integer pageRowCount;

	/**
	 * 分页工具的有参构造方法
	 * 
	 * @param rowCount 将形参rowCout指向类变量PAGE_ROW_COUNT
	 */
	public PageUtils(Integer rowCount) {
		this(PAGE_ROW_COUNT, rowCount);
	}

	// 构造方法重载，根据参数来决定调用哪个方法
	public PageUtils(Integer pageRowCount, Integer rowCount) {
		this.pageRowCount = pageRowCount;
		// �������һҳ��ҳ��
		this.lastPage = (rowCount + pageRowCount - 1) / pageRowCount;
	}

	public void setPageNumber(Integer pageNumber) {
		if (pageNumber > this.lastPage) {
			this.pageNumber = this.lastPage;
			return;
		}
		this.pageNumber = pageNumber;
	}

	public Integer getPageRowCount() {
		return pageRowCount;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public Integer getStartRow() {
		this.startRow = pageNumber * pageRowCount - pageRowCount;
		return startRow;
	}

	public Integer getLastPage() {
		return lastPage;
	}

	public int[] getPageButton() {
		// ��ҳ��ť����ʼ��ť
		int startPage;
		// ��ҳ��ť�Ľ�����ť
		int endPage;

		if (this.lastPage <= 4) {
			// ������һҳС��4
			startPage = 1;
			endPage = this.lastPage;
		} else {
			if (this.pageNumber < 4) {
				// �����ǰҳ��С��4
				startPage = 1;
				endPage = 4;
			} else {
				startPage = this.pageNumber - 1;
				endPage = this.pageNumber + 2 <= this.lastPage ? this.pageNumber + 2 : this.lastPage;
				if ((endPage - startPage) <= 2) {
					startPage = endPage - 3;
				}
			}
		}
		this.pageButton = new int[endPage - (startPage - 1)];
		for (int i = 0; i < pageButton.length; i++) {
			pageButton[i] = startPage++;
		}
		return this.pageButton;
	}

}
