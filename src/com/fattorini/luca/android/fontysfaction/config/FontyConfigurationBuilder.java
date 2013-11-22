package com.fattorini.luca.android.fontysfaction.config;

/**
 * 
 * @author luca-fattorini
 * 
 */
public class FontyConfigurationBuilder {
	protected String path;
	protected String extension;
	protected FontySourceTypo sourceTypo;
	protected Class<?> fontEntityClazz;

	public static FontyConfigurationBuilder builder() {
		return new FontyConfigurationBuilder("", ".ttf", FontySourceTypo.assets, FontyBaseEntity.class);
	}

	public FontyConfigurationBuilder(String path, String extension, FontySourceTypo sourceTypo, Class<?> clazz) {
		this.path = path;
		this.sourceTypo = sourceTypo;
		this.fontEntityClazz = clazz;
	}

	public FontyConfigurationBuilder sourceTypo(FontySourceTypo sourceTypo) {
		this.sourceTypo = sourceTypo;
		return this;
	}

	public FontyConfigurationBuilder fontEntity(Class<?> clazz) {
		this.fontEntityClazz = clazz;
		return this;
	}

	public FontyConfigurationBuilder path(String path) {
		this.path = path;
		return this;
	}

	public FontyConfigurationBuilder extension(String extension) {
		this.extension = extension;
		return this;
	}

	public FontyConfiguration build() {
		return new FontyConfiguration(this);
	}
}
