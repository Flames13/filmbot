package bot;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVWriter;

public class User {
	public String Name;
	private ArrayList<Film> savedFilms;

	public User(String name) {
		Name = name;
		savedFilms = new ArrayList<Film>();
	}

	public void createUserInfo() throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(Name + ".csv", true));
		writer.close();
	}

	public void addInfo() throws IOException {

		CSVWriter writer = new CSVWriter(new FileWriter(Name + ".csv", true));
		for (Film film : savedFilms) {
			String[] record = { film.getTitle(), film.getCountry(), film.getYear().toString() };
			writer.writeNext(record);
		}
		writer.close();
	}

	public void ReadInfo() throws Exception {

		List<String[]> allRows = ParserCSV.extractData(Name + ".csv");
		ParserCSV parser = new ParserCSV(Name + ".csv");
		savedFilms = parser.filmList;
	}

	public void addFilm(Film film) {
		String filmName = film.getTitle();
		savedFilms.add(film);
	}

}
