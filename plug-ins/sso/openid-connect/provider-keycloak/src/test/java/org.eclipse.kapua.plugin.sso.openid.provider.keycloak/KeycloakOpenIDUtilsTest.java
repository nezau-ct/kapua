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
import org.eclipse.kapua.plugin.sso.openid.exception.OpenIDIllegalArgumentException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JUnitTests.class)
public class KeycloakOpenIDUtilsTest extends Assert {

    @Test
    public void getRealmTest() throws OpenIDIllegalArgumentException {
        try {
            KeycloakOpenIDUtils.getRealm();
        } catch (OpenIDIllegalArgumentException iae) {
            assertEquals("Expected and actual values should be the same", "An illegal value was provided for the argument sso.openid.keycloak.realm: null.", iae.getMessage());
        }
        System.setProperty("sso.openid.keycloak.realm", "realm");
        assertEquals("Expected and actual values should be the same", "realm", KeycloakOpenIDUtils.getRealm());
    }

    @Test
    public void getProviderUriTest() throws OpenIDIllegalArgumentException {
        System.setProperty("sso.openid.keycloak.uri", "uri");
        assertEquals("Expected and actual values should be the same", "uri", KeycloakOpenIDUtils.getProviderUri());
    }

    @Test(expected = OpenIDIllegalArgumentException.class)
    public void getProviderUriNullConfigurationTest() throws OpenIDIllegalArgumentException {
        System.clearProperty("sso.openid.keycloak.uri");
        KeycloakOpenIDUtils.getProviderUri();
    }
}