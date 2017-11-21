package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.MovieList;
import util.DataUtil;

/*Goal:Retrieve id,title,and a 150 x200 box art url for every video
 * DataSource:DataUtil.getMovieLists()Output:List of ImmutableMap.of("id","5","title","Bad Boys","boxart":BoxArt)*/

public class Kata4 {

	public static final Integer BOX_HEIGHT = 150;
	public static final Integer BOX_WIDTH = 200;
	public static final String URL = "http://www.google.com.br";

	public static List<Map> execute() {
		List<MovieList> movieLists = DataUtil.getMovieLists();

		return movieLists.stream().flatMap(m -> m.getVideos().stream()).map(movie -> ImmutableMap.of("id", movie.getId(), "title", movie.getTitle(), "boxart", movie.getBoxarts())).collect(Collectors.toList());

		// BOX_HEIGHT,BOX_WIDTH,URL
		// return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", new BoxArt(150, 200, "url")));
	}
}
