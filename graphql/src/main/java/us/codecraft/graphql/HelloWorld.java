package us.codecraft.graphql;

import graphql.GraphQL;
import graphql.schema.*;

import java.util.Map;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

/**
 * @author code4crafter@gmail.com
 *         Date: 16/12/17
 *         Time: 下午5:38
 */
public class HelloWorld {

	public static void main(String[] args) {

		DataFetcher calculateComplicatedValue = new DataFetcher() {
			@Override
			public Object get(DataFetchingEnvironment environment) {
				// environment.getSource() is the value of the surrounding
				// object. In this case described by objectType
				System.out.println(environment);
				return "212";
			}
		};

		GraphQLObjectType objectType = newObject()
				.name("query")
				.field(newFieldDefinition()
						.name("user")
						.type(GraphQLString)
						.argument(newArgument()
								.name("id")
								.type(GraphQLString)
								.build()
						)
						.dataFetcher(calculateComplicatedValue))
				.build();

		GraphQLSchema schema = GraphQLSchema.newSchema()
				.query(objectType)
				.build();

		Map<String, Object> result = (Map<String, Object>) new GraphQL(schema).execute("{user(id:\"1\")}").getData();

		System.out.println(result);
		// Prints: {hello=world}
	}
}
