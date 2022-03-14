/*
 * Copyright 2022 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kie.kogito.persistence.reporting.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseField implements Field {

    public static final String FIELD_NAME_FIELD = "fieldName";

    @JsonProperty(FIELD_NAME_FIELD)
    String fieldName;

    protected BaseField() {
    }

    protected BaseField(final String fieldName) {
        this.fieldName = Objects.requireNonNull(fieldName);
    }

    @Override
    public String getFieldName() {
        return fieldName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseField mapping = (BaseField) o;
        return fieldName.equals(mapping.fieldName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName);
    }
}