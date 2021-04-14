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

import org.eclipse.kapua.plugin.sso.openid.exception.uri.OpenIDIllegalUriException;
import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.eclipse.kapua.plugin.sso.openid.exception.OpenIDIllegalArgumentException;
import org.eclipse.kapua.plugin.sso.openid.exception.uri.OpenIDUriException;
import org.eclipse.kapua.plugin.sso.openid.exception.uri.OpenIDJwtUriException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Category(JUnitTests.class)
public class OpenIDUtilsTest extends Assert {

    @Test
    public void getConfigUriTest() throws OpenIDUriException, URISyntaxException {
        URI uri = new URI("https://abcd");
        assertEquals("Expected and actual values should be the same.", Optional.of(uri).get(), OpenIDUtils.getConfigUri("foobar", Thread.currentThread().getContextClassLoader().getResource("fileJsonString.json").toString()).get());
    }

    @Test
    public void getConfigUriUriJsonValueNotStringTest() throws OpenIDUriException {
        assertFalse("Optional should be empty.", OpenIDUtils.getConfigUri("foobar", Thread.currentThread().getContextClassLoader().getResource("fileJsonInt.json").toString()).isPresent());
    }

    @Test(expected = OpenIDJwtUriException.class)
    public void malformedURLExceptionTest() throws OpenIDUriException {
        OpenIDUtils.getConfigUri("foobar", "malformed-uri");
    }

    @Test(expected = OpenIDJwtUriException.class)
    public void ioeExceptionTest() throws OpenIDUriException {
        OpenIDUtils.getConfigUri("foobar", "https://google.com/.well-known/openid-configuration");
    }

    @Test
    public void getOpenIdConfPathUriIssuer() throws URISyntaxException, OpenIDIllegalArgumentException {
        System.setProperty("sso.openid.conf.path", ".well-known/openid-configuration");
        URI issuer = new URI("file:/");
        assertEquals("Expected and actual values should be the same.", "file://.well-known/openid-configuration", OpenIDUtils.getOpenIdConfPath(issuer));
        System.clearProperty("sso.openid.conf.path");
    }

    @Test
    public void getOpenIdConfPathThrowingExceptionTest() throws OpenIDIllegalArgumentException {
        try {
            System.setProperty("sso.openid.conf.path", "ssoOpenidConfPath");
            OpenIDUtils.getOpenIdConfPath("issuer");
        } catch (OpenIDIllegalUriException e) {
            assertEquals("An illegal value was provided for the URI openIdConfPath: issuer/ssoOpenidConfPath.", e.getMessage());
        }
    }

    @Test
    public void getOpenIdConfPathNullPathSuffixTest() {
        System.setProperty("sso.openid.conf.path", "");
        try {
            OpenIDUtils.getOpenIdConfPath("file:/");
        } catch (OpenIDIllegalArgumentException e) {
            System.clearProperty("sso.openid.conf.path");
            assertEquals("An illegal value was provided for the argument sso.openid.conf.path: .", e.getMessage());
        }
    }

    @Test
    public void getOpenIdConfPathTest() throws OpenIDIllegalArgumentException {
        System.setProperty("sso.openid.conf.path", "foobar");
        assertEquals("Expected and actual values should be the same.", "file://.well-known/openid-configuration", OpenIDUtils.getOpenIdConfPath("file:/"));
    }

}