package org.motechproject.com.googlecode.lambdaj;

import org.hamcrest.core.IsEqual;
import org.motechproject.testing.osgi.BaseOsgiIT;

import java.util.List;

import static ch.lambdaj.Lambda.filter;
import static java.util.Arrays.asList;

public class OsgiIT extends BaseOsgiIT {
    public void testLambdaJ(){
        List<Integer> biggerThan3 = filter(new IsEqual<Object>(4), asList(1, 2, 3, 4, 5));
        assertTrue(biggerThan3.contains(4));
    }
}
