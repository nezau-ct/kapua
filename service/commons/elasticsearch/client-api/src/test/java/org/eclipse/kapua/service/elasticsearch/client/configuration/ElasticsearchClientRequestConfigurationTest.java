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
public class ElasticsearchClientRequestConfigurationTest extends Assert {

    ElasticsearchClientRequestConfiguration elasticsearchClientRequestConfiguration;

    @Before
    public void setUp() {
        elasticsearchClientRequestConfiguration = new ElasticsearchClientRequestConfiguration();
    }

    @Test
    public void getRequestRetryAttemptMaxTest() {
        assertEquals("Expected and actual values should be the same.", 3, elasticsearchClientRequestConfiguration.getRequestRetryAttemptMax());
        elasticsearchClientRequestConfiguration.setRequestRetryAttemptMax(0);
        assertEquals("Expected and actual values should be the same.", 0, elasticsearchClientRequestConfiguration.getRequestRetryAttemptMax());

    }

    @Test
    public void getRequestRetryAttemptWaitTest() {
        assertEquals("Expected and actual values should be the same.", 2500, elasticsearchClientRequestConfiguration.getRequestRetryAttemptWait());
        elasticsearchClientRequestConfiguration.setRequestRetryAttemptWait(0);
        assertEquals("Expected and actual values should be the same.", 0, elasticsearchClientRequestConfiguration.getRequestRetryAttemptWait());

    }

    @Test
    public void getQueryTimeoutTest() {
        assertEquals("Expected and actual values should be the same.", 15000, elasticsearchClientRequestConfiguration.getQueryTimeout());
        elasticsearchClientRequestConfiguration.setQueryTimeout(0);
        assertEquals("Expected and actual values should be the same.", 0, elasticsearchClientRequestConfiguration.getQueryTimeout());
    }

    @Test
    public void getScrollTimeoutTest() {
        assertEquals("Expected and actual values should be the same.", 60000, elasticsearchClientRequestConfiguration.getScrollTimeout());
        elasticsearchClientRequestConfiguration.setScrollTimeout(0);
        assertEquals("Expected and actual values should be the same.", 0, elasticsearchClientRequestConfiguration.getScrollTimeout());
    }
}
