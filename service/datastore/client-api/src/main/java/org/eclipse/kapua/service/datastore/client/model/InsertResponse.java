/*******************************************************************************
 * Copyright (c) 2017 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.service.datastore.client.model;

/**
 * Insert response
 *
 * @since 1.0
 */
public class InsertResponse extends Response {

    /**
     * Default constructor
     * 
     * @param id
     *            the inserted record id
     * @param typeDescriptor
     *            index/type descriptor
     */
    public InsertResponse(String id, TypeDescriptor typeDescriptor) {
        super(id, typeDescriptor);
    }

}
