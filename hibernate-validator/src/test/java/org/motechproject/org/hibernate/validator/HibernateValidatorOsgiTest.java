package org.motechproject.org.hibernate.validator;

import org.eclipse.gemini.blueprint.test.platform.Platforms;
import org.motechproject.testing.osgi.BaseOsgiIT;

import java.util.logging.Logger;

public class HibernateValidatorOsgiTest extends BaseOsgiIT {

    private Logger logger = Logger.getLogger(HibernateValidatorOsgiTest.class.getName());

    public void testHibernateIsAvailable() {
        // TODO!
    }

    @Override
    protected String getPlatformName() {
        return Platforms.FELIX;
    }
}
