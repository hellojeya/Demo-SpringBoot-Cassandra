package com.meetup.devops.cassandra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.driver.core.PlainTextAuthProvider;


@SpringBootApplication
@EnableCassandraRepositories(basePackages = { "com.meetup.devops.cassandra.domain" } )
public class SpringbootApplication extends AbstractCassandraConfiguration {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Bean
	public CassandraClusterFactoryBean cluster() {
		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(environment.getProperty("cassandra.contactpoints"));
		cluster.setPort(Integer.parseInt(environment.getProperty("cassandra.port")));
		cluster.setAuthProvider(authProvider());
		return cluster;
	}

	@Override
	protected String getKeyspaceName() {
		return environment.getProperty("cassandra.keyspace-name");
	}

	@Bean
	public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
		return new BasicCassandraMappingContext();
	}


	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.NONE;
	}

	//username/password
	@Bean
	public PlainTextAuthProvider authProvider()

	{

	return new PlainTextAuthProvider("cassandra","cassandra");

	}


}
