package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Kata4Test {

	@Test
	public void testExecute() {
		Assert.assertThat(Kata4.execute().size(), equalTo(4));
	}

	@Test
	public void testExecute2() {

		Assert.assertEquals(Kata4.execute(), ImmutableList.of(
				ImmutableMap.of("id", 70111470, "title", "Die Hard", "boxart",
						"http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"),
				ImmutableMap.of("id", 654356453, "title", "Bad Boys", "boxart",
						"http://cdn-0.nflximg.com/images/2891/BadBoys150.jpg"),
				ImmutableMap.of("id", 65432445, "title", "The Chamber",
						"boxart",
						"http://cdn-0.nflximg.com/images/2891/TheChamber150.jpg"),
				ImmutableMap.of("id", 675465, "title", "Fracture", "boxart",
						"http://cdn-0.nflximg.com/images/2891/Fracture150.jpg")));

	}
}
