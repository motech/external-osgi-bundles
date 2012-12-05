package org.motechproject.org.codehaus.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.gemini.blueprint.test.platform.Platforms;
import org.motechproject.testing.osgi.BaseOsgiIT;
import org.osgi.framework.Constants;

import java.io.IOException;
import java.util.jar.Manifest;
import java.util.logging.Logger;

public class JacksonOsgiIT extends BaseOsgiIT {

    private Logger logger = Logger.getLogger(JacksonOsgiIT.class.getName());

    public void testJacksonDeserialization() throws IOException {
        Entity entity = new Entity("foo");
        Entity deserializedEntity = new ObjectMapper().readValue("{ \"name\":\"foo\"}", Entity.class);
        assertEquals(entity.getName(), deserializedEntity.getName());
    }

    public void testJacksonPolymorphicDeserialization() throws IOException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());  // go figure
        AbstractEntity entity = new MyEntity("foo");
        AbstractEntity deserializedEntity = new ObjectMapper().readValue(
            "{ \"name\":\"foo\", \"@type\":\"org.motechproject.org.codehaus.jackson.MyEntity\" }"
            , AbstractEntity.class);
        assertEquals(MyEntity.class, deserializedEntity.getClass());
        assertEquals(entity.getName(), deserializedEntity.getName());
        Thread.currentThread().setContextClassLoader(contextClassLoader);
    }

    @Override
    protected Manifest getManifest() {
        Manifest mf = super.getManifest();

        String imports = mf.getMainAttributes().getValue(Constants.IMPORT_PACKAGE);
        if (imports == null)
            imports = "";
        else
            imports = "," + imports;
        mf.getMainAttributes().putValue(Constants.IMPORT_PACKAGE, String.format("org.codehaus.jackson.annotate%s", imports));

        String exports = mf.getMainAttributes().getValue(Constants.EXPORT_PACKAGE);
        if (exports == null)
            exports = "";
        else
            exports = "," + exports;
        mf.getMainAttributes().putValue(Constants.EXPORT_PACKAGE, String.format("org.motechproject.org.codehaus.jackson%s", exports));

        System.out.println(mf.getMainAttributes().getValue(Constants.IMPORT_PACKAGE));
        System.out.println(mf.getMainAttributes().getValue(Constants.EXPORT_PACKAGE));

        return mf;
    }
}
