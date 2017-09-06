/*

	Copyright 2017 Danny Kunz

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.


*/
package org.omnaest.usda.duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.omnaest.usda.duke.domain.Chemical;
import org.omnaest.usda.duke.domain.raw.Aggregac;
import org.omnaest.utils.JSONHelper;
import org.omnaest.utils.csv.CSVUtils;

public class USDADukeUtils
{

	public static interface USDADukeContentLoader
	{
		public USDADukeContent loadFromFolder(File folder) throws FileNotFoundException, IOException;
	}

	public static interface USDADukeContent
	{
		public Stream<Chemical> getChemicals();
	}

	public static USDADukeContentLoader getInstance()
	{
		return new USDADukeContentLoader()
		{
			@Override
			public USDADukeContent loadFromFolder(File folder) throws FileNotFoundException, IOException
			{
				List<Aggregac> aggregacs = CSVUtils	.parse(new File(folder, "AGGREGAC.csv"))
													.map(map -> JSONHelper.toObjectWithType(map, Aggregac.class))
													.collect(Collectors.toList());

				return new USDADukeContent()
				{
					@Override
					public Stream<Chemical> getChemicals()
					{
						Map<String, List<Aggregac>> chemicalToAggregacsMap = aggregacs	.stream()
																						.collect(Collectors.groupingBy(entry -> entry.getChemical()));
						return chemicalToAggregacsMap	.entrySet()
														.stream()
														.map(entry -> (Chemical) new Chemical()
														{

															@Override
															public String getName()
															{
																return entry.getKey();
															}

															@Override
															public List<String> getActivities()
															{
																return entry.getValue()
																			.stream()
																			.map(agg -> agg.getActivity())
																			.collect(Collectors.toList());
															}
														});
					}
				};
			}
		};
	}
}
