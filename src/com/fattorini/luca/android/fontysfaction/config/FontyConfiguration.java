package com.fattorini.luca.android.fontysfaction.config;

/**
 * 
 * @author luca-fattorini
 * 
 */
public class FontyConfiguration {
	private String path;
	private String extension;
	private FontySourceTypo sourceTypo;
	private Class<?> fontEntityClazz;

	public FontyConfiguration(FontyConfigurationBuilder builder) {
		this.path = builder.path;
		this.extension = builder.extension;
		this.setSourceTypo(builder.sourceTypo);
		this.setFontEntityClazz(builder.fontEntityClazz);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public FontySourceTypo getSourceTypo() {
		return sourceTypo;
	}

	public void setSourceTypo(FontySourceTypo sourceTypo) {
		this.sourceTypo = sourceTypo;
	}

	public Class<?> getFontEntityClazz() {
		return fontEntityClazz;
	}

	public void setFontEntityClazz(Class<?> fontEntityClazz) {
		this.fontEntityClazz = fontEntityClazz;
	}

}
