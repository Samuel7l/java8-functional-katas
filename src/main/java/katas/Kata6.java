package katas;

import java.util.List;
import java.util.Optional;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

/*
 Goal: Retrieve the url of the largest boxart using map() and reduce()
 DataSource: DataUtil.getMovieLists()
 Output: String
 */
public class Kata6 {
	public static String execute() {
		List<Movie> movies = DataUtil.getMovies();

		return movies.stream().flatMap(m -> m.getBoxarts().stream()).filter(
				m -> (m.getHeight() * m.getWidth()) == getLargestBoxArt(movies))
				.map(BoxArt::getUrl).findAny().orElse("");
	}

	private static Integer getLargestBoxArt(List<Movie> movies) {
		Optional<Integer> largestBoxArt = movies.stream()
				.flatMap(m -> m.getBoxarts().stream())
				.map(m -> m.getHeight() * m.getWidth()).reduce(Integer::max);

		return largestBoxArt.isPresent() ? largestBoxArt.get() : 0;
	}

}
