/*
 * Copyright 2016 The Johns Hopkins University Applied Physics Laboratory LLC
 * All rights reserved.
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
package edu.jhuapl.dorset.filters;

import edu.jhuapl.dorset.Request;

/**
 * Dorset Request Filter
 *
 * A RequestFilter alters the Request object before it is sent to the router.
 * An example of a RequestFilter is removing a wake-up word from the request text.
 */
public interface RequestFilter {

    /**
     * Filter the request object
     *
     * @param request  current request object
     * @return filtered request object
     */
    public Request filter(Request request);

}
