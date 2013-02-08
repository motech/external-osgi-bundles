package org.motechproject.aether;

import org.codehaus.plexus.DefaultPlexusContainer;
import org.motechproject.testing.osgi.BaseOsgiIT;
import org.sonatype.aether.RepositorySystem;


public class BundleIT extends BaseOsgiIT {
    public void testPullM2Deps() throws Exception {
        RepositorySystem system = new DefaultPlexusContainer().lookup(RepositorySystem.class);
    }
}
