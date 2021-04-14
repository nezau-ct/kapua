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

import org.eclipse.kapua.plugin.sso.openid.provider.generic.setting.GenericOpenIDSetting;
import org.eclipse.kapua.plugin.sso.openid.provider.setting.OpenIDSetting;
import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.eclipse.kapua.plugin.sso.openid.exception.OpenIDException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

@Category(JUnitTests.class)
public class GenericOpenIDServiceTest extends Assert {

    GenericOpenIDService genericOpenIDService;
    OpenIDSetting mockedOpenIDSetting;
    GenericOpenIDSetting mockedGenericOpenIDSetting;

    @Before
    public void setUp() {
        genericOpenIDService = new GenericOpenIDService();
        mockedOpenIDSetting = Mockito.mock(OpenIDSetting.class);
        mockedGenericOpenIDSetting = Mockito.mock(GenericOpenIDSetting.class);
    }

    @Test
    public void genericOpenIDServiceWithoutParametersTest() {
        assertTrue("True expected.", genericOpenIDService.isEnabled());
    }

    @Test
    public void genericOpenIDServiceWithParametersTest() {
        assertTrue("True expected.", new GenericOpenIDService(mockedOpenIDSetting, mockedGenericOpenIDSetting).isEnabled());
    }

    @Test
    public void getAuthUriNullEndPointAuthTest() throws OpenIDException {
        System.clearProperty("sso.openid.generic.server.endpoint.auth");
        assertEquals("http://localhost:9090/auth/realms/kapua/protocol/openid-connect/auth", genericOpenIDService.getAuthUri());
    }

    @Test
    public void getTokenUriNullTest() throws OpenIDException {
        System.clearProperty("sso.openid.generic.server.endpoint.token");
        genericOpenIDService.getTokenUri();
    }

    @Test
    public void getLogoutUriNullTest() throws OpenIDException {
        System.clearProperty("sso.openid.generic.server.endpoint.logout");
        genericOpenIDService.getLogoutUri();
    }
}