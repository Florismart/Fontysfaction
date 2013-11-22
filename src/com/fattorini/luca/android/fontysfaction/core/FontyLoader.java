package com.fattorini.luca.android.fontysfaction.core;

import java.lang.ref.SoftReference;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import com.fattorini.luca.android.fontysfaction.config.FontyConfiguration;
import com.fattorini.luca.android.fontysfaction.config.FontySourceTypo;
import com.fattorini.luca.android.fontysfaction.config.FontyTypo;
import com.fattorini.luca.android.fontysfaction.config.loader.AssetsLoader;

/**
 * 
 * @author luca-fattorini
 * 
 */
public class FontyLoader {
	private static final String TAG = FontyLoader.class.getName();
	private static final FontyCache fontCache = new FontyCache();

	private FontyConfiguration configuration;
	private static FontyLoader instance = null;

	public static FontyLoader getInstance() {
		if (instance == null) {
			synchronized (FontyLoader.class) {
				if (instance == null) {
					instance = new FontyLoader();
				}
			}
		}
		return instance;
	}

	public FontyLoader init(FontyConfiguration configuration) {
		this.configuration = configuration;
		return this;
	}

	public Typeface getFont(final Context context, final FontyTypo font) {
		synchronized (fontCache) {
			if (fontCache.get(font) != null) {
				SoftReference<Typeface> reference = fontCache.get(font);
				if (reference.get() != null) {
					Log.d(TAG, font + " cached, get it!");
					return reference.get();
				}
			}

			Typeface typeface;
			if (configuration.getSourceTypo().equals(FontySourceTypo.assets))
				typeface = AssetsLoader.get(context, configuration, font);
			else
				typeface = Typeface.DEFAULT;

			Log.d(TAG, font + " not cached, cache it!");
			fontCache.put(font, new SoftReference<Typeface>(typeface));
			return typeface;
		}
	}

}
