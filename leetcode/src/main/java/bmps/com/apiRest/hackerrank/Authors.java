package bmps.com.apiRest.hackerrank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Authors {
    private int id;
    private String username;
    private String about;
    private int submitted;
    private String updated_at;
    private int submission_count;
    private int comment_count;
    private long created_at;
}
