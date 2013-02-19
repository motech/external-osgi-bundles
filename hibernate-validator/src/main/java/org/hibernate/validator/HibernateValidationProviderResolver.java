package org.hibernate.validator;

import javax.validation.ValidationProviderResolver;
import java.util.List;

import static java.util.Arrays.asList;

public class HibernateValidationProviderResolver implements ValidationProviderResolver {

    @Override
    public List getValidationProviders() {
        return asList(new HibernateValidator());
    }
}
