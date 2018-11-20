package tmj.ui.lang;

import tmj.ui.controls.FxControlable;

public class Language implements FxControlable{
	private String name;
	
	public Language(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String getDisplayName() {
		return Localization.get(name);
	}

	@Override
	public String toString() {
		return "Language [name=" + name + "]";
	}
}
