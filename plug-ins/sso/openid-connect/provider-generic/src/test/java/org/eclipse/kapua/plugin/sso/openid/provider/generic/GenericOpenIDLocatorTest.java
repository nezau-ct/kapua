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
package org.eclipse.kapua.plugin.sso.openid.provider.generic;

import org.eclipse.kapua.plugin.sso.openid.provider.generic.jwt.GenericJwtProcessor;
import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.eclipse.kapua.plugin.sso.openid.exception.OpenIDException;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JUnitTests.class)
public class GenericOpenIDLocatorTest extends Assert {

    GenericOpenIDLocator genericOpenIDLocator;

    @Before
    public void setUp() {
        genericOpenIDLocator = new GenericOpenIDLocator();
    }

    @Test
    public void getServiceTest() {
        assertThat(genericOpenIDLocator.getService(), IsInstanceOf.instanceOf(GenericOpenIDService.class));
    }

    @Test
    public void getProcessorTest() throws OpenIDException {
        System.setProperty("sso.openid.generic.jwt.audience.allowed", "console");
        System.setProperty("sso.openid.generic.jwt.issuer.allowed", "http://localhost:9090/auth/realms/kapua");
        System.setProperty("sso.openid.generic.server.endpoint.auth", "http://localhost:9090/auth/realms/kapua/protocol/openid-connect/auth");
        System.setProperty("sso.openid.generic.server.endpoint.logout", "http://localhost:9090/auth/realms/kapua/protocol/openid-connect/logout");
        System.setProperty("sso.openid.generic.server.endpoint.token", "http://localhost:9090/auth/realms/kapua/protocol/openid-connect/token");
        assertThat("Expected and actual values should be the same.", genericOpenIDLocator.getProcessor(), IsInstanceOf.instanceOf(GenericJwtProcessor.class));
    }

    @Test
    public void closeTest() throws Exception {
        genericOpenIDLocator.close();
    }
}