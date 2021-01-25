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
package org.eclipse.kapua.service.elasticsearch.client.model;

import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.List;

@Category(JUnitTests.class)
public class BulkUpdateResponseTest extends Assert {

    BulkUpdateResponse bulkUpdateResponse;

    @Before
    public void setUp() {
        bulkUpdateResponse = new BulkUpdateResponse();
    }

    @Test
    public void addTest() {
        List<UpdateResponse> requestList = bulkUpdateResponse.getResponse();
        assertEquals("Expected and actual values should be the same.", new ArrayList<>(), requestList);
        UpdateResponse updateResponse = new UpdateResponse("Id", new TypeDescriptor("Index", "Type"));
        bulkUpdateResponse.add(updateResponse);
        assertEquals("Expected and actual values should be the same.", updateResponse, requestList.get(0));

    }

    @Test
    public void getResponseTest() {
        bulkUpdateResponse.setResponse(null);
        assertEquals("Expected and actual values should be the same.", new ArrayList<>(), bulkUpdateResponse.getResponse());
        List<UpdateResponse> requestList = new ArrayList<>();
        bulkUpdateResponse.setResponse(requestList);
    }

}
