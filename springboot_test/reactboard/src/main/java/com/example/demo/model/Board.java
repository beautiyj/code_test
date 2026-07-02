package springboot_test.reactboard.src.main.java.com.example.demo.model;

import org.apache.ibatis.type.Alias;
import lombok.Data;

@Data
@Alias("board")
public class Board {
	private String title;
	private String content;
}
