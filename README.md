Fontysfaction
=============

Fontysfaction is an Open Source Android library that allows developers to easily create applications with custom fonts. Feel free to use it all you want in your Android apps provided that you cite this project and include the license in your app.


![Screenshot](https://raw.github.com/FattoriniLuca/Fontysfaction/master/screen-app.png)


Setup
-----
__1.__ In Eclipse, import the library as an Android library project. Project > Clean to generate the binaries 
you need, like R.java, etc.

__2.__ Then, add Fontysfaction as a dependency to your existing project.

__3.__ At Last quick setup your application class and you are good to go!

```java
public class TestApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		
		//Create a base FontyConfiguration and initialize FontyLoader
		FontyConfiguration configuration = FontyConfigurationBuilder.builder()
		    ...		
		    .build();
		FontyLoader.getInstance().init(configuration);
	}
}
```

Configuration
-----
All options in FontyConfiguration builder are optional. Use only those you really want to customize.
```java
FontyConfiguration configuration = FontyConfigurationBuilder.builder()
	.fontEntity(MyFontyEntity .class)
	.sourceTypo(FontySourceTypo.assets)
	.extension(".ttf")
	.path("base_path")
	.build();
```

FontyEntity
-----
You can configure your FontyEntity via Annotations, only required one is @FontyEntity!
![Screenshot](https://raw.github.com/FattoriniLuca/Fontysfaction/master/test-configuration.png) 
```java
//full configuration example
@FontyPath("fonts")
@FontyEntity
public class MyFontyEntity {

	@FontyIdentifier(FontyTypo.regular)
	@FontyName("MyFont-Regular")
	@FontyPath("myfont")
	public String regular;

	@FontyIdentifier(FontyTypo.bold)
	@FontyName("MyFont-Bold")
	@FontyPath("myfont")
	public String bold;

	@FontyIdentifier(FontyTypo.light)
	@FontyName("MyFont-Light")
	@FontyPath("myfont")
	public String light;

	@FontyIdentifier(FontyTypo.regular_italic)
	@FontyName("MyFont-Regular-Italic")
	@FontyPath("myfont")
	public String regular_italic;

	@FontyIdentifier(FontyTypo.bold_italic)
	@FontyName("MyFont-Bold-Italic")
	@FontyPath("myfont")
	public String bold_italic;

	@FontyIdentifier(FontyTypo.light_italic)
	@FontyName("MyFont-Light-Italic")
	@FontyPath("myfont")
	public String light_italic;
}
```

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
