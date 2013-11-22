package com.fattorini.luca.android.fontysfaction.config.loader;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.fattorini.luca.android.fontysfaction.annotation.FontyIdentifier;
import com.fattorini.luca.android.fontysfaction.annotation.FontyName;
import com.fattorini.luca.android.fontysfaction.annotation.FontyPath;
import com.fattorini.luca.android.fontysfaction.config.FontyTypo;
import com.fattorini.luca.android.fontysfaction.config.FontyConfiguration;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

/**
 * 
 * @author luca-fattorini
 * 
 */
public class AssetsLoader {
	private static final String TAG = AssetsLoader.class.getName();

	public static Typeface get(final Context context, final FontyConfiguration configuration, final FontyTypo font) {
		try {
			List<String> pathStack = new ArrayList<String>();
			String resourceFullPath;
			pathStack.add(configuration.getPath());
			if (configuration.getFontEntityClazz().isAnnotationPresent(FontyPath.class)) {
				Log.v(TAG, "FontPath in root entity: compose url");

				if (configuration.getFontEntityClazz().isAnnotationPresent(FontyPath.class)) {
					FontyPath path = configuration.getFontEntityClazz().getAnnotation(FontyPath.class);
					Log.v(TAG, "entity annotated with FontPath annotation: " + path.value());
					pathStack.add(path.value());
				}

			}

			for (Field field : configuration.getFontEntityClazz().getFields()) {

				if (field.isAnnotationPresent(FontyIdentifier.class)) {
					Log.v(TAG, "field: " + field.getName() + " annotated with FontIdentifier");

					if (field.getAnnotation(FontyIdentifier.class).value().equals(font)) {

						if (field.isAnnotationPresent(FontyPath.class)) {
							FontyPath path = field.getAnnotation(FontyPath.class);
							pathStack.add(path.value());
						}

						if (field.isAnnotationPresent(FontyName.class)) {
							FontyName name = field.getAnnotation(FontyName.class);
							resourceFullPath = joinPaths(pathStack) + name.value();
							Log.v(TAG, "field: " + field.getName() + " annotated with FontName with value: " + name.value());
						} else {
							Log.v(TAG, "field: " + field.getName() + " not annotated with FontName, use his name");
							resourceFullPath = joinPaths(pathStack) + field.getName();
						}

						resourceFullPath += configuration.getExtension();
						Log.d(TAG, resourceFullPath);
						return Typeface.createFromAsset(context.getAssets(), resourceFullPath);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.e(TAG, "can't load " + font.toString() + " return default one");
		}
		return Typeface.DEFAULT;
	}

	protected static String joinPaths(final List<String> paths) {
		String sPath = "";
		for (String path : paths) {
			if (path != null && !path.isEmpty())
				if (sPath.isEmpty())
					sPath = path + "/";
				else
					sPath += path + "/";
		}
		return sPath;
	}

	protected static String enrichResourcePath(final String basePath, final String resource) {
		Log.v(TAG, "enrichResourcePath with params: " + basePath + " " + resource);
		if (resource == null || resource.isEmpty())
			return basePath;
		return basePath + "/" + resource;
	}
}
