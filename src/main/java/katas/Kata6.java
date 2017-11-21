package katas;

import java.util.List;

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

		Integer largest = movies.stream().flatMap(m -> m.getBoxarts().stream()).map(m -> m.getHeight() * m.getWidth()).reduce(Integer::max).get();

		return movies.stream().flatMap(m -> m.getBoxarts().stream()).filter(m -> (m.getHeight() * m.getWidth()) == largest).map(m -> m.getUrl()).findAny().get();
	}

}
