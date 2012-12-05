package org.motechproject.osgi.activemq;

import org.eclipse.gemini.blueprint.test.platform.Platforms;
import org.motechproject.testing.osgi.BaseOsgiIT;

public class OsgiBundleIT extends BaseOsgiIT{
    public void testBundle() {
        assertNotNull(bundleContext.getBundles());
    }
}
