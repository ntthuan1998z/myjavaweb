package com.myjavaweb.sort;

public class Sorter {
	private String sortName;
	private String sortBy;

	public Sorter(String sortName, String sortBy) {
		this.sortName = sortName;
		this.sortBy = sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortName() {
		return sortName;
	}
}
