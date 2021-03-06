/*
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
package io.prestosql.operator.aggregation.state;

import io.airlift.stats.TDigest;
import io.prestosql.spi.function.AccumulatorState;
import io.prestosql.spi.function.AccumulatorStateMetadata;

import java.util.List;

@AccumulatorStateMetadata(stateSerializerClass = TDigestAndPercentileArrayStateSerializer.class, stateFactoryClass = TDigestAndPercentileArrayStateFactory.class)
public interface TDigestAndPercentileArrayState
        extends AccumulatorState
{
    TDigest getDigest();

    void setDigest(TDigest digest);

    void setPercentiles(List<Double> percentiles);

    List<Double> getPercentiles();

    void addMemoryUsage(int value);
}
