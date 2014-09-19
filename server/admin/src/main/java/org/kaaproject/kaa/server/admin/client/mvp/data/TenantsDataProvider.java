/*
 * Copyright 2014 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaaproject.kaa.server.admin.client.mvp.data;

import java.util.List;

import org.kaaproject.kaa.common.dto.admin.TenantUserDto;
import org.kaaproject.kaa.server.admin.client.KaaAdmin;
import org.kaaproject.kaa.server.admin.client.mvp.activity.grid.AbstractDataProvider;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;

public class TenantsDataProvider extends AbstractDataProvider<TenantUserDto>{

    public TenantsDataProvider(MultiSelectionModel<TenantUserDto> selectionModel,
                                    AsyncCallback<List<TenantUserDto>> asyncCallback) {
        super(selectionModel, asyncCallback);
    }

    @Override
    protected void loadData(final LoadCallback callback, final HasData<TenantUserDto> display) {
        KaaAdmin.getDataSource().loadTenants(new AsyncCallback<List<TenantUserDto>>() {
            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);

            }
            @Override
            public void onSuccess(List<TenantUserDto> result) {
                callback.onSuccess(result, display);
            }
        });
    }

}