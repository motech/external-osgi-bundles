package org.motechproject.org.hibernate.validator;

import org.hibernate.validator.HibernateValidator;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.bootstrap.ProviderSpecificBootstrap;

public final class ValidatorFactoryBean {

    private final static ValidatorFactory instance;

    static {
        ProviderSpecificBootstrap validationBootStrap = Validation.byProvider(HibernateValidator.class);
        validationBootStrap.providerResolver(new HibernateValidationProviderResolver());
        instance = validationBootStrap.configure().buildValidatorFactory();
    }

    public final static ValidatorFactory getInstance() {
        return instance;
    }
}