/*
 * Copyright Siemens AG, 2017. Part of the SW360 Portal Project.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.sw360.rest.resourceserver.release;

import lombok.RequiredArgsConstructor;
import org.eclipse.sw360.datahandler.thrift.components.Release;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
@RequiredArgsConstructor
class ReleaseResourceProcessor implements RepresentationModelProcessor<EntityModel<Release>> {

    @Override
    public EntityModel<Release> process(EntityModel<Release> resource) {
        Release release = resource.getContent();
        Link selfLink = linkTo(ReleaseController.class)
                .slash("api" + ReleaseController.RELEASES_URL + "/" + release.getId()).withSelfRel();
        resource.add(selfLink);
        return resource;
    }
}
