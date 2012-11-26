package org.motechproject.org.mvel;

import org.eclipse.gemini.blueprint.test.platform.Platforms;
import org.motechproject.testing.osgi.BaseOsgiIT;
import org.mvel.MVEL;

import java.util.logging.Logger;

public class MvelOsgiTest extends BaseOsgiIT {

    private Logger logger = Logger.getLogger(MvelOsgiTest.class.getName());

    public void testMvelIsAvailable() {
        assertTrue( (Boolean) MVEL.eval("true"));
    }

    @Override
    protected String getPlatformName() {
        return Platforms.FELIX;
    }
}
