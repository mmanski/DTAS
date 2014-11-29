package com.rasgrass.account;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import static com.rasgrass.config.MongoConfig.MONGO_DB_NAME;
import static com.rasgrass.config.MongoConfig.MONGO_HOST;
import static com.rasgrass.config.MongoConfig.MONGO_PORT;
import java.net.UnknownHostException;
import javax.inject.Inject;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository implements CrudRepository<Account, String> {

	
	@Inject
	private PasswordEncoder passwordEncoder;
	private final MongoClient mongoClient;
	private final MongoOperations mongoOperations;

	public AccountRepository() throws UnknownHostException {
		this.mongoClient = new MongoClient(MONGO_HOST, MONGO_PORT);
		mongoOperations = new MongoTemplate(new Mongo(), MONGO_DB_NAME, new UserCredentials("testUser", "DTa$"));
	}

	public Account findByEmail(String email) {
		try {
			return mongoOperations.findOne(new Query(Criteria.where("email").is(email)), Account.class);
		} catch (MongoException e) {
			return null;
		} finally {
			mongoClient.close();
		}
	}

	@Override
	public <S extends Account> S save(S account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		mongoOperations.save(account);
		return account;
	}

	@Override
	public <S extends Account> Iterable<S> save(Iterable<S> itrbl) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Account findOne(String id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean exists(String id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Iterable<Account> findAll() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Iterable<Account> findAll(Iterable<String> itrbl) {
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
	public void delete(Account t) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void delete(Iterable<? extends Account> itrbl) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void deleteAll() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
