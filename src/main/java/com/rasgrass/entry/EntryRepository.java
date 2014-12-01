package com.rasgrass.entry;

import com.mongodb.Mongo;
import static com.rasgrass.config.MongoConfig.MONGO_DB_NAME;
import java.net.UnknownHostException;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RasGrass
 */
@Repository
public class EntryRepository implements CrudRepository<Entry, String> {

	private final MongoOperations mongoOperations;

	public EntryRepository() throws UnknownHostException {
		mongoOperations = new MongoTemplate(new Mongo(), MONGO_DB_NAME, new UserCredentials("testUser", "DTa$"));
	}

	@Override
	public <S extends Entry> S save(S s) {
		mongoOperations.save(s);
		return s;
	}

	@Override
	public <S extends Entry> Iterable<S> save(Iterable<S> itrbl) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Entry findOne(String id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean exists(String id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Iterable<Entry> findAll() {
		return mongoOperations.find(new Query(), Entry.class);
	}

	@Override
	public Iterable<Entry> findAll(Iterable<String> itrbl) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public long count() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void delete(String id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void delete(Entry t) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void delete(Iterable<? extends Entry> itrbl) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void deleteAll() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
