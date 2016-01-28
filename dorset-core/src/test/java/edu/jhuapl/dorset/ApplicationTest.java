/**
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
package edu.jhuapl.dorset;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import edu.jhuapl.dorset.agent.Agent;
import edu.jhuapl.dorset.agent.AgentRequest;
import edu.jhuapl.dorset.agent.AgentResponse;
import edu.jhuapl.dorset.routing.Router;

public class ApplicationTest {
    @Test
    public void testProcessWithNoAgents() {
        Request request = new Request("test");
        Router router = mock(Router.class);
        when(router.getAgents(request)).thenReturn(new Agent[0]);
        Application app = new Application(null, router);

        Response response = app.process(request);

        assertEquals("no response", response.text);
    }

    @Test
    public void testProcessWithAgentWithResponse() {
        Request request = new Request("test");
        Agent agent = mock(Agent.class);
        when(agent.process((AgentRequest)anyObject())).thenReturn(new AgentResponse("the answer"));

        Agent rtn[] = new Agent[1];
        rtn[0] = agent;
        Router router = mock(Router.class);
        when(router.getAgents(request)).thenReturn(rtn);
        Application app = new Application(null, router);

        Response response = app.process(request);

        assertEquals("the answer", response.text);
        verify(router, times(1)).initialize(null);
    }

    @Test
    public void testProcessWithAgentWithNoResponse() {
        Request request = new Request("test");
        Agent agent = mock(Agent.class);
        when(agent.process((AgentRequest)anyObject())).thenReturn(null);

        Agent rtn[] = new Agent[1];
        rtn[0] = agent;
        Router router = mock(Router.class);
        when(router.getAgents(request)).thenReturn(rtn);
        Application app = new Application(null, router);

        Response response = app.process(request);

        assertEquals("no response", response.text);
    }

}