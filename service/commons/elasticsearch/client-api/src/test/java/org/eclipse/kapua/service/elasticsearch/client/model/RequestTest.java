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

@Category(JUnitTests.class)
public class RequestTest extends Assert {

    private class ActualRequest extends Request {

        protected ActualRequest(String id, TypeDescriptor typeDescriptor, Object storable) {
            super(id, typeDescriptor, storable);
        }
    }

    Request request;
    Object object;

    @Before
    public void setUp() {
        object = new Object();
        request = new RequestTest.ActualRequest("Id", new TypeDescriptor("Index", "Type"), object);
    }

    @Test
    public void constructorTest() {
        assertEquals("Expected and actual values should be the same.", "Id", request.getId());
        assertEquals("Expected and actual values should be the same.", "Index", request.getTypeDescriptor().getIndex());
        assertEquals("Expected and actual values should be the same.", "Type", request.getTypeDescriptor().getType());
        assertEquals("Expected and actual values should be the same.", object, request.getStorable());
    }

    @Test
    public void getIdTest() {
        assertEquals("Expected and actual values should be the same.", "Id", request.getId());
        request.setId("New ID");
        assertEquals("Expected and actual values should be the same.", "New ID", request.getId());
    }

    @Test
    public void getTypeDescriptorTest() {
        assertEquals("Expected and actual values should be the same.", "Index", request.getTypeDescriptor().getIndex());
        assertEquals("Expected and actual values should be the same.", "Type", request.getTypeDescriptor().getType());
        request.setTypeDescriptor(new TypeDescriptor("New Index", "New Type"));
        assertEquals("Expected and actual values should be the same.", "New Index", request.getTypeDescriptor().getIndex());
        assertEquals("Expected and actual values should be the same.", "New Type", request.getTypeDescriptor().getType());
    }

    @Test
    public void getStorableTest() {
        assertEquals("Expected and actual values should be the same.", object, request.getStorable());
        object = "NotEmptyObject";
        request.setStorable(object);
        assertEquals("Expected and actual values should be the same.", object, request.getStorable());
    }

}
