/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.action.search;

import org.elasticsearch.common.io.Streams;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

/**
 */
public class MultiSearchRequestTests {

    @Test
    public void simpleAdd() throws Exception {
        byte[] data = Streams.copyToBytesFromClasspath("/org/elasticsearch/action/search/simple-msearch1.json");
        MultiSearchRequest request = new MultiSearchRequest().add(data, 0, data.length, false, null, null, null);
        assertThat(request.requests().size(), equalTo(5));
        assertThat(request.requests().get(0).indices()[0], equalTo("test"));
        assertThat(request.requests().get(0).types().length, equalTo(0));
        assertThat(request.requests().get(1).indices()[0], equalTo("test"));
        assertThat(request.requests().get(1).types()[0], equalTo("type1"));
        assertThat(request.requests().get(2).indices(), nullValue());
        assertThat(request.requests().get(2).types().length, equalTo(0));
        assertThat(request.requests().get(3).indices(), nullValue());
        assertThat(request.requests().get(3).types().length, equalTo(0));
        assertThat(request.requests().get(3).searchType(), equalTo(SearchType.COUNT));
        assertThat(request.requests().get(4).indices(), nullValue());
        assertThat(request.requests().get(4).types().length, equalTo(0));
    }

    @Test
    public void simpleAdd2() throws Exception {
        byte[] data = Streams.copyToBytesFromClasspath("/org/elasticsearch/action/search/simple-msearch2.json");
        MultiSearchRequest request = new MultiSearchRequest().add(data, 0, data.length, false, null, null, null);
        assertThat(request.requests().size(), equalTo(5));
        assertThat(request.requests().get(0).indices()[0], equalTo("test"));
        assertThat(request.requests().get(0).types().length, equalTo(0));
        assertThat(request.requests().get(1).indices()[0], equalTo("test"));
        assertThat(request.requests().get(1).types()[0], equalTo("type1"));
        assertThat(request.requests().get(2).indices(), nullValue());
        assertThat(request.requests().get(2).types().length, equalTo(0));
        assertThat(request.requests().get(3).indices(), nullValue());
        assertThat(request.requests().get(3).types().length, equalTo(0));
        assertThat(request.requests().get(3).searchType(), equalTo(SearchType.COUNT));
        assertThat(request.requests().get(4).indices(), nullValue());
        assertThat(request.requests().get(4).types().length, equalTo(0));
    }
    
    @Test
    public void simpleAdd3() throws Exception {
        byte[] data = Streams.copyToBytesFromClasspath("/org/elasticsearch/action/search/simple-msearch3.json");
        MultiSearchRequest request = new MultiSearchRequest().add(data, 0, data.length, false, null, null, null);
        assertThat(request.requests().size(), equalTo(4));
        assertThat(request.requests().get(0).indices()[0], equalTo("test0"));
        assertThat(request.requests().get(0).indices()[1], equalTo("test1"));
        assertThat(request.requests().get(1).indices()[0], equalTo("test2"));
        assertThat(request.requests().get(1).indices()[1], equalTo("test3"));
        assertThat(request.requests().get(1).types()[0], equalTo("type1"));
        assertThat(request.requests().get(2).indices()[0], equalTo("test4"));
        assertThat(request.requests().get(2).indices()[1], equalTo("test1"));
        assertThat(request.requests().get(2).types()[0], equalTo("type2"));
        assertThat(request.requests().get(2).types()[1], equalTo("type1"));
        assertThat(request.requests().get(3).indices(), nullValue());
        assertThat(request.requests().get(3).types().length, equalTo(0));
        assertThat(request.requests().get(3).searchType(), equalTo(SearchType.COUNT));
    }
}
