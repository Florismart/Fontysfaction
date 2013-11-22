package com.fattorini.luca.android.fontysfaction.core;

import java.lang.ref.SoftReference;
import java.util.Hashtable;

import android.graphics.Typeface;

import com.fattorini.luca.android.fontysfaction.config.FontyTypo;

/**
 * 
 * @author luca-fattorini
 * 
 */
public class FontyCache extends Hashtable<FontyTypo, SoftReference<Typeface>> {
	private static final long serialVersionUID = -8279567705604215191L;
}
