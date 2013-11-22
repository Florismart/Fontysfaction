package com.fattorini.luca.android.fontysfaction.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.fattorini.luca.android.fontysfaction.config.FontyTypo;

/**
 * 
 * @author luca-fattorini Identifier of FontyTypo
 * 
 * @see #FontyTypo
 * 
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FontyIdentifier {
	FontyTypo value() default FontyTypo.regular;
}
