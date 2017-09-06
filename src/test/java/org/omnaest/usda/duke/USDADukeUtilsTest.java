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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.omnaest.usda.duke.domain.Chemical;

public class USDADukeUtilsTest
{

	@Test
	public void testGetInstance() throws Exception
	{
		List<Chemical> chemicals = USDADukeUtils.getInstance()
												.loadFromFolder(new File("data"))
												.getChemicals()
												.collect(Collectors.toList());

		List<String> queries = Arrays.asList("Calcium-Channel-Blocker", "5-HT", "Muscarinic", "angina", "parkinson", "irritable bowel");

		queries.forEach(query ->
		{
			System.out.println("-------------------------------------------");
			System.out.println(query);
			chemicals	.stream()
						.filter(chemical -> chemical.getActivities()
													.stream()
													.anyMatch(activity -> StringUtils.containsIgnoreCase(activity, query)))
						.forEach(chemical ->
						{
							System.out.print(chemical.getName());
							System.out.println("->" + chemical.getActivities());
						});
		});
	}

}
