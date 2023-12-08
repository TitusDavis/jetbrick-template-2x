/**
 * Copyright 2013-2019 Guoqiang Chen, Shanghai, China. All rights reserved.
 *
 *   Author: Guoqiang Chen
 *    Email: subchen@gmail.com
 *   WebURL: https://github.com/subchen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrick.template.resolver.property;

import jetbrick.bean.MethodInfo;
import jetbrick.bean.PropertyInfo;
import jetbrick.template.JetSecurityManager;
import jetbrick.util.ArrayUtils;

/**
 * 访问 object.name
 */
final class PropertyGetter implements Getter {
    private final MethodInfo getter;

    public PropertyGetter(PropertyInfo property) {
        this.getter = property.getGetter();
    }

    @Override
    public void checkAccess(JetSecurityManager securityManager) {
        securityManager.checkAccess(getter.getMethod());
    }

    @Override
    public Object get(Object object) {
        return getter.invoke(object, ArrayUtils.EMPTY_OBJECT_ARRAY);
    }
}