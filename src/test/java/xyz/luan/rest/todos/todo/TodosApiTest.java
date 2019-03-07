package xyz.luan.rest.todos.todo;

import io.yawp.commons.utils.json.gson.GsonJsonUtils;
import io.yawp.repository.IdRef;
import org.junit.Test;
import xyz.luan.rest.todos.utils.EndpointTestCase;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TodosApiTest extends EndpointTestCase {

	@Test
	public void listTodosWhenThereAreNoTodos() {
		String result = get("/todos");
		assertThat(result).isEqualTo("[]");
	}

	@Test
	public void listTodosWhenThereAreTodos() {
		yawp.save(new Todo("hey"));

		String result = get("/todos");
		List<Todo> todos = new GsonJsonUtils().fromList(yawp, result, Todo.class);
		assertThat(todos.size()).isEqualTo(1);
		Todo todo = todos.get(0);
		assertThat(todo.getId()).isNotNull();
		assertThat(todo.getText()).isEqualTo("hey");
	}

	@Test
	public void createNewTodo() {
		String post = post("/todos", "{ \"text\": \"foo\" }");
		Todo created = new GsonJsonUtils().from(yawp, post, Todo.class);
		assertThat(created.getId()).isNotNull();
		assertThat(created.getText()).isEqualTo("foo");

		List<Todo> todos = yawp(Todo.class).list();
		assertThat(todos.size()).isEqualTo(1);
		Todo todo = todos.get(0);
		assertThat(todo.getId()).isEqualTo(created.getId());
		assertThat(todo.getText()).isEqualTo("foo");
	}

	@Test
	public void fetchById() {
		IdRef<Todo> todoId = yawp.save(new Todo("bar")).getId();

		String json = get("/todos/" + todoId.getId());
		Todo fetched = new GsonJsonUtils().from(yawp, json, Todo.class);
		assertThat(fetched.getId()).isEqualTo(todoId);
		assertThat(fetched.getText()).isEqualTo("bar");
	}
}
