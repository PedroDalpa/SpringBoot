package academy.dev.esssencialspringboot.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BadRequestExceptionDetails {
    private String title, detail, developerMessage;
    private int status;
    private LocalDateTime timeStamp;
}
