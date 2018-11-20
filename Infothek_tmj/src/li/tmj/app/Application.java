package li.tmj.app;

import li.tmj.conf.Configs;
import li.tmj.log.Log;
import li.tmj.ui.lang.Localization;

public class Application {
	public static final String NAME="Infothek";
	public static final String DOMAIN="li.tmj";
	public static final String ORGANIZATION="tmj";
	public static final String PROP_PATH = "properties/";
	public static final String PROP_SUFFIX = "properties";
	public static final String PROP_SUFFIX2 = "conf";
	public static final String LANG_BASENAME = "MessagesBundle";
	public static final String LANG_RESOURCES= LANG_BASENAME + "(_[^.]*)?(\\."+PROP_SUFFIX+"|\\."+PROP_SUFFIX+"|\\.|)"; // LANG_BASENAME + "_.._..\\."+PROP_SUFFIX;
	public static final String PROPERTY_FILE = "/" +PROP_PATH+ NAME + ".conf";
	public static final String MAIN_CONF="main";
	public static final String MISSING_RESOURCE="<missing resource>";
	public static final String MISSING_VALUE="<missing value>";
	public static final int FX_CONTROLS_DISTANCE=6; // top most control:  top=12
	public static final int FX_LINE_HEIGHT=20;   // second control: top=6+19+6=31
	
	static {
		Configs.setMissingResourceDefinition(Configs.EXCEPTION); // if a non existing resource is called, throw exception rather than return a special value
		Configs.setLocalizer(name->Localization.get(name));
		Configs.setMissingResource(MISSING_RESOURCE);
		Configs.setMissingValue(MISSING_VALUE);
		Configs.create(MAIN_CONF, PROPERTY_FILE, true);
		Configs.get(MAIN_CONF).setMissingValueDefinition(Configs.CUSTOMIZED);
	}
	
	public static void init() {
		Log.init();
	}
	
	public static String confMainGet(String key) {
		System.out.println("Application.confMainGet: key="+key);
		return Configs.get(MAIN_CONF, key);
	}
	
}

