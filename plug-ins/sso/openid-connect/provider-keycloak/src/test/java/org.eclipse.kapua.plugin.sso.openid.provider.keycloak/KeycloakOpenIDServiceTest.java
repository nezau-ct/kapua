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

import org.eclipse.kapua.plugin.sso.openid.provider.setting.OpenIDSetting;
import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.eclipse.kapua.plugin.sso.openid.exception.OpenIDIllegalArgumentException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

@Category(JUnitTests.class)
public class KeycloakOpenIDServiceTest extends Assert {

    KeycloakOpenIDService keycloakOpenIDService;
    OpenIDSetting mockedOpenIDSetting;

    @Before
    public void setUp() {
        keycloakOpenIDService = new KeycloakOpenIDService();
        mockedOpenIDSetting = Mockito.mock(OpenIDSetting.class);
    }

    @Test
    public void keycloakOpenIDServiceTest() throws OpenIDIllegalArgumentException {
        assertTrue("True expected.", keycloakOpenIDService.isEnabled());
    }

    @Test
    public void keycloakOpenIDServiceParameterTest() throws OpenIDIllegalArgumentException {
        assertTrue("True expected.", new KeycloakOpenIDService(mockedOpenIDSetting).isEnabled());
    }

    @Test
    public void getAuthUriTest() throws OpenIDIllegalArgumentException {
        System.setProperty("sso.openid.keycloak.uri", "sso.openid.keycloak.uri");
        System.setProperty("sso.openid.keycloak.realm", "sso.openid.keycloak.realm");
        assertEquals("Expected and actual values should be the same.", "sso.openid.keycloak.uri/auth/realms/sso.openid.keycloak.realm/protocol/openid-connect/auth", keycloakOpenIDService.getAuthUri());
    }

    @Test
    public void getTokenUriTest() throws OpenIDIllegalArgumentException {
        System.setProperty("sso.openid.keycloak.uri", "sso.openid.keycloak.uri");
        System.setProperty("sso.openid.keycloak.realm", "sso.openid.keycloak.realm");
        assertEquals("Expected and actual values should be the same.", "sso.openid.keycloak.uri/auth/realms/sso.openid.keycloak.realm/protocol/openid-connect/token", keycloakOpenIDService.getTokenUri());
    }

    @Test
    public void getLogoutUriTest() throws OpenIDIllegalArgumentException {
        System.setProperty("sso.openid.keycloak.uri", "foobar.com");
        System.setProperty("sso.openid.keycloak.realm", "my-realm");
        assertEquals("Expected and actual values should be the same.", "sso.openid.keycloak.uri/auth/realms/sso.openid.keycloak.realm/protocol/openid-connect/logout", keycloakOpenIDService.getLogoutUri());

    }
}