package katas;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.MovieList;
import util.DataUtil;

/*Goal:Retrieve id,title,and a 150 x200 box art url for every video
 * DataSource:DataUtil.getMovieLists()Output:List of ImmutableMap.of("id","5","title","Bad Boys","boxart":BoxArt)*/

public class Kata4 {

	private static final Integer BOX_HEIGHT = 200;
	private static final Integer BOX_WIDTH = 150;

	public static List<Map> execute() {
		List<MovieList> movieLists = DataUtil.getMovieLists();

		return movieLists.stream().flatMap(m -> m.getVideos().stream())
				.map(movie -> ImmutableMap.of("id", movie.getId(), "title",
						movie.getTitle(), "boxart", movie.getBoxarts().stream()
								.filter(getSizebleBoxArt()).map(BoxArt::getUrl)
								.findFirst().get()))
				.collect(Collectors.toList());

	}

	public static Predicate<BoxArt> getSizebleBoxArt() {
		return boxArt -> BOX_WIDTH.equals(boxArt.getWidth())
				&& BOX_HEIGHT.equals(boxArt.getHeight());
	}
}
