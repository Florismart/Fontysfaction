package com.fattorini.luca.android.fontysfaction.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RadioButton;

import com.fattorini.luca.android.fontysfaction.R;
import com.fattorini.luca.android.fontysfaction.config.FontyTypo;
import com.fattorini.luca.android.fontysfaction.core.FontyLoader;

/**
 * 
 * @author luca-fattorini
 * 
 */
public class FontyRadioButton extends RadioButton {
	private static final String TAG = FontyRadioButton.class.getName();

	public FontyRadioButton(Context context) {
		super(context);
	}

	public FontyRadioButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		initAttributes(context, attrs);
	}

	public FontyRadioButton(Context context, AttributeSet attrs, int defStyle) {
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
