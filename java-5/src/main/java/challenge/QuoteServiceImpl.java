package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	private Quote getRandomQuote(List<Quote> quoteList) {
		return quoteList.get(new Random().nextInt(quoteList.size()));
	}

	@Override
	public Quote getQuote() {
		return getRandomQuote(repository.findAll());
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		return getRandomQuote(repository.findQuotesByActor(actor));
	}

}
