package li.tmj.ui.lang;

import java.io.IOException;
import java.security.KeyException;
import java.util.HashMap;
import java.util.MissingResourceException;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import li.tmj.app.Application;
import li.tmj.conf.Config;
import li.tmj.conf.Configs;
import li.tmj.conf.FileConfig;

public final class Localization {
	public static Config config;

	static {
		config=createLocalization();
		config.setMissingValueDefinition(Configs.CURRENT_IDENTIFIER); // if a key evaluates to nothing, return the key
	}
	
	private Localization() {}
	
	public static Config getConfig() {
		return config;
	}
	
	public static String get(String key) {
		try {
			return config.get(key);
			
		} catch (KeyException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key;
	}
	
	private static Config createLocalization() {
//		String languageCode= Application.confMainGet("language"); 
//		Config c=Configs.create(languageCode, "src/" + Application.PROP_PATH+Application.LANG_BASENAME, languageCode);
//		c.setFallbacks(languagesMap.get("default"));
//		return c;
		HashMap<String,FileConfig> languagesMap=listInstalledLanguages();
		String languageCode= Application.confMainGet("language"); 
		if (null==languageCode || "".equals(languageCode)) {
			return null;
		}
		Config c=null;
		System.out.println("Localization: languageCode="+languageCode);
		if (languagesMap.containsKey(languageCode)) {
			c=languagesMap.get(languageCode) ;
			System.out.println("Localization: c="+c+", setFallback...");
			c.setFallbacks(languagesMap.get("default"));
		} else if (languagesMap.containsKey("default")) {
			c=languagesMap.get("default") ;
			System.out.println("Localization: default: c="+c);
		}else {
			throw new MissingResourceException("Missing language resource!",Localization.class.getName(),languageCode);
		}
		return c;
	}
	
	private static HashMap<String,FileConfig> listInstalledLanguages() {
		Pattern pattern = Pattern.compile(Application.LANG_RESOURCES, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
		Predicate<String> p = pattern.asPredicate();
		return Configs.listInstalledConfigs( "src/" + Application.PROP_PATH ,
			p,
			s -> filenameToLocale(s)
		);
	}
	
	private static String filenameToLocale(String filename) {
		// <LANG_BASENAME>_XX_YY.<PROP_SUFFIX>... // the structure of the file names is ensured by the Predicate above
		int i=0;
		if(filename.endsWith("."+Application.PROP_SUFFIX)){
			i=1+Application.PROP_SUFFIX.length();
		}else if(filename.endsWith("."+Application.PROP_SUFFIX2)){
			i=1+Application.PROP_SUFFIX2.length();
		}else if(filename.endsWith(".")){
			i=1;
		}
		String s;
		if(i>0) { // yes, we have a suffix
			s = filename.substring(0, filename.length()-i);
		}else {
			s=filename;
		}
		if(s.length() > Application.LANG_BASENAME.length()) {
			return s.substring(Application.LANG_BASENAME.length()+1);
		}
		return "default";
	}
	
}
