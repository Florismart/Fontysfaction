Fontysfaction
=============

Fontysfaction is an Open Source Android library that allows developers to easily create applications with custom fonts. Feel free to use it all you want in your Android apps provided that you cite this project and include the license in your app.

Setup
-----
* In Eclipse, just import the library as an Android library project. Project > Clean to generate the binaries 
you need, like R.java, etc.
* Then, just add Fontysfaction as a dependency to your existing project and you're good to go!

XML Usage
-----
If you decide to use Fontysfaction as a view, you can define it in your xml layouts like this:
```xml
<com.fattorini.luca.android.fontysfaction.view.FontyTextView
    xmlns:fonty="http://schemas.android.com/apk/res-auto"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hey, this is a regular TextView Fontysfaction"
    fonty="regular" />

<com.fattorini.luca.android.fontysfaction.view.FontyButton
    xmlns:fonty="http://schemas.android.com/apk/res-auto"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hey, this is a bold Button Fontysfaction!"
    fonty:font="bold" />
    
<com.fattorini.luca.android.fontysfaction.view.EditText
    xmlns:fonty="http://schemas.android.com/apk/res-auto"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hey, this is a regular-italic Button Fontysfaction!"
    fonty:font="regular_italic" />
```
