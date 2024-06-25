package bmps.com.apiRest.hackerrank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorsResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Authors> data;
}
