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
package org.eclipse.kapua.plugin.sso.openid.provider.setting;

import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JUnitTests.class)
public class OpenIDSettingKeysTest extends Assert {

    @Test
    public void openIDProviderTest() {
        assertEquals("Expected and actual values should be the same!", "sso.openid.provider", OpenIDSettingKeys.SSO_OPENID_PROVIDER.key());
    }

    @Test
    public void openIdConfPathTest() {
        assertEquals("Expected and actual values should be the same!", "sso.openid.conf.path", OpenIDSettingKeys.SSO_OPENID_CONF_PATH.key());
    }

    @Test
    public void openIdClientIdTest() {
        assertEquals("Expected and actual values should be the same!", "sso.openid.client.id", OpenIDSettingKeys.SSO_OPENID_CLIENT_ID.key());
    }

    @Test
    public void openIdClientSecretTest() {
        assertEquals("Expected and actual values should be the same!", "sso.openid.client.secret", OpenIDSettingKeys.SSO_OPENID_CLIENT_SECRET.key());
    }

    @Test
    public void openIdJwtProcessorTimeoutTest() {
        assertEquals("Expected and actual values should be the same!", "sso.openid.jwt_processor_timeout", OpenIDSettingKeys.SSO_OPENID_JWT_PROCESSOR_TIMEOUT.key());
    }
}