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
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.omnaest.usda.duke.domain.Activity;
import org.omnaest.usda.duke.domain.Chemical;
import org.omnaest.usda.duke.domain.Disease;
import org.omnaest.usda.duke.domain.raw.Aggregac;
import org.omnaest.usda.duke.domain.raw.Ethnobot;
import org.omnaest.usda.duke.domain.raw.SuperAct;
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

		public Stream<Disease> getDiseases();
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

				Map<String, Set<String>> activityToChemicalsMap = aggregacs	.stream()
																			.collect(Collectors.groupingBy(entry -> entry.getActivity()))
																			.entrySet()
																			.stream()
																			.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry	.getValue()
																																				.stream()
																																				.map(aggregac -> aggregac.getChemical())
																																				.collect(Collectors.toSet())));

				Map<String, Set<String>> chemicalToActivitiesMap = aggregacs.stream()
																			.collect(Collectors.groupingBy(entry -> entry.getChemical()))
																			.entrySet()
																			.stream()
																			.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry	.getValue()
																																				.stream()
																																				.map(aggregac -> aggregac.getActivity())
																																				.collect(Collectors.toSet())));

				List<SuperAct> superacts = CSVUtils	.parse(new File(folder, "SUPERACT.csv"))
													.map(map -> JSONHelper.toObjectWithType(map, SuperAct.class))
													.collect(Collectors.toList());

				List<Ethnobot> ethnobots = CSVUtils	.parse(new File(folder, "ETHNOBOT.csv"))
													.map(map -> JSONHelper.toObjectWithType(map, Ethnobot.class))
													.collect(Collectors.toList());

				return new USDADukeContent()
				{
					@Override
					public Stream<Chemical> getChemicals()
					{

						return chemicalToActivitiesMap	.entrySet()
														.stream()
														.map(entry -> this.createChemical(entry.getKey()));
					}

					private Chemical createChemical(String name)
					{
						return new Chemical()
						{
							@Override
							public String getName()
							{
								return name;
							}

							@Override
							public List<Activity> getActivities()
							{
								return chemicalToActivitiesMap	.get(name)
																.stream()
																.map(name -> createActivity(name))
																.collect(Collectors.toList());
							}
						};
					}

					private Activity createActivity(String name)
					{
						return new Activity()
						{

							@Override
							public String getName()
							{
								return name;
							}

							@Override
							public Stream<Chemical> getChemicals()
							{
								return activityToChemicalsMap	.get(name)
																.stream()
																.map(name -> createChemical(name));
							}
						};
					}

					@Override
					public Stream<Disease> getDiseases()
					{
						Map<String, List<SuperAct>> diseaseNameToSuperActsMap = superacts	.stream()
																							.map(map -> JSONHelper.toObjectWithType(map, SuperAct.class))
																							.collect(Collectors.groupingBy(superAct -> superAct.getSuperActivity()));
						return diseaseNameToSuperActsMap.entrySet()
														.stream()
														.map(entry -> (Disease) new Disease()
														{

															@Override
															public String getName()
															{
																return entry.getKey();
															}

															@Override
															public Stream<Activity> getActivities()
															{
																return entry.getValue()
																			.stream()
																			.map(superAct -> createActivity(superAct.getActivity()));
															}
														});
					}
				};
			}
		};
	}
}
