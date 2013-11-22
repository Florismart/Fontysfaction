package com.fattorini.luca.android.fontysfaction.config;

import com.fattorini.luca.android.fontysfaction.annotation.FontyEntity;
import com.fattorini.luca.android.fontysfaction.annotation.FontyIdentifier;
import com.fattorini.luca.android.fontysfaction.annotation.FontyName;
import com.fattorini.luca.android.fontysfaction.annotation.FontyPath;

/**
 * 
 * @author luca-fattorini
 * 
 */
@FontyPath("fonts")
@FontyEntity
public class FontyBaseEntity {

	@FontyIdentifier(FontyTypo.regular)
	@FontyName("regular")
	@FontyPath("roboto")
	public String regular;

	@FontyIdentifier(FontyTypo.bold)
	@FontyName("bold")
	@FontyPath("roboto")
	public String bold;

	@FontyIdentifier(FontyTypo.light)
	@FontyName("light")
	@FontyPath("roboto")
	public String light;

	@FontyIdentifier(FontyTypo.regular_italic)
	@FontyName("regular_italic")
	@FontyPath("roboto")
	public String regular_italic;

	@FontyIdentifier(FontyTypo.bold_italic)
	@FontyName("bold_italic")
	@FontyPath("roboto")
	public String bold_italic;

	@FontyIdentifier(FontyTypo.light_italic)
	@FontyName("light_italic")
	@FontyPath("roboto")
	public String light_italic;

}
