package org.motechproject.org.ektorp;

import org.eclipse.gemini.blueprint.util.OsgiStringUtils;
import org.ektorp.DbInfo;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.motechproject.testing.osgi.BaseOsgiIT;
import org.osgi.framework.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class EktorpOsgiIT extends BaseOsgiIT {
    private Logger logger = Logger.getLogger(EktorpOsgiIT.class.getName());

    public void testEktorpIsAvailable() {
        final StdCouchDbConnector dbConnector = new StdCouchDbConnector("ektorpitdb", new StdCouchDbInstance( new StdHttpClient.Builder().caching(false).build()));
        dbConnector.createDatabaseIfNotExists();
        final DbInfo dbInfo = dbConnector.getDbInfo();
        assertEquals("ektorpitdb", dbInfo.getDbName());
        dbConnector.create("docid", new HashMap() {{
            put("value", 12);
        }});
        final Map doc = dbConnector.get(Map.class, "docid");
        assertEquals(12, doc.get("value"));
        dbConnector.delete("docid", doc.get("_rev").toString());
    }
}
