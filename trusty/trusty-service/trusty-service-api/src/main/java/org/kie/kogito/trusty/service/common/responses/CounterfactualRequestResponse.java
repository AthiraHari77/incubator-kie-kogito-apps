/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
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
package org.kie.kogito.trusty.service.common.responses;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CounterfactualRequestResponse {

    public static final String EXECUTION_ID_FIELD = "executionId";
    public static final String COUNTERFACTUAL_ID_FIELD = "counterfactualId";

    @JsonProperty(EXECUTION_ID_FIELD)
    @NotNull(message = "executionId must be provided.")
    private String executionId;

    @JsonProperty(COUNTERFACTUAL_ID_FIELD)
    @NotNull(message = "counterfactualId must be provided.")
    private String counterfactualId;

    public CounterfactualRequestResponse() {
    }

    public CounterfactualRequestResponse(@NotNull String executionId,
            @NotNull String counterfactualId) {
        this.executionId = Objects.requireNonNull(executionId);
        this.counterfactualId = Objects.requireNonNull(counterfactualId);
    }

    public String getExecutionId() {
        return executionId;
    }

    public String getCounterfactualId() {
        return counterfactualId;
    }

}