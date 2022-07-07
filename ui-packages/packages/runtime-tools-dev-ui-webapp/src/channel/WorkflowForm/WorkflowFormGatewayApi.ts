/*
 * Copyright 2022 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import { startWorkflowInstance } from '../apis';

export interface WorkflowFormGatewayApi {
  startWorkflow(formData: any): Promise<string>;
  setBusinessKey(bk: string): void;
  getBusinessKey(): string;
}

export class WorkflowFormGatewayApiImpl implements WorkflowFormGatewayApi {
  private businessKey: string;
  private readonly baseUrl: string;

  constructor(baseUrl: string) {
    this.businessKey = '';
    this.baseUrl = baseUrl;
  }

  setBusinessKey(bk: string): void {
    this.businessKey = bk;
  }

  getBusinessKey(): string {
    return this.businessKey;
  }

  startWorkflow(formData: any): Promise<string> {
    return startWorkflowInstance(formData, this.businessKey, this.baseUrl);
  }
}