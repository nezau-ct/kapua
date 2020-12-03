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
package org.eclipse.kapua.plugin.sso.openid.provider.generic.setting;

import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JUnitTests.class)
public class GenericOpenIDSettingKeysTest extends Assert {

    @Test
    public void genericOpenIDSettingKeysEnumTest() {
        assertEquals("Expected and actual values should be the same!", "sso.openid.generic.server.endpoint.auth", GenericOpenIDSettingKeys.SSO_OPENID_SERVER_ENDPOINT_AUTH.key());
        assertEquals("Expected and actual values should be the same!", "sso.openid.generic.server.endpoint.token", GenericOpenIDSettingKeys.SSO_OPENID_SERVER_ENDPOINT_TOKEN.key());
        assertEquals("Expected and actual values should be the same!", "sso.openid.generic.server.endpoint.logout", GenericOpenIDSettingKeys.SSO_OPENID_SERVER_ENDPOINT_LOGOUT.key());
        assertEquals("Expected and actual values should be the same!", "sso.openid.generic.jwt.audience.allowed", GenericOpenIDSettingKeys.SSO_OPENID_JWT_AUDIENCE_ALLOWED.key());
        assertEquals("Expected and actual values should be the same!", "sso.openid.generic.jwt.issuer.allowed", GenericOpenIDSettingKeys.SSO_OPENID_JWT_ISSUER_ALLOWED.key());
    }
}