/*
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.dromara.soul.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dromara.soul.admin.entity.PluginDO;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

/**
 * this is plugin view to web front.
 *
 * @author jiangxiaofeng(programgeek @ 163.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PluginVO implements Serializable {

    /**
     * primary key.
     */
    private String id;

    /**
     * plugin name.
     */
    private String name;

    /**
     * whether enabled.
     */
    private Boolean enabled;

    /**
     * created time.
     */
    private String dateCreated;

    /**
     * updated time.
     */
    private String dateUpdated;

    /**
     * build pluginVO.
     *
     * @param pluginDO {@linkplain PluginDO}
     * @return {@linkplain PluginDO}
     */
    public static PluginVO buildPluginVO(final PluginDO pluginDO) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return new PluginVO(pluginDO.getId(), pluginDO.getName(), pluginDO.getEnabled(),
                dateTimeFormatter.format(pluginDO.getDateCreated().toLocalDateTime()),
                dateTimeFormatter.format(pluginDO.getDateUpdated().toLocalDateTime()));
    }
}
