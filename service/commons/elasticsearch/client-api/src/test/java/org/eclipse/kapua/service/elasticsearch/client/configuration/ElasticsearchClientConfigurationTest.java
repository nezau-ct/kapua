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
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.List;

@Category(JUnitTests.class)
public class ElasticsearchClientConfigurationTest extends Assert {

    ElasticsearchClientConfiguration elasticsearchClientConfiguration;
    List<ElasticsearchNode> elasticsearchNodes;
    ElasticsearchClientReconnectConfiguration elasticsearchClientReconnectConfiguration;
    ElasticsearchClientRequestConfiguration elasticsearchClientRequestConfiguration;
    ElasticsearchClientSslConfiguration elasticsearchClientSslConfiguration;
    ElasticsearchNode elasticsearchNode;

    @Before
    public void setUp() {
        elasticsearchClientConfiguration = new ElasticsearchClientConfiguration();
        elasticsearchNodes = new ArrayList<>();
        elasticsearchClientReconnectConfiguration = new ElasticsearchClientReconnectConfiguration();
        elasticsearchClientRequestConfiguration = new ElasticsearchClientRequestConfiguration();
        elasticsearchClientSslConfiguration = new ElasticsearchClientSslConfiguration();
        elasticsearchNode = new ElasticsearchNode("Address", 1);
    }

    @Test
    public void getModuleNameTest() {
        assertNull("Null expected!", elasticsearchClientConfiguration.getModuleName());
        elasticsearchClientConfiguration.setModuleName(("Module"));
        assertEquals("Expected and actual values should be the same.", "Module", elasticsearchClientConfiguration.getModuleName());
        elasticsearchClientConfiguration.setModuleName((null));
        assertNull("Null expected!", elasticsearchClientConfiguration.getModuleName());
    }

    @Test
    public void getProviderClassNameTest() {
        assertNull("Null expected!", elasticsearchClientConfiguration.getProviderClassName());
        elasticsearchClientConfiguration.setProviderClassName(("Provider Class"));
        assertEquals("Expected and actual values should be the same.", "Provider Class", elasticsearchClientConfiguration.getProviderClassName());
        elasticsearchClientConfiguration.setProviderClassName((null));
        assertNull("Null expected!", elasticsearchClientConfiguration.getProviderClassName());
    }

    @Test
    public void getClusterNameTest() {
        assertNull("Null expected!", elasticsearchClientConfiguration.getClusterName());
        elasticsearchClientConfiguration.setClusterName(("Cluster"));
        assertEquals("Expected and actual values should be the same.", "Cluster", elasticsearchClientConfiguration.getClusterName());
        elasticsearchClientConfiguration.setClusterName((null));
        assertNull("Null expected!", elasticsearchClientConfiguration.getClusterName());
    }

    /*TO DO*/
    @Test
    public void getAndAddNodesTest() {
        elasticsearchClientConfiguration.setNodes(null);
        assertEquals("Empty list expected.", elasticsearchNodes, elasticsearchClientConfiguration.getNodes());
//        assertFalse("False expected.", elasticsearchNodes.contains(elasticsearchNode));
        elasticsearchClientConfiguration.setNodes(elasticsearchNodes);
        assertEquals("Empty list expected.", elasticsearchNodes, elasticsearchClientConfiguration.getNodes());
        elasticsearchClientConfiguration.addNode("Address", 1);
        /*DOESN'T WORK RIGHT*/
        assertEquals("True expected.", new ElasticsearchNode("Address", 1), elasticsearchClientConfiguration.getNodes().get(0));
    }

    @Test
    public void getUsernameTest() {
        assertNull("Null expected!", elasticsearchClientConfiguration.getUsername());
        elasticsearchClientConfiguration.setUsername(("Username"));
        assertEquals("Expected and actual values should be the same.", "Username", elasticsearchClientConfiguration.getUsername());
        elasticsearchClientConfiguration.setUsername((null));
        assertNull("Null expected!", elasticsearchClientConfiguration.getUsername());
    }

    @Test
    public void getPasswordTest() {
        assertNull("Null expected!", elasticsearchClientConfiguration.getPassword());
        elasticsearchClientConfiguration.setPassword(("Password"));
        assertEquals("Expected and actual values should be the same.", "Password", elasticsearchClientConfiguration.getPassword());
        elasticsearchClientConfiguration.setPassword((null));
        assertNull("Null expected!", elasticsearchClientConfiguration.getPassword());
    }

    @Test
    public void getReconnectConfigurationTest() {
        elasticsearchClientConfiguration.setReconnectConfiguration(elasticsearchClientReconnectConfiguration);
        assertThat("Instance of ElasticsearchClientReconnectConfiguration.", elasticsearchClientConfiguration.getReconnectConfiguration(), IsInstanceOf.instanceOf(ElasticsearchClientReconnectConfiguration.class));
    }

    @Test
    public void getReconnectConfigurationNullTest() {
        elasticsearchClientConfiguration.setReconnectConfiguration(null);
        assertThat("Instance of ElasticsearchClientReconnectConfiguration.", elasticsearchClientConfiguration.getReconnectConfiguration(), IsInstanceOf.instanceOf(ElasticsearchClientReconnectConfiguration.class));
    }

    @Test
    public void getRequestConfigurationTest() {
        elasticsearchClientConfiguration.setRequestConfiguration(elasticsearchClientRequestConfiguration);
        assertThat("Instance of ElasticsearchClientRequestConfiguration.", elasticsearchClientConfiguration.getRequestConfiguration(), IsInstanceOf.instanceOf(ElasticsearchClientRequestConfiguration.class));
    }

    @Test
    public void getRequestConfigurationNullTest() {
        elasticsearchClientConfiguration.setRequestConfiguration(null);
        assertThat("Instance of ElasticsearchClientRequestConfiguration.", elasticsearchClientConfiguration.getRequestConfiguration(), IsInstanceOf.instanceOf(ElasticsearchClientRequestConfiguration.class));
    }

    @Test
    public void getSslConfigurationTest() {
        elasticsearchClientConfiguration.setSslConfiguration(elasticsearchClientSslConfiguration);
        assertThat("Instance of ElasticsearchClientSslConfiguration.", elasticsearchClientConfiguration.getSslConfiguration(), IsInstanceOf.instanceOf(ElasticsearchClientSslConfiguration.class));
    }

    @Test
    public void getSslConfigurationNullTest() {
        elasticsearchClientConfiguration.setSslConfiguration(null);
        assertThat("Instance of ElasticsearchClientSslConfiguration.", elasticsearchClientConfiguration.getSslConfiguration(), IsInstanceOf.instanceOf(ElasticsearchClientSslConfiguration.class));
    }
}