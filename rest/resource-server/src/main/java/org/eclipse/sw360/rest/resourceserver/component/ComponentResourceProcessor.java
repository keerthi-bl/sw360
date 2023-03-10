/*
 * Copyright Siemens AG, 2017. Part of the SW360 Portal Project.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.sw360.rest.resourceserver.component;

import lombok.RequiredArgsConstructor;
import org.eclipse.sw360.datahandler.thrift.components.Component;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@org.springframework.stereotype.Component
@RequiredArgsConstructor
class ComponentResourceProcessor implements RepresentationModelProcessor<EntityModel<Component>> {

    @Override
    public EntityModel<Component> process(EntityModel<Component> resource) {
        Component component = resource.getContent();
        Link selfLink = linkTo(ComponentController.class)
                .slash("api" + ComponentController.COMPONENTS_URL + "/" + component.getId()).withSelfRel();
        resource.add(selfLink);
        return resource;
    }
}
