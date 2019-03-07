package xyz.luan.rest.todos.todo;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;
import io.yawp.repository.annotations.Index;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Endpoint(path = "/todos")
@NoArgsConstructor
public class Todo {

	@Id
	private IdRef<Todo> id;

	@Index
	private String text;

	public Todo(String text) {
		this.text = text;
	}
}
