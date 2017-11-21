package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Kata11Test {

	@Test
	public void testExecute() {
		Assert.assertThat(Kata11.execute().size(), equalTo(2));
	}

	@Test
	public void testExecute2() {
		Assert.assertThat(Kata11.execute(), equalTo(ImmutableList.of(
				ImmutableMap.of("name", "New Releases", "videos",
						ImmutableList.of(
								ImmutableMap.of("id", 65432445, "title",
										"The Chamber", "time", 32432, "boxart",
										"http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg"),
								ImmutableMap.of("id", 675465, "title",
										"Fracture", "time", 3534543, "boxart",
										"http://cdn-0.nflximg.com/images/2891/Fracture120.jpg"))),
				ImmutableMap.of("name", "Thrillers", "videos",
						ImmutableList.of(
								ImmutableMap.of("id", 70111470, "title",
										"Die Hard",
										"time", 645243, "boxart",
										"http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"),
								ImmutableMap.of("id", 654356453, "title",
										"Bad Boys", "time", 984934, "boxart",
										"http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg"))))));
	}
}
