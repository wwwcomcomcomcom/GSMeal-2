package wwwcomcom.gsmeal.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
public class ResultDTO<T> {

    private final int resultCode;
    private final T data;

}