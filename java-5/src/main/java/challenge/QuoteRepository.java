package challenge;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {

    List<Quote> findQuotesByActor(String actor);
}
