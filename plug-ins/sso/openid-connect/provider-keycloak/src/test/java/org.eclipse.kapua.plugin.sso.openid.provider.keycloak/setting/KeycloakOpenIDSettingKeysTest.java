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
package org.eclipse.kapua.plugin.sso.openid.provider.keycloak.setting;

import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JUnitTests.class)
public class KeycloakOpenIDSettingKeysTest extends Assert {

    @Test
    public void keycloakOpenIDSettingKeysTest() {
        assertEquals("Expected and actual values should be the same!", "sso.openid.keycloak.uri", KeycloakOpenIDSettingKeys.KEYCLOAK_URI.key());
        assertEquals("Expected and actual values should be the same!", "sso.openid.keycloak.realm", KeycloakOpenIDSettingKeys.KEYCLOAK_REALM.key());
    }
}
