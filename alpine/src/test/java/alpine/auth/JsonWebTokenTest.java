/*
 * This file is part of Alpine.
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
 *
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (c) Steve Springett. All Rights Reserved.
 */
package alpine.auth;

import alpine.model.Permission;
import org.junit.Assert;
import org.junit.Test;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JsonWebTokenTest {

    @Test
    public void createTokenTest() {
        Principal user = mock(Principal.class);
        when(user.getName()).thenReturn("admin");
        JsonWebToken jwt = new JsonWebToken();
        String token = jwt.createToken(user);
        Assert.assertNotNull(token);
        Assert.assertTrue(jwt.validateToken(token));
        Assert.assertEquals("admin", jwt.getSubject());
        Assert.assertNotNull(jwt.getExpiration());
    }

    @Test
    public void createTokenPermissionsTest() {
        List<Permission> permissions = new ArrayList<>();
        Permission p1 = mock(Permission.class);
        when(p1.getName()).thenReturn("PERM-1");
        Permission p2 = mock(Permission.class);
        when(p2.getName()).thenReturn("PERM-2");
        permissions.add(p1);
        permissions.add(p2);
        Principal user = mock(Principal.class);
        when(user.getName()).thenReturn("admin");
        JsonWebToken jwt = new JsonWebToken();
        String token = jwt.createToken(user, permissions);
        Assert.assertNotNull(token);
        Assert.assertTrue(jwt.validateToken(token));
        Assert.assertEquals("admin", jwt.getSubject());
        Assert.assertNotNull(jwt.getExpiration());
    }
}
