package org.motechproject.org.mvel;

import org.motechproject.testing.osgi.BaseOsgiIT;
import org.mvel.MVEL;

import java.util.logging.Logger;

public class MvelOsgiIT extends BaseOsgiIT {

    private Logger logger = Logger.getLogger(MvelOsgiIT.class.getName());

    public void testMvelIsAvailable() {
        assertTrue( (Boolean) MVEL.eval("true"));
    }
}
