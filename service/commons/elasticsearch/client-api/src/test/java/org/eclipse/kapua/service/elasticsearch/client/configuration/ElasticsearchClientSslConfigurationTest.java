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
package org.eclipse.kapua.service.elasticsearch.client.configuration;

import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JUnitTests.class)
public class ElasticsearchClientSslConfigurationTest extends Assert {

    ElasticsearchClientSslConfiguration elasticsearchClientSslConfiguration;

    @Before
    public void setUp() {
        elasticsearchClientSslConfiguration = new ElasticsearchClientSslConfiguration();
    }

    @Test
    public void isEnabledTest() {
        elasticsearchClientSslConfiguration.setEnabled(true);
        assertTrue("True expected.", elasticsearchClientSslConfiguration.isEnabled());
        elasticsearchClientSslConfiguration.setEnabled(false);
        assertFalse("False expected.", elasticsearchClientSslConfiguration.isEnabled());
    }

    @Test
    public void isTrustServiceCertificateTest() {
        elasticsearchClientSslConfiguration.setTrustServiceCertificate(true);
        assertTrue("True expected.", elasticsearchClientSslConfiguration.isTrustServiceCertificate());
        elasticsearchClientSslConfiguration.setTrustServiceCertificate(false);
        assertFalse("False expected.", elasticsearchClientSslConfiguration.isTrustServiceCertificate());
    }

    @Test
    public void getKeyStorePathTest() {
        assertNull("Null expected.", elasticsearchClientSslConfiguration.getKeyStorePath());
        elasticsearchClientSslConfiguration.setKeyStorePath("Key Store Path");
        assertEquals("Expected and actual values should be the same.", "Key Store Path", elasticsearchClientSslConfiguration.getKeyStorePath());
    }

    @Test
    public void getKeyStorePasswordTest() {
        assertNull("Null expected.", elasticsearchClientSslConfiguration.getKeyStorePassword());
        elasticsearchClientSslConfiguration.setKeyStorePassword("Key Store Password");
        assertEquals("Expected and actual values should be the same.", "Key Store Password", elasticsearchClientSslConfiguration.getKeyStorePassword());
    }

    @Test
    public void getKeyStoreTypeTest() {
        assertNull("Null expected.", elasticsearchClientSslConfiguration.getKeyStoreType());
        elasticsearchClientSslConfiguration.setKeyStoreType("Key Store Type");
        assertEquals("Expected and actual values should be the same.", "Key Store Type", elasticsearchClientSslConfiguration.getKeyStoreType());
    }

    @Test
    public void getTrustStorePathTest() {
        assertNull("Null expected.", elasticsearchClientSslConfiguration.getTrustStorePath());
        elasticsearchClientSslConfiguration.setTrustStorePath("Trust Store Path");
        assertEquals("Expected and actual values should be the same.", "Trust Store Path", elasticsearchClientSslConfiguration.getTrustStorePath());
    }

    @Test
    public void getTrustStorePasswordTest() {
        assertNull("Null expected.", elasticsearchClientSslConfiguration.getTrustStorePassword());
        elasticsearchClientSslConfiguration.setTrustStorePassword("Trust Store Password");
        assertEquals("Expected and actual values should be the same.", "Trust Store Password", elasticsearchClientSslConfiguration.getTrustStorePassword());
    }
}
