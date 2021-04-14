/*******************************************************************************
 * Copyright (c) 2021 Eurotech and/or its affiliates and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.plugin.sso.openid.provider.keycloak;

import org.eclipse.kapua.plugin.sso.openid.exception.OpenIDException;
import org.eclipse.kapua.plugin.sso.openid.provider.keycloak.jwt.KeycloakJwtProcessor;
import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JUnitTests.class)
public class KeycloakOpenIDLocatorTest extends Assert {

    KeycloakOpenIDLocator keycloakOpenIDLocator;

    @Before
    public void setUp() {
        keycloakOpenIDLocator = new KeycloakOpenIDLocator();
    }

    @Test
    public void getServiceTest() {
        assertThat("An instance of KeycloakOpenIDService expected", keycloakOpenIDLocator.getService(), IsInstanceOf.instanceOf(KeycloakOpenIDService.class));
    }

    @Test
    public void getProcessorTest() throws OpenIDException {
        System.setProperty("sso.openid.client.id", "id");
        System.setProperty("sso.openid.keycloak.uri", "http://localhost:9090");
        System.setProperty("sso.openid.keycloak.realm", "kapua");
        assertThat("An instance of KeycloakJwtProcessor expected", keycloakOpenIDLocator.getProcessor(), IsInstanceOf.instanceOf(KeycloakJwtProcessor.class));
    }

//    This test will be upgraded once method "close" gets a body.
    @Test
    public void closeTest() throws Exception {
        keycloakOpenIDLocator.close();
    }
}