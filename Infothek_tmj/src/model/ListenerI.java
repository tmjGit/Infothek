package model;

import javafx.beans.property.StringProperty;

public interface ListenerI {
    void changed(StringProperty value);
}
