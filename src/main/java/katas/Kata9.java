package katas;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.InterestingMoment;
import model.Movie;
import util.DataUtil;

/*
 Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
 DataSource: DataUtil.getMovies()
 Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
 */
public class Kata9 {
	public static List<Map> execute() {
		List<Movie> movies = DataUtil.getMovies();

		return movies.stream()
				.map(movie -> ImmutableMap.of("id", movie.getId(), "title",
						movie.getTitle(), "time",
						getMiddleMoment(movie.getInterestingMoments()), "url",
						getUrlSmallestBoxArt(movie.getBoxarts())))
				.collect(Collectors.toList());
	}

	public static Date getMiddleMoment(List<InterestingMoment> moments) {
		Optional<Date> middleMoment = moments.stream()
				.filter(moment -> "Middle".equals(moment.getType()))
				.map(InterestingMoment::getTime).findFirst();

		return middleMoment.isPresent() ? middleMoment.get() : null;
	}

	public static String getUrlSmallestBoxArt(List<BoxArt> boxArts) {
		Optional<String> urlBoxArt = boxArts.stream()
				.min((box1, box2) -> Integer.compare(
						box1.getWidth() * box1.getHeight(),
						box2.getWidth() * box2.getHeight()))
				.map(BoxArt::getUrl);

		return urlBoxArt.isPresent() ? urlBoxArt.get() : "";
	}
}
