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
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JUnitTests.class)
public class InsertResponseTest extends Assert {

    @Test
    public void constructorTest() {
        InsertResponse insertResponse = new InsertResponse("Id", new TypeDescriptor("Index", "Type"));
        assertEquals("Expected and actual values should be the same.", "Id", insertResponse.getId());
        assertEquals("Expected and actual values should be the same.", "Index", insertResponse.getTypeDescriptor().getIndex());
        assertEquals("Expected and actual values should be the same.", "Type", insertResponse.getTypeDescriptor().getType());
    }
}
