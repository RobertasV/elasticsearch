/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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
package org.elasticsearch.search.aggregations.bucket;

import org.elasticsearch.search.aggregations.Aggregator;
import org.elasticsearch.search.aggregations.support.AggregationContext;
import org.elasticsearch.search.aggregations.AggregatorFactories;

/**
 * A bucket aggregator that doesn't create new buckets.
 */
public abstract class SingleBucketAggregator extends BucketsAggregator {

    protected SingleBucketAggregator(String name, AggregatorFactories factories,
                                     AggregationContext aggregationContext, Aggregator parent) {
        super(name, BucketAggregationMode.MULTI_BUCKETS, factories, parent == null ? 1 : parent.estimatedBucketCount(), aggregationContext, parent);
    }

    @Override
    public boolean shouldCollect() {
        return true;
    }

}
