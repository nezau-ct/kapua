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
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JUnitTests.class)
public class OpenIDSettingTest extends Assert {

    @Test
    public void openIDSettingTest() {
        OpenIDSetting openIDSetting = new OpenIDSetting("openid-setting.properties");
        assertThat("Instance of OpenIDSetting expected.", openIDSetting, IsInstanceOf.instanceOf(OpenIDSetting.class));
    }

    @Test
    public void getInstanceTest() {
        assertThat("Instance of OpenIDSetting expected.", OpenIDSetting.getInstance(), IsInstanceOf.instanceOf(OpenIDSetting.class));
    }
}