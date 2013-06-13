package org.motechproject.quartz.osgi;

import org.motechproject.quartz.CouchDbStore;
import org.motechproject.testing.osgi.BaseOsgiIT;

public class QuartzBundleIT extends BaseOsgiIT{

    public void testException() {
        assertNotNull(new CouchDbStore());
    }
}
