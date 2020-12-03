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
package org.eclipse.kapua.plugin.sso.openid.provider;

import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.eclipse.kapua.plugin.sso.openid.exception.OpenIDException;
import org.eclipse.kapua.plugin.sso.openid.exception.uri.OpenIDLoginUriException;
import org.eclipse.kapua.plugin.sso.openid.provider.setting.OpenIDSetting;
import org.eclipse.kapua.plugin.sso.openid.provider.setting.OpenIDSettingKeys;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import java.net.URI;
import java.net.URISyntaxException;

@Category(JUnitTests.class)
public class AbstractOpenIDServiceTest extends Assert {

    private class ActualOpenIDService extends AbstractOpenIDService {

        public ActualOpenIDService(OpenIDSetting ssoSettings) {
            super(ssoSettings);
        }

        @Override
        protected String getAuthUri() throws OpenIDException {
            return "authUri";
        }

        @Override
        protected String getTokenUri() throws OpenIDException {
            return "http://localhost:8080/";
        }

        @Override
        protected String getLogoutUri() throws OpenIDException {
            return "logout-uri";
        }
    }

    AbstractOpenIDService openIDService;
    OpenIDSetting mockedOpenIDSetting;

    @Before
    public void setUp() {
        mockedOpenIDSetting = Mockito.mock(OpenIDSetting.class);
        openIDService = new ActualOpenIDService(mockedOpenIDSetting);
    }

    @Test
    public void isEnabledTest() {
        assertTrue("True expected", openIDService.isEnabled());
    }

    @Test
    public void getClientIdTest() {
        Mockito.when(mockedOpenIDSetting.getString(OpenIDSettingKeys.SSO_OPENID_CLIENT_ID)).thenReturn("foobar");
        assertEquals("Expected and actual values should be the same.", "foobar", openIDService.getClientId());
    }

    @Test
    public void getClientSecretTest() {
        Mockito.when(mockedOpenIDSetting.getString(OpenIDSettingKeys.SSO_OPENID_CLIENT_SECRET)).thenReturn("foobar");
        assertEquals("Expected and actual values should be the same.", "foobar", openIDService.getClientSecret());
    }

    @Test
    public void getLoginUriTest() throws URISyntaxException, OpenIDException {
        URI redirectUri = new URI(Thread.currentThread().getContextClassLoader().getResource("fileJsonString.json").toString());
//        kako assertat tole, da se prav izpisuje glede na to da je uri noter
        System.out.println(openIDService.getLoginUri("foobar", redirectUri));
    }

    @Test
    public void getLoginUriUriSyntaxExceptionTest() throws URISyntaxException, OpenIDLoginUriException {
        URI redirectUri = new URI(Thread.currentThread().getContextClassLoader().getResource("fileJsonString.json").toString());
        System.out.println(openIDService.getLoginUri("foobar", redirectUri));

    }

    @Test
    public void getLogoutUriTest() throws URISyntaxException, OpenIDException {
        URI redirectUri = new URI(Thread.currentThread().getContextClassLoader().getResource("fileJsonString.json").toString());
//        kako assertat tole, da se prav izpisuje glede na to da je uri noter
        String uri = openIDService.getLogoutUri("idTokenHint", redirectUri, "state");

        System.out.println(uri);
    }

}