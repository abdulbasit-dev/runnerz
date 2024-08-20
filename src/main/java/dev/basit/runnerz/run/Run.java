package dev.basit.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        @NotNull
        LocalDateTime startedOn,
        @NotNull
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {

    public Run {
        if (startedOn != null && completedOn != null && !completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed date cannot be before start date");
        }
    }

}