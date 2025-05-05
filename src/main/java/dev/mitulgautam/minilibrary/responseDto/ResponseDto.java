package dev.mitulgautam.minilibrary.responseDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto<T> {
    public T data;
    public String message;
    public String error;
}
