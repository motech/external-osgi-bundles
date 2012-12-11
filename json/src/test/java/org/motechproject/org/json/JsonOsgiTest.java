package org.motechproject.org.json;

import org.json.JSONObject;

import java.util.logging.Logger;

public class JsonOsgiTest { // TODO!

    private Logger logger = Logger.getLogger(JsonOsgiTest.class.getName());

    public void testJsonIsAvailable() {
        new JSONObject();
    }

//    @Override
//    protected String getPlatformName() {
//        return Platforms.FELIX;
//    }
}
