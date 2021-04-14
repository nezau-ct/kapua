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

import org.eclipse.kapua.plugin.sso.openid.JwtProcessor;
import org.eclipse.kapua.plugin.sso.openid.OpenIDService;
import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.eclipse.kapua.plugin.sso.openid.exception.OpenIDException;
import org.eclipse.kapua.plugin.sso.openid.provider.setting.OpenIDSetting;
import org.eclipse.kapua.plugin.sso.openid.provider.setting.OpenIDSettingKeys;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

@Category(JUnitTests.class)
public class ProviderOpenIDLocatorTest extends Assert {

    OpenIDSetting mockedOpenIDSetting;

    @Before
    public void setUp() {
        mockedOpenIDSetting = Mockito.mock(OpenIDSetting.class);
    }

    @Test
    public void providerOpenIDLocatorNullSettingsTest() {
        ProviderOpenIDLocator providerOpenIDLocator = new ProviderOpenIDLocator(mockedOpenIDSetting);
        assertTrue("True expected.", providerOpenIDLocator instanceof ProviderOpenIDLocator);
    }

    @Test
    public void providerOpenIDLocatorSettingsParameterTest() throws OpenIDException {
        Mockito.doReturn("string").when(mockedOpenIDSetting).getString(OpenIDSettingKeys.SSO_OPENID_PROVIDER, null);
        ProviderOpenIDLocator providerOpenIDLocator = new ProviderOpenIDLocator(mockedOpenIDSetting);
        assertNotNull(providerOpenIDLocator.getService());
        assertNotNull(providerOpenIDLocator.getProcessor());
    }

    @Test
    public void providerOpenIDLocatorSsoProviderIllegalArgumentExceptionTest() {
        try {
            Mockito.doReturn("string").when(mockedOpenIDSetting).getString(OpenIDSettingKeys.SSO_OPENID_PROVIDER, null);
            ProviderOpenIDLocator providerSingleSignOnLocator1 = new ProviderOpenIDLocator(mockedOpenIDSetting);
        } catch (IllegalArgumentException iae) {
            assertEquals("Unable to find OpenID provider 'string'", iae.getMessage());
        }
    }

    @Test
    public void closeTest() {
        new ProviderOpenIDLocator().close();
    }

    @Test
    public void getServiceTest() {
        assertTrue("True expected.", (new ProviderOpenIDLocator()).getService() instanceof OpenIDService);
    }

    @Test
    public void getProcessorTest() throws OpenIDException {
        assertTrue("True expected.", (new ProviderOpenIDLocator()).getProcessor() instanceof JwtProcessor);
    }
}