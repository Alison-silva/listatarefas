package com.sistema.listatarefas.model.enuns;

public enum Priority {

	ALTA("Alta"), NORMAL("Normal");

	private final String displayValue;

	private Priority(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

}
