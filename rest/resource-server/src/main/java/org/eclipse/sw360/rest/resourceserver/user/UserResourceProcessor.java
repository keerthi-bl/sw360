/*
 * Copyright Siemens AG, 2017. Part of the SW360 Portal Project.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.sw360.rest.resourceserver.user;

import lombok.RequiredArgsConstructor;
import org.eclipse.sw360.datahandler.thrift.users.User;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@Component
@RequiredArgsConstructor
class UserResourceProcessor implements RepresentationModelProcessor<EntityModel<User>> {

    @Override
    public EntityModel<User> process(EntityModel<User> resource) {
        try {
            User user = resource.getContent();
            Link selfLink = linkTo(UserController.class).slash("api/users/byid/" + user.getId()).withSelfRel();
            resource.add(selfLink);
            return resource;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
