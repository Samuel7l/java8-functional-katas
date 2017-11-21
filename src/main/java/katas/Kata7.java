package katas;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.MovieList;
import util.DataUtil;

/*
 Goal: Retrieve the id, title, and smallest box art url for every video
 DataSource: DataUtil.getMovieLists()
 Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
 */
public class Kata7 {
	public static List<Map> execute() {
		List<MovieList> movieLists = DataUtil.getMovieLists();

		return movieLists.stream().flatMap(m -> m.getVideos().stream())
				.map(m -> ImmutableMap.of("id", m.getId(), "title",
						m.getTitle(), "boxart", getUrlSmallestBoxArt(
								m.getBoxarts())))
				.collect(Collectors.toList());

	}

	public static String getUrlSmallestBoxArt(List<BoxArt> boxArts) {
		Optional<String> urlSmallestBoxArt = boxArts.stream()
				.min((box1, box2) -> Integer.compare(
						box1.getWidth() * box1.getHeight(),
						box2.getWidth() * box2.getHeight()))
				.map(BoxArt::getUrl);

		return urlSmallestBoxArt.isPresent() ? urlSmallestBoxArt.get() : "";
	}
}
