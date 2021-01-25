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
public class BulkUpdateRequestTest extends Assert {

    BulkUpdateRequest bulkUpdateRequest;

    @Before
    public void setUp() {
        bulkUpdateRequest = new BulkUpdateRequest();
    }

    @Test
    public void addTest() {
        List<UpdateRequest> requestList = bulkUpdateRequest.getRequest();
        assertEquals("Expected and actual values should be the same.", new ArrayList<>(), requestList);
        UpdateRequest updateRequest = new UpdateRequest("Id", new TypeDescriptor("Index", "Type"), new Object());
        bulkUpdateRequest.add(updateRequest);
        assertEquals("Expected and actual values should be the same.", updateRequest, requestList.get(0));

    }

    @Test
    public void getRequestTest() {
        assertEquals("Expected and actual values should be the same.", new ArrayList<>(), bulkUpdateRequest.getRequest());
        List<UpdateRequest> requestList = new ArrayList<>();
        bulkUpdateRequest.setRequest(requestList);
    }
}
