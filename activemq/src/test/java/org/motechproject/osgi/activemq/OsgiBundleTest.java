package org.motechproject.osgi.activemq;

import org.eclipse.gemini.blueprint.test.platform.Platforms;
import org.motechproject.testing.osgi.BaseOsgiIT;

public class OsgiBundleTest extends BaseOsgiIT{
    public void testBundle() {
        assertNotNull(bundleContext.getBundles());
    }

    @Override
    protected String getPlatformName() {
        return Platforms.EQUINOX;
    }
}
