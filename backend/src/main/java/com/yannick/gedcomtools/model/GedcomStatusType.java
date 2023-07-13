package com.yannick.gedcomtools.model;

public enum GedcomStatusType {
	/**
	 * Created
	 */
	created("created"),

	/**
	 * In progress
	 */
	in_progress("in_progress"),

	/**
	 * Pending
	 */
	pending("pending"),

	/**
	 * Ended
	 */
	ended("ended"),

	/**
	 * Canceled
	 */
	canceled("canceled");

	private String value;

	private GedcomStatusType(String value) {
		this.value = value;
	}

	public String getGedcomStatusType() {
		return this.value;
	}
}
