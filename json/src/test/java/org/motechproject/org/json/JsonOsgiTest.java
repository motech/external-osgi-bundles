package org.motechproject.org.json;

import org.eclipse.gemini.blueprint.test.platform.Platforms;
import org.json.JSONObject;
import org.motechproject.testing.osgi.BaseOsgiIT;

import java.util.logging.Logger;

public class JsonOsgiTest extends BaseOsgiIT {

    private Logger logger = Logger.getLogger(JsonOsgiTest.class.getName());

    public void testJsonIsAvailable() {
        new JSONObject();
    }

    @Override
    protected String getPlatformName() {
        return Platforms.FELIX;
    }
}
