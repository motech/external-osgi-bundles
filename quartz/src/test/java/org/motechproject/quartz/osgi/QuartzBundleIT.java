package org.motechproject.quartz.osgi;

import org.motechproject.testing.osgi.BaseOsgiIT;
import org.quartz.ObjectAlreadyExistsException;

public class QuartzBundleIT extends BaseOsgiIT{

    public void testException() {
        new ObjectAlreadyExistsException("");
    }
}
