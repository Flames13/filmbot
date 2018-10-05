package bot;

import java.util.ArrayList;
import java.util.Map;

public class Dialog {

	private String year = null;
	private String country = null;

	private String currentOpt = null;

	private ChatBot chatBot;
	private User user;

	public Dialog(ChatBot chatBot, User user) {
		this.chatBot = chatBot;
		this.user = user;
	}

	public String startDialog() {
		if (user.firstTime)
			return String.format("Добро пожаловать, %s.\n%s", user.name, Phrases.HELP);
		return String.format("Давно не виделись, %s.", user.name);
	}

	public String processInput(String input) {
		if (input.equals("/help"))
			return Phrases.HELP;

		if (input.equals("/next"))
			return tryGetNextFilm();

		if (input.length() < 3)
			return Phrases.SHORT_COMMAND;

		String command = input.substring(0, 3);
		String request = input.substring(3).trim();
		switch (command) {
		case "/y ":
			return getNextYear(request);

		case "/c ":
			return getNextCountry(request);

		default:
			return Phrases.UNKNOWN_COMMAND;
		}
	}

	private String getNextYear(String sYear) {
		try {
			Integer.parseInt(sYear);
		} catch (NumberFormatException e) {
			return Phrases.YEAR_NAN;
		}

		String option = "year";
		year = chatBot.filmsStructure.getFilmsByKey(option).containsKey(sYear) ? sYear : null;
		return getFilm(sYear, option, chatBot.phrases.yearPhrases);

	}

	private String getNextCountry(String sCountry) {
		String option = "country";
		country = chatBot.filmsStructure.getFilmsByKey(option).containsKey(sCountry) ? sCountry : null;
		return getFilm(sCountry, option, chatBot.phrases.countryPhrases);
	}

	private String tryGetNextFilm() {
		if (currentOpt == null)
			return Phrases.NEXT_WITHOUT_OPT;

		String key = getCurrentKey();

		String film = tryGetUnusedFilm(chatBot.filmsStructure.getFilmsByKey(currentOpt).get(key));

		return film != null ? film : chatBot.phrases.getDictByKey(currentOpt).get("all_films");
	}

	private String getFilm(String key, String option, Map<String, String> phrases) {
		currentOpt = option;
		Map<String, ArrayList<Film>> filmsDict = chatBot.filmsStructure.getFilmsByKey(option);

		if (!filmsDict.containsKey(key))
			return phrases.get("no_films");

		String film = tryGetUnusedFilm(filmsDict.get(key));
		return film != null ? film : phrases.get("all_films");
	}

	private String tryGetUnusedFilm(ArrayList<Film> films) {
		for (Film film : films) {
			if (user.savedFilms.contains(film))
				continue;
			user.addFilm(film);
			return film.getTitle();
		}
		return null;
	}

	private String getCurrentKey() {
		if (currentOpt == "year")
			return year;
		return country;

	}

}