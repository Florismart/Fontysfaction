package com.fattorini.luca.android.fontysfaction.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

import com.fattorini.luca.android.fontysfaction.R;
import com.fattorini.luca.android.fontysfaction.config.FontyTypo;
import com.fattorini.luca.android.fontysfaction.core.FontyLoader;

/**
 * 
 * @author luca-fattorini
 * 
 */
public class FontyButton extends Button {
	private static final String TAG = FontyButton.class.getName();

	public FontyButton(Context context) {
		super(context);
	}

	public FontyButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		initAttributes(context, attrs);
	}

	public FontyButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	protected void initAttributes(final Context context, final AttributeSet attrs) {
		if (attrs != null) {
			TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Fontable);
			int fontTypo = a.getInteger(R.styleable.Fontable_font, 0);
			setCustomFont(fontTypo);
			a.recycle();
		}
	}

	private boolean setCustomFont(int fontTypo) {
		FontyTypo font = FontyTypo.fromIndex(fontTypo);
		try {
			setTypeface(FontyLoader.getInstance().getFont(getContext(), font));
		} catch (Exception exception) {
			Log.e(TAG, "can't load typeface: " + font);
		}
		return true;
	}

}
