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

import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JUnitTests.class)
public class ProviderImplTest extends Assert {

    ProviderImpl providerImpl;

    @Before
    public void setUp() {
        providerImpl = new ProviderImpl();
    }

    @Test
    public void getIdTest() {
        assertEquals("keycloak", providerImpl.getId());
    }

    @Test
    public void createLocatorTest() {
        assertThat("Instance of KeycloakOpenIDLocator expected.", providerImpl.createLocator(), IsInstanceOf.instanceOf(KeycloakOpenIDLocator.class));
    }
}