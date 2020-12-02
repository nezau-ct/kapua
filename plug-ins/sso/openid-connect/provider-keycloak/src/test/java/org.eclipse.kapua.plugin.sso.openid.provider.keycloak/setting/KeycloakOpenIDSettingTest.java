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

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;
import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.junit.Assert;
import org.junit.experimental.categories.Category;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

@Category(JUnitTests.class)
public class KeycloakOpenIDSettingTest extends Assert {

    @Test
    public void keycloakOpenIDSettingWithoutParametersTest() throws Exception {
        Constructor<KeycloakOpenIDSetting> keycloakOpenIDSetting = KeycloakOpenIDSetting.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(keycloakOpenIDSetting.getModifiers()));
        keycloakOpenIDSetting.setAccessible(true);
        assertThat("Instance of KeycloakOpenIDSetting expected.", keycloakOpenIDSetting.newInstance(), IsInstanceOf.instanceOf(KeycloakOpenIDSetting.class));
    }

    @Test
    public void keycloakOpenIDSettingWithParameterTest() {
        try {
            new KeycloakOpenIDSetting("openid-keycloak-setting.properties");
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    public void getInstanceTest() {
        assertThat("Instance of KeycloakOpenIDSetting expected.", KeycloakOpenIDSetting.getInstance(), IsInstanceOf.instanceOf(KeycloakOpenIDSetting.class));
    }
}