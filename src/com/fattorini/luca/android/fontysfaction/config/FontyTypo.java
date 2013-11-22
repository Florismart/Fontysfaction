package com.fattorini.luca.android.fontysfaction.config;

/**
 * 
 * @author luca-fattorini
 * 
 */
public enum FontyTypo {
	regular, bold, light, regular_italic, bold_italic, light_italic;

	public static FontyTypo fromIndex(final int index) {
		if (index >= FontyTypo.values().length - 1 || index < 0)
			return regular;
		else
			return FontyTypo.values()[index];
	}
}
