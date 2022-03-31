package academy.dev.esssencialspringboot.exception;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetails {
    private String title, detail, developerMessage;
    private int status;
    private LocalDateTime timeStamp;
}
